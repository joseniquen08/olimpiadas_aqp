package pe.edu.utp.olimpiadas_aqp.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.utp.olimpiadas_aqp.entities.SportEntity;
import pe.edu.utp.olimpiadas_aqp.models.requests.sport.SportReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.sport.CreateSportRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.sport.EditSportRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.sport.GetSportRes;
import pe.edu.utp.olimpiadas_aqp.repositories.SportRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SportService implements SportServiceInterface {

    @Autowired
    SportRepository sportRepository;

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
    public CreateSportRes createEvent(SportReq sportReq) {
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
}
