package pe.edu.utp.olimpiadas_aqp.models.responses.user.delegate;

import pe.edu.utp.olimpiadas_aqp.models.responses.sport.GetSportsEventRes;

import java.util.List;

public class GetDelegatesByEventIdRes {
    private String eventName;
    private List<GetDelegatesEventRes> delegates;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public List<GetDelegatesEventRes> getDelegates() {
        return delegates;
    }

    public void setDelegates(List<GetDelegatesEventRes> delegates) {
        this.delegates = delegates;
    }
}
