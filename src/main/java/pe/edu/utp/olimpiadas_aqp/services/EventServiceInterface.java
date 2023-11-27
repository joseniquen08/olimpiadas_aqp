package pe.edu.utp.olimpiadas_aqp.services;

import pe.edu.utp.olimpiadas_aqp.models.requests.event.AssignDelegateToEventReq;
import pe.edu.utp.olimpiadas_aqp.models.requests.event.AssignSportToEventReq;
import pe.edu.utp.olimpiadas_aqp.models.requests.event.ChangeEventStatusReq;
import pe.edu.utp.olimpiadas_aqp.models.requests.event.EventReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.event.*;

import java.util.List;

public interface EventServiceInterface {
    List<GetEventRes> getAll();
    CreateEventRes createEvent(EventReq eventReq);
    EditEventRes editEventById(Long eventId, EventReq eventReq);
    EditEventRes editEventStatusById(Long eventId, ChangeEventStatusReq statusReq);
    DeleteEventRes deleteEventById(Long eventId);
    AssignSportToEventRes assignSportToEvent(AssignSportToEventReq sportToEventReq);
    AssignDelegateToEventRes assignDelegateToEvent(AssignDelegateToEventReq delegateToEventReq);
    UnassignSportRes unassignSport(Long sportEventId);
    UnassignDelegateRes unassignDelegate(Long delegateEventId);
}
