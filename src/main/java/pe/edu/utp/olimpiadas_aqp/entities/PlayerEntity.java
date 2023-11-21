package pe.edu.utp.olimpiadas_aqp.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity(name = "player")
public class PlayerEntity implements Serializable {
    
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id", nullable = false)
    private Long playerId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false) 
    private Date dateBirth;

    @Column(nullable = false)
    private double size;

    @Column(nullable = false)
    private double weight;

    @Column(nullable = false)
    private int numberTshirt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", referencedColumnName = "team_id", nullable = false)
    private TeamEntity team;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;


    public Long getPlayerId() {
        return this.playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateBirth() {
        return this.dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public double getSize() {
        return this.size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getNumberTshirt() {
        return this.numberTshirt;
    }

    public void setNumberTshirt(int numberTshirt) {
        this.numberTshirt = numberTshirt;
    }

    public TeamEntity getTeam() {
        return this.team;
    }

    public void setTeam(TeamEntity team) {
        this.team = team;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }



}
