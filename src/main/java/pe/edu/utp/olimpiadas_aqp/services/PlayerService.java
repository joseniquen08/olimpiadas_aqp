package pe.edu.utp.olimpiadas_aqp.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.utp.olimpiadas_aqp.entities.CategoryEntity;
import pe.edu.utp.olimpiadas_aqp.entities.PlayerEntity;
import pe.edu.utp.olimpiadas_aqp.entities.SportEventEntity;
import pe.edu.utp.olimpiadas_aqp.entities.TeamEntity;
import pe.edu.utp.olimpiadas_aqp.models.requests.player.PlayerReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.player.*;
import pe.edu.utp.olimpiadas_aqp.models.responses.team.GetTeamRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.team.GetTeamsByCategoryIdRes;
import pe.edu.utp.olimpiadas_aqp.repositories.CategoryRepository;
import pe.edu.utp.olimpiadas_aqp.repositories.PlayerRepository;
import pe.edu.utp.olimpiadas_aqp.repositories.SportEventRepository;
import pe.edu.utp.olimpiadas_aqp.repositories.TeamRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService implements PlayerServiceInterface{

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    SportEventRepository sportEventRepository;

    @Override
    public List<GetPlayerRes> getAll() {
        List<PlayerEntity> players = playerRepository.findAll();
        List<GetPlayerRes> response = new ArrayList<>();
        for (PlayerEntity player : players) {
            GetPlayerRes playerRes = new GetPlayerRes();
            BeanUtils.copyProperties(player, playerRes);
            response.add(playerRes);
        }
        return response;
    }

    @Override
    public GetPlayersByTeamIdRes getByTeamId(Long teamId) {
        List<PlayerEntity>playersRes = playerRepository.findByTeamId(teamId);
        GetPlayersByTeamIdRes response = new GetPlayersByTeamIdRes();
        List<GetPlayerRes> players = new ArrayList<>();
        for (PlayerEntity player : playersRes) {
            GetPlayerRes playerRes = new GetPlayerRes();
            BeanUtils.copyProperties(player, playerRes);
            players.add(playerRes);
        }
        response.setPlayers(players);
        TeamEntity teamEntity;
        Optional<TeamEntity> findByIdRes = teamRepository.findById(teamId);
        if (findByIdRes.isPresent()) {
            teamEntity = findByIdRes.get();
            CategoryEntity categoryEntity;
            Optional<CategoryEntity> findByCategoryIdRes = categoryRepository.findById(teamEntity.getCategory().getCategoryId());
            if (findByCategoryIdRes.isPresent()) {
                categoryEntity = findByCategoryIdRes.get();
                SportEventEntity sportEventEntity;
                Optional<SportEventEntity> findBySportEventIdRes = sportEventRepository.findById(categoryEntity.getSportEvent().getSportEventId());
                if (findBySportEventIdRes.isPresent()) {
                    sportEventEntity = findBySportEventIdRes.get();
                    response.setEventName(sportEventEntity.getEvent().getName());
                    response.setSportName(sportEventEntity.getSport().getName());
                }
                response.setCategoryName(categoryEntity.getName());
            }
            response.setTeamName(teamEntity.getName());
        }
        return response;
    }

    @Override
    public CreatePlayerRes createEvent(PlayerReq playerReq) {
        PlayerEntity playerEntity = new PlayerEntity();
        TeamEntity teamEntity = new TeamEntity();
        CreatePlayerRes response = new CreatePlayerRes();
        GetPlayerRes playerRes = new GetPlayerRes();
        BeanUtils.copyProperties(playerReq, playerEntity);
        teamEntity.setTeamId(playerReq.getTeamId());
        playerEntity.setTeam(teamEntity);
        playerRepository.save(playerEntity);
        BeanUtils.copyProperties(playerEntity, playerRes);
        response.setMessage("Jugador creado correctamente.");
        response.setStatus(201);
        response.setPlayer(playerRes);
        return response;
    }

    @Override
    public EditPlayerRes editPlayerById(Long playerId, PlayerReq playerReq) {
        EditPlayerRes response = new EditPlayerRes();
        int isCorrect = playerRepository.editById(
                playerId,
                playerReq.getName(),
                playerReq.getGender(),
                playerReq.getBirthdate(),
                playerReq.getHeight(),
                playerReq.getWeight(),
                playerReq.getJerseyNumber());
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
    public DeletePlayerRes deletePlayerById(Long playerId) {
        DeletePlayerRes response = new DeletePlayerRes();
        playerRepository.deleteById(playerId);
        response.setStatus(204);
        response.setMessage("Eliminado correctamente.");
        return response;
    }
}
