package pe.edu.utp.olimpiadas_aqp.models.requests.category;

import java.sql.Date;

public class CategoryReq {
    private String name;
    private String description;
    private Long sportId;


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

     public Long getSportId() {
        return this.sportId;
    }

    public void setSportId(Long sportId) {
        this.sportId = sportId;
    }
}
