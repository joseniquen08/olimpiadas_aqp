package pe.edu.utp.olimpiadas_aqp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.olimpiadas_aqp.models.requests.sport.SportReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.sport.*;
import pe.edu.utp.olimpiadas_aqp.services.SportServiceInterface;

import java.util.List;

@RestController
@RequestMapping("/api/sport")
public class SportController {

    @Autowired
    SportServiceInterface sportService;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<GetSportRes> getAll() {
        return sportService.getAll();
    }

    @RequestMapping(value = "all/event/{id}", method = RequestMethod.GET)
    public GetSportsByEventIdRes getSportsByEventId(@PathVariable("id") Long eventId) {
        return sportService.getSportsByEventId(eventId);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public CreateSportRes create(@RequestBody SportReq sportReq) {
        return sportService.createSport(sportReq);
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.PUT)
    public EditSportRes editById(@PathVariable("id") Long sportId, @RequestBody SportReq sportReq) {
        return sportService.editSportById(sportId, sportReq);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public DeleteSportRes deleteById(@PathVariable("id") Long sportId) {
        return sportService.deleteSportById(sportId);
    }
}
