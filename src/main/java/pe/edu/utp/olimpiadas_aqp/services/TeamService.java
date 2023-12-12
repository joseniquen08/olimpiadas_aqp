package pe.edu.utp.olimpiadas_aqp.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.olimpiadas_aqp.entities.CategoryEntity;
import pe.edu.utp.olimpiadas_aqp.entities.SportEventEntity;
import pe.edu.utp.olimpiadas_aqp.entities.TeamEntity;
import pe.edu.utp.olimpiadas_aqp.models.requests.team.TeamReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.team.*;
import pe.edu.utp.olimpiadas_aqp.repositories.CategoryRepository;
import pe.edu.utp.olimpiadas_aqp.repositories.SportEventRepository;
import pe.edu.utp.olimpiadas_aqp.repositories.TeamRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService implements TeamServiceInterface {
    
    @Autowired
    TeamRepository teamRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    SportEventRepository sportEventRepository;

    @Override
    public List<GetTeamRes> getAll() {
        List<TeamEntity> teams = teamRepository.findAll();
        List<GetTeamRes> response = new ArrayList<>();
        for (TeamEntity team : teams) {
            GetTeamRes teamRes = new GetTeamRes();
            BeanUtils.copyProperties(team, teamRes);
            response.add(teamRes);
        }
        return response;
    }

    @Override
    public GetTeamsByCategoryIdRes getByCategoryId(Long categoryId) {
        List<TeamEntity> teamsRes = teamRepository.findByCategoryId(categoryId);
        GetTeamsByCategoryIdRes response = new GetTeamsByCategoryIdRes();
        List<GetTeamRes> teams = new ArrayList<>();
        for (TeamEntity team : teamsRes) {
            GetTeamRes teamRes = new GetTeamRes();
            BeanUtils.copyProperties(team, teamRes);
            teams.add(teamRes);
        }
        response.setTeams(teams);
        CategoryEntity categoryEntity;
        Optional<CategoryEntity> findByIdRes = categoryRepository.findById(categoryId);
        if (findByIdRes.isPresent()) {
            categoryEntity = findByIdRes.get();
            SportEventEntity sportEventEntity;
            Optional<SportEventEntity> findBySportEventIdRes = sportEventRepository.findById(categoryEntity.getSportEvent().getSportEventId());
            if (findBySportEventIdRes.isPresent()) {
                sportEventEntity = findBySportEventIdRes.get();
                response.setEventName(sportEventEntity.getEvent().getName());
                response.setSportName(sportEventEntity.getSport().getName());
            }
            response.setCategoryName(categoryEntity.getName());
        }
        return response;
    }

    @Override
    public CreateTeamRes createEvent(TeamReq teamReq) {
        TeamEntity teamEntity = new TeamEntity();
        CategoryEntity categoryEntity = new CategoryEntity();
        CreateTeamRes response = new CreateTeamRes();
        GetTeamRes teamRes = new GetTeamRes();
        BeanUtils.copyProperties(teamReq, teamEntity);
        categoryEntity.setCategoryId(teamReq.getCategoryId());
        teamEntity.setCategory(categoryEntity);
        teamRepository.save(teamEntity);
        BeanUtils.copyProperties(teamEntity, teamRes);
        response.setMessage("Equipo creado correctamente.");
        response.setStatus(201);
        response.setTeam(teamRes);
        return response;
    }

    @Override
    public EditTeamRes editTeamById(Long teamId, TeamReq teamReq) {
        EditTeamRes response = new EditTeamRes();
        int isCorrect = teamRepository.editById(
                teamId,
                teamReq.getName(),
                teamReq.getImageUrl());
        if (isCorrect == 1) {
            response.setStatus(204);
            response.setMessage("Editado correctamente.");
        } else {
            response.setStatus(400);
            response.setMessage("Error en la edición.");
        }
        return response;
    }

    @Override
    public DeleteTeamRes deleteTeamById(Long teamId) {
        DeleteTeamRes response = new DeleteTeamRes();
        teamRepository.deleteById(teamId);
        response.setStatus(204);
        response.setMessage("Eliminado correctamente.");
        return response;
    }
}
