package pe.edu.utp.olimpiadas_aqp.models.responses.category;

import pe.edu.utp.olimpiadas_aqp.models.responses.sport.GetSportsEventRes;

import java.util.List;

public class GetCategoriesBySportEventIdRes {
    private String eventName;
    private String sportName;
    private List<GetCategoryRes> categories;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public List<GetCategoryRes> getCategories() {
        return categories;
    }

    public void setCategories(List<GetCategoryRes> categories) {
        this.categories = categories;
    }
}
