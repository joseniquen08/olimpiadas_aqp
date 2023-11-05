package pe.edu.utp.olimpiadas_aqp.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity(name = "event")
public class EventEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id", nullable = false)
    private Long eventId;

    @Column(nullable = false)
    private String name;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id", nullable = false)
    private ClientEntity client;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private Set<DelegateEventEntity> delegateEventEntitySet;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private Set<SportEventEntity> sportEventEntitySet;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public Set<DelegateEventEntity> getDelegateEventEntitySet() {
        return delegateEventEntitySet;
    }

    public void setDelegateEventEntitySet(Set<DelegateEventEntity> delegateEventEntitySet) {
        this.delegateEventEntitySet = delegateEventEntitySet;
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
