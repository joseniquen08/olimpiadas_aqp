package pe.edu.utp.olimpiadas_aqp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.olimpiadas_aqp.models.requests.event.AssignDelegateToEventReq;
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

    @RequestMapping(value = "assign/delegate", method = RequestMethod.POST)
    public AssignDelegateToEventRes assignDelegate(@RequestBody AssignDelegateToEventReq delegateToEventReq) {
        return eventService.assignDelegateToEvent(delegateToEventReq);
    }

    @RequestMapping(value = "unassign/sport/{id}", method = RequestMethod.DELETE)
    public UnassignSportRes unassignSport(@PathVariable("id") Long sportEventId) {
        return eventService.unassignSport(sportEventId);
    }

    @RequestMapping(value = "unassign/delegate/{id}", method = RequestMethod.DELETE)
    public UnassignDelegateRes unassignDelegate(@PathVariable("id") Long delegateEventId) {
        return eventService.unassignDelegate(delegateEventId);
    }
}
