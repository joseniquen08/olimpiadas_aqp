package pe.edu.utp.olimpiadas_aqp.models.responses.sport;

import java.util.List;

public class GetSportsByEventIdRes {
    private String eventName;
    private List<GetSportsEventRes> sports;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public List<GetSportsEventRes> getSports() {
        return sports;
    }

    public void setSports(List<GetSportsEventRes> sports) {
        this.sports = sports;
    }
}
