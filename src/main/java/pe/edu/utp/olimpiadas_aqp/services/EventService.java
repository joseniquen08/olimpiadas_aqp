package pe.edu.utp.olimpiadas_aqp.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.utp.olimpiadas_aqp.entities.ClientEntity;
import pe.edu.utp.olimpiadas_aqp.entities.EventEntity;
import pe.edu.utp.olimpiadas_aqp.models.requests.event.ChangeEventStatusReq;
import pe.edu.utp.olimpiadas_aqp.models.requests.event.EventReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.event.CreateEventRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.event.EditEventRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.event.GetEventRes;
import pe.edu.utp.olimpiadas_aqp.repositories.EventRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService implements EventServiceInterface {

    @Autowired
    EventRepository eventRepository;

    @Override
    public List<GetEventRes> getAll() {
        List<EventEntity> events = eventRepository.findAll();
        List<GetEventRes> response = new ArrayList<>();
        for (EventEntity event: events) {
            GetEventRes eventRes = new GetEventRes();
            BeanUtils.copyProperties(event, eventRes);
            eventRes.setClientId(event.getClient().getClientId());
            eventRes.setClient(event.getClient().getUser().getFullName());
            response.add(eventRes);
        }
        return response;
    }

    @Override
    public CreateEventRes createEvent(EventReq eventReq) {
        EventEntity eventEntity = new EventEntity();
        ClientEntity clientEntity = new ClientEntity();
        CreateEventRes response = new CreateEventRes();
        GetEventRes eventRes = new GetEventRes();
        clientEntity.setClientId(eventReq.getClientId());
        BeanUtils.copyProperties(eventReq, eventEntity);
        eventEntity.setClient(clientEntity);
        eventRepository.save(eventEntity);
        BeanUtils.copyProperties(eventEntity, eventRes);
        response.setMessage("Evento creado correctamente.");
        response.setStatus(201);
        response.setEvent(eventRes);
        return response;
    }

    @Override
    public EditEventRes editEventById(Long eventId, EventReq eventReq) {
        EditEventRes response = new EditEventRes();
        int isCorrect = eventRepository.editById(
                eventId,
                eventReq.getName(),
                eventReq.getStartDate(),
                eventReq.getStatus(),
                eventReq.getClientId());
        if (isCorrect == 1) {
            response.setStatus(204);
            response.setMessage("Editado correctamente.");
        } else {
            response.setStatus(400);
            response.setMessage("Error en la edición.");
        }
        return response;
    }

    @Override
    public EditEventRes editEventStatusById(Long eventId, ChangeEventStatusReq statusReq) {
        EditEventRes response = new EditEventRes();
        int isCorrect = eventRepository.changeStatusById(
                eventId,
                statusReq.getStatus());
        if (isCorrect == 1) {
            response.setStatus(204);
            response.setMessage("Editado correctamente.");
        } else {
            response.setStatus(400);
            response.setMessage("Error en la edición.");
        }
        return response;
    }
}
