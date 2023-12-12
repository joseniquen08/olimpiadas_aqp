package pe.edu.utp.olimpiadas_aqp.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;

@Entity(name = "team_group_match")
public class TeamGroupMatchEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_group_match_id", nullable = false)
    private Long teamGroupMatchId;

    @Column(nullable = false)
    private int score;

    @Column(name = "is_winner", columnDefinition = "boolean default null")
    private boolean isWinner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", referencedColumnName = "team_id", nullable = false)
    private TeamEntity team;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_match_id", referencedColumnName = "group_match_id", nullable = false)
    private GroupMatchEntity groupMatch;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    public Long getTeamGroupMatchId() {
        return teamGroupMatchId;
    }

    public void setTeamGroupMatchId(Long teamGroupMatchId) {
        this.teamGroupMatchId = teamGroupMatchId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public TeamEntity getTeam() {
        return team;
    }

    public void setTeam(TeamEntity team) {
        this.team = team;
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
