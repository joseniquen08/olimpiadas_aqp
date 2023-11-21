package pe.edu.utp.olimpiadas_aqp.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.olimpiadas_aqp.entities.CategoryEntity;
import pe.edu.utp.olimpiadas_aqp.entities.TeamEntity;
import pe.edu.utp.olimpiadas_aqp.models.requests.team.TeamReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.team.CreateTeamRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.team.DeleteTeamRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.team.EditTeamRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.team.GetTeamRes;
import pe.edu.utp.olimpiadas_aqp.repositories.TeamRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService implements TeamServiceInterface {
    
    @Autowired
    TeamRepository teamRepository;

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
