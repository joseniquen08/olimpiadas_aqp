package pe.edu.utp.olimpiadas_aqp.services;
import pe.edu.utp.olimpiadas_aqp.models.requests.team.TeamReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.team.*;

import java.util.List;

public interface TeamServiceInterface {
    List<GetTeamRes> getAll();
    GetTeamsByCategoryIdRes getByCategoryId(Long categoryId);
    CreateTeamRes createEvent(TeamReq teamReq);
    EditTeamRes editTeamById(Long teamId, TeamReq teamReq);
    DeleteTeamRes deleteTeamById(Long teamId);
}
