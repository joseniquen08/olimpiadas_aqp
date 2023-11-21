package pe.edu.utp.olimpiadas_aqp.services;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.utp.olimpiadas_aqp.entities.PlayerEntity;
import pe.edu.utp.olimpiadas_aqp.entities.TeamEntity;
import pe.edu.utp.olimpiadas_aqp.models.requests.player.PlayerReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.player.CreatePlayerRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.player.DeletePlayerRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.player.EditPlayerRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.player.GetPlayerRes;
import pe.edu.utp.olimpiadas_aqp.repositories.PlayerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService implements PlayerServiceInterface{
    @Autowired
    PlayerRepository playerRepository;

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
                playerReq.getDateBirth(),
                playerReq.getSize(),
                playerReq.getWeight(),
                playerReq.getNumberTshirt());
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
