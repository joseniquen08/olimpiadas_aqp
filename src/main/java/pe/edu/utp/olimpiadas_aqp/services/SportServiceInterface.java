package pe.edu.utp.olimpiadas_aqp.services;

import pe.edu.utp.olimpiadas_aqp.models.requests.event.EventReq;
import pe.edu.utp.olimpiadas_aqp.models.requests.sport.SportReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.event.EditEventRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.sport.*;

import java.util.List;

public interface SportServiceInterface {
    List<GetSportRes> getAll();
    GetSportsByEventIdRes getSportsByEventId(Long eventId);
    GetSportsByEventIdRes getSportsByEventIdAndDelegateId(Long eventId, Long delegateId);
    CreateSportRes createSport(SportReq sportReq);
    EditSportRes editSportById(Long sportId, SportReq sportReq);
    DeleteSportRes deleteSportById(Long sportId);
}
