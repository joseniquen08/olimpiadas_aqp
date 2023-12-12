package pe.edu.utp.olimpiadas_aqp.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pe.edu.utp.olimpiadas_aqp.entities.*;
import pe.edu.utp.olimpiadas_aqp.models.requests.event.AssignSportToEventReq;
import pe.edu.utp.olimpiadas_aqp.models.requests.event.ChangeEventStatusReq;
import pe.edu.utp.olimpiadas_aqp.models.requests.event.EventReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.event.*;
import pe.edu.utp.olimpiadas_aqp.repositories.ClientRepository;
import pe.edu.utp.olimpiadas_aqp.repositories.EventRepository;
import pe.edu.utp.olimpiadas_aqp.repositories.SportEventRepository;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class EventService implements EventServiceInterface {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    SportEventRepository sportEventRepository;

    @Autowired
    EmailServiceInterface emailService;

    @Override
    public List<GetEventRes> getAll() {
        List<Sort.Order> orders = new ArrayList<>();
        Sort.Order statusOrder = new Sort.Order(Sort.Direction.DESC, "status");
        Sort.Order startDateOrder = new Sort.Order(Sort.Direction.ASC, "startDate");
        orders.add(statusOrder);
        orders.add(startDateOrder);
        List<EventEntity> events = eventRepository.findAll(Sort.by(orders));
        List<GetEventRes> response = new ArrayList<>();
        for (EventEntity event: events) {
            GetEventRes eventRes = new GetEventRes();
            BeanUtils.copyProperties(event, eventRes);
            eventRes.setClientId(event.getClient().getClientId());
            eventRes.setClient(event.getClient().getUser().getFullName());
            eventRes.setRepresentative(event.getClient().getRepresentative());
            eventRes.setPhone(event.getClient().getPhone());
            response.add(eventRes);
        }
        return response;
    }

    @Override
    public List<GetEventRes> getByClientId(Long clientId) {
        List<Sort.Order> orders = new ArrayList<>();
        Sort.Order statusOrder = new Sort.Order(Sort.Direction.DESC, "status");
        Sort.Order startDateOrder = new Sort.Order(Sort.Direction.ASC, "start_date");
        orders.add(statusOrder);
        orders.add(startDateOrder);
        List<EventEntity> events = eventRepository.findByClientId(clientId, PageRequest.of(0, 1000, Sort.by(orders)));
        List<GetEventRes> response = new ArrayList<>();
        for (EventEntity event: events) {
            GetEventRes eventRes = new GetEventRes();
            BeanUtils.copyProperties(event, eventRes);
            eventRes.setClientId(event.getClient().getClientId());
            eventRes.setClient(event.getClient().getUser().getFullName());
            eventRes.setRepresentative(event.getClient().getRepresentative());
            eventRes.setPhone(event.getClient().getPhone());
            response.add(eventRes);
        }
        return response;
    }

    @Override
    public List<GetEventRes> getByDelegateId(Long delegateId) {
        List<Sort.Order> orders = new ArrayList<>();
        Sort.Order statusOrder = new Sort.Order(Sort.Direction.DESC, "status");
        Sort.Order startDateOrder = new Sort.Order(Sort.Direction.ASC, "start_date");
        orders.add(statusOrder);
        orders.add(startDateOrder);
        List<EventEntity> events = eventRepository.findByDelegateId(delegateId, PageRequest.of(0, 1000, Sort.by(orders)));
        List<GetEventRes> response = new ArrayList<>();
        for (EventEntity event: events) {
            GetEventRes eventRes = new GetEventRes();
            BeanUtils.copyProperties(event, eventRes);
            eventRes.setClientId(event.getClient().getClientId());
            eventRes.setClient(event.getClient().getUser().getFullName());
            eventRes.setRepresentative(event.getClient().getRepresentative());
            eventRes.setPhone(event.getClient().getPhone());
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
        Optional<ClientEntity> clientRes = clientRepository.findById(eventReq.getClientId());
        if (clientRes.isPresent()) {
            String email = clientRes.get().getUser().getEmail();
            String clientName = clientRes.get().getUser().getFullName();
            String subject = "Evento " + eventReq.getName();
            Locale locale = new Locale("es", "PE");
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
            String date = dateFormat.format(eventReq.getStartDate());
            String text = "¡Hola, " + clientName + "!"
                    +"\n\nTu evento *" + eventReq.getName() + "* ha sido creado satisfactoriamente."
                    + "\n\nFecha de inicio: " + date
                    + "\n\nAtte. Olimpiadas AQP";
            emailService.sendSimpleMessage(email, subject, text);
        }
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

    @Override
    public DeleteEventRes deleteEventById(Long eventId) {
        DeleteEventRes response = new DeleteEventRes();
        eventRepository.deleteById(eventId);
        response.setStatus(204);
        response.setMessage("Eliminado correctamente.");
        return response;
    }

    @Override
    public AssignSportToEventRes assignSportToEvent(AssignSportToEventReq sportToEventReq) {
        AssignSportToEventRes response = new AssignSportToEventRes();
        SportEventEntity sportEventEntity = new SportEventEntity();
        SportEntity sportEntity = new SportEntity();
        EventEntity eventEntity = new EventEntity();
        DelegateEntity delegateEntity = new DelegateEntity();
        sportEntity.setSportId(sportToEventReq.getSportId());
        eventEntity.setEventId(sportToEventReq.getEventId());
        delegateEntity.setDelegateId(sportToEventReq.getDelegateId());
        sportEventEntity.setSport(sportEntity);
        sportEventEntity.setEvent(eventEntity);
        sportEventEntity.setDelegate(delegateEntity);
        sportEventRepository.save(sportEventEntity);
        response.setMessage("Deporte asignado correctamente");
        response.setStatus(201);
        return response;
    }

    @Override
    public UnassignSportRes unassignSport(Long sportEventId) {
        UnassignSportRes response = new UnassignSportRes();
        sportEventRepository.deleteById(sportEventId);
        response.setStatus(204);
        response.setMessage("Eliminado correctamente.");
        return response;
    }
}
