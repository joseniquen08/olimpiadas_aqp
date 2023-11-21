package pe.edu.utp.olimpiadas_aqp.services;
import pe.edu.utp.olimpiadas_aqp.models.requests.player.PlayerReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.player.CreatePlayerRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.player.DeletePlayerRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.player.EditPlayerRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.player.GetPlayerRes;

import java.util.List;

public interface PlayerServiceInterface {
    List<GetPlayerRes> getAll();
    CreatePlayerRes createEvent(PlayerReq playerReq);
    EditPlayerRes editPlayerById(Long playerId, PlayerReq playerReq);
    DeletePlayerRes deletePlayerById(Long playerId);
}
