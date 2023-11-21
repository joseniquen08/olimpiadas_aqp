package pe.edu.utp.olimpiadas_aqp.models.responses.team;

public class CreateTeamRes {
    private int status;
    private String message;
    private GetTeamRes team;

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public GetTeamRes getTeam() {
        return this.team;
    }

    public void setTeam(GetTeamRes team) {
        this.team = team;
    }
}
