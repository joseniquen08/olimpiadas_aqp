package pe.edu.utp.olimpiadas_aqp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.utp.olimpiadas_aqp.models.requests.event.EventReq;
import pe.edu.utp.olimpiadas_aqp.models.requests.sport.SportReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.event.CreateEventRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.sport.CreateSportRes;
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
}
