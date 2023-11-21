package pe.edu.utp.olimpiadas_aqp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.olimpiadas_aqp.models.requests.team.TeamReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.event.DeleteEventRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.team.CreateTeamRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.team.DeleteTeamRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.team.EditTeamRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.team.GetTeamRes;
import pe.edu.utp.olimpiadas_aqp.services.TeamServiceInterface;

import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamController {
    
    @Autowired
    TeamServiceInterface teamService;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<GetTeamRes> getAll() {
        return teamService.getAll();
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public CreateTeamRes create(@RequestBody TeamReq teamReq) {
        return teamService.createEvent(teamReq);
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.PUT)
    public EditTeamRes editById(@PathVariable("id") Long teamId, @RequestBody TeamReq teamReq) {
        return teamService.editTeamById(teamId, teamReq);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public DeleteTeamRes deleteById(@PathVariable("id") Long teamId) {
        return teamService.deleteTeamById(teamId);
    }
}
