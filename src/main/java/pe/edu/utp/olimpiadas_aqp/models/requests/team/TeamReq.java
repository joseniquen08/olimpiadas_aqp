package pe.edu.utp.olimpiadas_aqp.models.requests.team;

import java.sql.Date;

public class TeamReq {
    private String name;
    private String urlImagen;
    private Long categoryId;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImagen() {
        return this.urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

       public Long getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
   
}
