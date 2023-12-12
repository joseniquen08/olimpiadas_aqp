package pe.edu.utp.olimpiadas_aqp.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;

@Entity(name = "player_single_match")
public class PlayerSingleMatchEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_single_match_id", nullable = false)
    private Long playerSingleMatchId;

    @Column
    private int position;

    @Column
    private int score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", referencedColumnName = "player_id", nullable = false)
    private PlayerEntity player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "single_match_id", referencedColumnName = "single_match_id", nullable = false)
    private SingleMatchEntity singleMatch;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    public Long getPlayerSingleMatchId() {
        return playerSingleMatchId;
    }

    public void setPlayerSingleMatchId(Long playerSingleMatchId) {
        this.playerSingleMatchId = playerSingleMatchId;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(PlayerEntity player) {
        this.player = player;
    }

    public SingleMatchEntity getSingleMatch() {
        return singleMatch;
    }

    public void setSingleMatch(SingleMatchEntity singleMatch) {
        this.singleMatch = singleMatch;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
