package pe.edu.utp.olimpiadas_aqp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.olimpiadas_aqp.models.requests.event.ChangeEventStatusReq;
import pe.edu.utp.olimpiadas_aqp.models.requests.event.EventReq;
import pe.edu.utp.olimpiadas_aqp.models.requests.user.client.ClientReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.event.CreateEventRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.event.DeleteEventRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.event.EditEventRes;
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

    @RequestMapping(value = "edit/{id}", method = RequestMethod.PUT)
    public EditEventRes editById(@PathVariable("id") Long eventId, @RequestBody EventReq eventReq) {
        return eventService.editEventById(eventId, eventReq);
    }

    @RequestMapping(value = "edit/status/{id}", method = RequestMethod.PUT)
    public EditEventRes editStatusById(@PathVariable("id") Long eventId, @RequestBody ChangeEventStatusReq statusReq) {
        return eventService.editEventStatusById(eventId, statusReq);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public DeleteEventRes deleteById(@PathVariable("id") Long eventId) {
        return eventService.deleteEventById(eventId);
    }
}
