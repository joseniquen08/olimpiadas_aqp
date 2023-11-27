package pe.edu.utp.olimpiadas_aqp.models.responses.event;

public class CreateEventRes {
    private int status;
    private String message;
    private GetEventRes event;

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

    public GetEventRes getEvent() {
        return event;
    }

    public void setEvent(GetEventRes event) {
        this.event = event;
    }
}
