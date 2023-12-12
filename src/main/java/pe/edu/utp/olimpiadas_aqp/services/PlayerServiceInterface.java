package pe.edu.utp.olimpiadas_aqp.services;
import pe.edu.utp.olimpiadas_aqp.models.requests.player.PlayerReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.player.*;

import java.util.List;

public interface PlayerServiceInterface {
    List<GetPlayerRes> getAll();
    GetPlayersByTeamIdRes getByTeamId(Long teamId);
    CreatePlayerRes createEvent(PlayerReq playerReq);
    EditPlayerRes editPlayerById(Long playerId, PlayerReq playerReq);
    DeletePlayerRes deletePlayerById(Long playerId);
}
