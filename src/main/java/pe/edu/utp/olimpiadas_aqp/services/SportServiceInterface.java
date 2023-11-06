package pe.edu.utp.olimpiadas_aqp.services;

import pe.edu.utp.olimpiadas_aqp.models.requests.event.EventReq;
import pe.edu.utp.olimpiadas_aqp.models.requests.sport.SportReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.event.EditEventRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.sport.CreateSportRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.sport.DeleteSportRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.sport.EditSportRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.sport.GetSportRes;

import java.util.List;

public interface SportServiceInterface {
    List<GetSportRes> getAll();
    CreateSportRes createEvent(SportReq sportReq);

    EditSportRes editSportById(Long sportId, SportReq sportReq);
    DeleteSportRes deleteSportById(Long sportId);
}
