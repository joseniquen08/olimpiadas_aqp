package pe.edu.utp.olimpiadas_aqp.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity(name = "sport")
public class SportEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sport_id", nullable = false)
    private Long sportId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "sport")
    private Set<SportEventEntity> sportEventEntitySet;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    public Long getSportId() {
        return sportId;
    }

    public void setSportId(Long sportId) {
        this.sportId = sportId;
    }

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

    public Set<SportEventEntity> getSportEventEntitySet() {
        return sportEventEntitySet;
    }

    public void setSportEventEntitySet(Set<SportEventEntity> sportEventEntitySet) {
        this.sportEventEntitySet = sportEventEntitySet;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
