package pe.edu.utp.olimpiadas_aqp.services;
import pe.edu.utp.olimpiadas_aqp.models.requests.team.TeamReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.team.CreateTeamRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.team.DeleteTeamRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.team.EditTeamRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.team.GetTeamRes;

import java.util.List;

public interface TeamServiceInterface {
    List<GetTeamRes> getAll();
    CreateTeamRes createEvent(TeamReq teamReq);
    EditTeamRes editTeamById(Long teamId, TeamReq teamReq);
    DeleteTeamRes deleteTeamById(Long teamId);
}
