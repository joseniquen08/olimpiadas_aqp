package pe.edu.utp.olimpiadas_aqp.models.responses.player;

import java.util.List;

public class GetPlayersByTeamIdRes {
    private String eventName;
    private String sportName;
    private String categoryName;
    private String teamName;
    private List<GetPlayerRes> players;

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

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<GetPlayerRes> getPlayers() {
        return players;
    }

    public void setPlayers(List<GetPlayerRes> players) {
        this.players = players;
    }
}
