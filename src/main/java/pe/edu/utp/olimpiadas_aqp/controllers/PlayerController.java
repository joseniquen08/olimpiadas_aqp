package pe.edu.utp.olimpiadas_aqp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.olimpiadas_aqp.models.requests.player.PlayerReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.player.*;
import pe.edu.utp.olimpiadas_aqp.services.PlayerServiceInterface;

import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerController {
    
    @Autowired
    PlayerServiceInterface playerService;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<GetPlayerRes> getAll() {
        return playerService.getAll();
    }

    @RequestMapping(value = "all/team/{id}", method = RequestMethod.GET)
    public GetPlayersByTeamIdRes getByTeamId(@PathVariable("id") Long teamId) {
        return playerService.getByTeamId(teamId);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public CreatePlayerRes create(@RequestBody PlayerReq playerReq) {
        return playerService.createEvent(playerReq);
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.PUT)
    public EditPlayerRes editById(@PathVariable("id") Long playerId, @RequestBody PlayerReq playerReq) {
        return playerService.editPlayerById(playerId, playerReq);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public DeletePlayerRes deleteById(@PathVariable("id") Long playerId) {
        return playerService.deletePlayerById(playerId);
    }
}
