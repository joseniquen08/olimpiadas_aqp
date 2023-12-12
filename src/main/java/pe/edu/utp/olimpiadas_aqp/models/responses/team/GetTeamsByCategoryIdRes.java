package pe.edu.utp.olimpiadas_aqp.models.responses.team;

import java.util.List;

public class GetTeamsByCategoryIdRes {
    private String eventName;
    private String sportName;
    private String categoryName;
    private List<GetTeamRes> teams;

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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<GetTeamRes> getTeams() {
        return teams;
    }

    public void setTeams(List<GetTeamRes> teams) {
        this.teams = teams;
    }
}
