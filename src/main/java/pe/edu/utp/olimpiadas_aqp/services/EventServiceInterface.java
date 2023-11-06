package pe.edu.utp.olimpiadas_aqp.services;

import pe.edu.utp.olimpiadas_aqp.models.requests.event.ChangeEventStatusReq;
import pe.edu.utp.olimpiadas_aqp.models.requests.event.EventReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.event.CreateEventRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.event.DeleteEventRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.event.EditEventRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.event.GetEventRes;

import java.util.List;

public interface EventServiceInterface {
    List<GetEventRes> getAll();
    CreateEventRes createEvent(EventReq eventReq);
    EditEventRes editEventById(Long eventId, EventReq eventReq);
    EditEventRes editEventStatusById(Long eventId, ChangeEventStatusReq statusReq);
    DeleteEventRes deleteEventById(Long eventId);
}
