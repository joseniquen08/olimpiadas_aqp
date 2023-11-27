package pe.edu.utp.olimpiadas_aqp.models.requests.event;

public class AssignSportToEventReq {
    private Long eventId;
    private Long sportId;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getSportId() {
        return sportId;
    }

    public void setSportId(Long sportId) {
        this.sportId = sportId;
    }
}
