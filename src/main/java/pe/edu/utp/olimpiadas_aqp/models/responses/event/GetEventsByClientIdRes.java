package pe.edu.utp.olimpiadas_aqp.models.responses.event;

import pe.edu.utp.olimpiadas_aqp.models.responses.category.GetCategoryRes;

import java.util.List;

public class GetEventsByClientIdRes {
    private List<GetEventRes> events;

    public List<GetEventRes> getEvents() {
        return events;
    }

    public void setEvents(List<GetEventRes> events) {
        this.events = events;
    }
}
