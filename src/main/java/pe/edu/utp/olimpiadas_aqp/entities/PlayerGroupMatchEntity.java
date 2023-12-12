package pe.edu.utp.olimpiadas_aqp.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;

@Entity(name = "player_group_match")
public class PlayerGroupMatchEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_group_match_id", nullable = false)
    private Long playerGroupMatchId;

    @Column(nullable = false)
    private int score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", referencedColumnName = "player_id", nullable = false)
    private PlayerEntity player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_match_id", referencedColumnName = "group_match_id", nullable = false)
    private GroupMatchEntity groupMatch;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    public Long getPlayerGroupMatchId() {
        return playerGroupMatchId;
    }

    public void setPlayerGroupMatchId(Long playerGroupMatchId) {
        this.playerGroupMatchId = playerGroupMatchId;
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

    public GroupMatchEntity getGroupMatch() {
        return groupMatch;
    }

    public void setGroupMatch(GroupMatchEntity groupMatch) {
        this.groupMatch = groupMatch;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
