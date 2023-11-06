package pe.edu.utp.olimpiadas_aqp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.olimpiadas_aqp.models.requests.sport.SportReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.event.DeleteEventRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.sport.CreateSportRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.sport.DeleteSportRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.sport.EditSportRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.sport.GetSportRes;
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

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public CreateSportRes create(@RequestBody SportReq sportReq) {
        return sportService.createEvent(sportReq);
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
