package pe.edu.utp.olimpiadas_aqp.models.requests.event;

public class AssignDelegateToEventReq {
    private Long eventId;
    private Long delegateId;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getDelegateId() {
        return delegateId;
    }

    public void setDelegateId(Long delegateId) {
        this.delegateId = delegateId;
    }
}
