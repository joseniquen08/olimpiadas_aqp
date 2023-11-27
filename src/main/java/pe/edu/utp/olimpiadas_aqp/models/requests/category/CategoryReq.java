package pe.edu.utp.olimpiadas_aqp.models.requests.category;

public class CategoryReq {
    private String name;
    private String description;
    private Long sportEventId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSportEventId() {
        return sportEventId;
    }

    public void setSportEventId(Long sportEventId) {
        this.sportEventId = sportEventId;
    }
}
