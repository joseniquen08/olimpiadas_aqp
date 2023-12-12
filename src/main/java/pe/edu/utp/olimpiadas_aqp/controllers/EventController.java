package pe.edu.utp.olimpiadas_aqp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.olimpiadas_aqp.models.requests.event.AssignSportToEventReq;
import pe.edu.utp.olimpiadas_aqp.models.requests.event.ChangeEventStatusReq;
import pe.edu.utp.olimpiadas_aqp.models.requests.event.EventReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.event.*;
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

    @RequestMapping(value = "all/client/{id}", method = RequestMethod.GET)
    public List<GetEventRes> getByClientId(@PathVariable("id") Long clientId) {
        return eventService.getByClientId(clientId);
    }

    @RequestMapping(value = "all/delegate/{id}", method = RequestMethod.GET)
    public List<GetEventRes> getByDelegateId(@PathVariable("id") Long delegateId) {
        return eventService.getByDelegateId(delegateId);
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

    @RequestMapping(value = "assign/sport", method = RequestMethod.POST)
    public AssignSportToEventRes assignSport(@RequestBody AssignSportToEventReq sportToEventReq) {
        return eventService.assignSportToEvent(sportToEventReq);
    }

    @RequestMapping(value = "unassign/sport/{id}", method = RequestMethod.DELETE)
    public UnassignSportRes unassignSport(@PathVariable("id") Long sportEventId) {
        return eventService.unassignSport(sportEventId);
    }
}
