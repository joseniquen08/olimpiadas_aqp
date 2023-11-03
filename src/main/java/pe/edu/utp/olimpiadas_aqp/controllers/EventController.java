package pe.edu.utp.olimpiadas_aqp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.utp.olimpiadas_aqp.models.requests.event.EventReq;
import pe.edu.utp.olimpiadas_aqp.models.requests.user.client.ClientReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.event.CreateEventRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.event.GetEventRes;
import pe.edu.utp.olimpiadas_aqp.services.EventServiceInterface;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    EventServiceInterface eventService;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<GetEventRes> getAll() {
        return eventService.getAll();
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public CreateEventRes create(@RequestBody EventReq eventReq) {
        return eventService.createEvent(eventReq);
    }
}
