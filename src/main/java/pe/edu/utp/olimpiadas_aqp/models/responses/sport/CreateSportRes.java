package pe.edu.utp.olimpiadas_aqp.models.responses.sport;

public class CreateSportRes {
    private int status;
    private String message;
    private GetSportRes sport;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public GetSportRes getSport() {
        return sport;
    }

    public void setSport(GetSportRes sport) {
        this.sport = sport;
    }
}
