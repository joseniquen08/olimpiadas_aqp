package pe.edu.utp.olimpiadas_aqp.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.utp.olimpiadas_aqp.entities.EventEntity;
import pe.edu.utp.olimpiadas_aqp.entities.SportEntity;
import pe.edu.utp.olimpiadas_aqp.entities.SportEventEntity;
import pe.edu.utp.olimpiadas_aqp.models.requests.sport.SportReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.sport.*;
import pe.edu.utp.olimpiadas_aqp.repositories.CategoryRepository;
import pe.edu.utp.olimpiadas_aqp.repositories.EventRepository;
import pe.edu.utp.olimpiadas_aqp.repositories.SportEventRepository;
import pe.edu.utp.olimpiadas_aqp.repositories.SportRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SportService implements SportServiceInterface {

    @Autowired
    SportRepository sportRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    SportEventRepository sportEventRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<GetSportRes> getAll() {
        List<SportEntity> sports = sportRepository.findAll();
        List<GetSportRes> response = new ArrayList<>();
        for (SportEntity sport: sports) {
            GetSportRes sportRes = new GetSportRes();
            BeanUtils.copyProperties(sport, sportRes);
            response.add(sportRes);
        }
        return response;
    }

    @Override
    public GetSportsByEventIdRes getSportsByEventId(Long eventId) {
        List<SportEventEntity> sportEvents = sportEventRepository.findByEventId(eventId);
        GetSportsByEventIdRes response = new GetSportsByEventIdRes();
        List<GetSportsEventRes> sports = new ArrayList<>();
        for (SportEventEntity sportEvent: sportEvents) {
            GetSportsEventRes sportsEventRes = new GetSportsEventRes();
            BeanUtils.copyProperties(sportEvent.getSport(), sportsEventRes);
            sportsEventRes.setDelegate(sportEvent.getDelegate().getUser().getFullName());
            sportsEventRes.setSportEventId(sportEvent.getSportEventId());
            int totalCategories = categoryRepository.findBySportEventId(sportEvent.getSportEventId()).size();
            sportsEventRes.setTotalCategories(totalCategories);
            sports.add(sportsEventRes);
        }
        response.setSports(sports);
        EventEntity eventEntity;
        Optional<EventEntity> findByIdRes = eventRepository.findById(eventId);
        if (findByIdRes.isPresent()) {
            eventEntity = findByIdRes.get();
            response.setEventName(eventEntity.getName());
        }
        return response;
    }

    @Override
    public GetSportsByEventIdRes getSportsByEventIdAndDelegateId(Long eventId, Long delegateId) {
        List<SportEventEntity> sportEvents = sportEventRepository.findByEventIdAndDelegateId(eventId, delegateId);
        GetSportsByEventIdRes response = new GetSportsByEventIdRes();
        List<GetSportsEventRes> sports = new ArrayList<>();
        for (SportEventEntity sportEvent: sportEvents) {
            GetSportsEventRes sportsEventRes = new GetSportsEventRes();
            BeanUtils.copyProperties(sportEvent.getSport(), sportsEventRes);
            sportsEventRes.setDelegate(sportEvent.getDelegate().getUser().getFullName());
            sportsEventRes.setSportEventId(sportEvent.getSportEventId());
            int totalCategories = categoryRepository.findBySportEventId(sportEvent.getSportEventId()).size();
            sportsEventRes.setTotalCategories(totalCategories);
            sports.add(sportsEventRes);
        }
        response.setSports(sports);
        EventEntity eventEntity;
        Optional<EventEntity> findByIdRes = eventRepository.findById(eventId);
        if (findByIdRes.isPresent()) {
            eventEntity = findByIdRes.get();
            response.setEventName(eventEntity.getName());
        }
        return response;
    }

    @Override
    public CreateSportRes createSport(SportReq sportReq) {
        SportEntity sportEntity = new SportEntity();
        CreateSportRes response = new CreateSportRes();
        GetSportRes sportRes = new GetSportRes();
        BeanUtils.copyProperties(sportReq, sportEntity);
        sportRepository.save(sportEntity);
        BeanUtils.copyProperties(sportEntity, sportRes);
        response.setMessage("Deporte creado correctamente.");
        response.setStatus(201);
        response.setSport(sportRes);
        return response;
    }

    @Override
    public EditSportRes editSportById(Long sportId, SportReq sportReq) {
        EditSportRes response = new EditSportRes();
        int isCorrect = sportRepository.editById(
                sportId,
                sportReq.getName(),
                sportReq.getDescription());
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
    public DeleteSportRes deleteSportById(Long sportId) {
        DeleteSportRes response = new DeleteSportRes();
        sportRepository.deleteById(sportId);
        response.setStatus(204);
        response.setMessage("Eliminado correctamente.");
        return response;
    }
}
