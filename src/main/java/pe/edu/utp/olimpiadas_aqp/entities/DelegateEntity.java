package pe.edu.utp.olimpiadas_aqp.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity(name = "delegate")
public class DelegateEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delegate_id", nullable = false)
    private Long delegateId;

    @Column(nullable = false, unique = true)
    private Long dni;

    @Column(nullable = false)
    private Long phone;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private UserEntity user;

    @OneToMany(mappedBy = "delegate", cascade = CascadeType.ALL)
    private Set<DelegateEventEntity> delegateEventEntitySet;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    public Long getDelegateId() {
        return delegateId;
    }

    public void setDelegateId(Long delegateId) {
        this.delegateId = delegateId;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Set<DelegateEventEntity> getDelegateEventEntitySet() {
        return delegateEventEntitySet;
    }

    public void setDelegateEventEntitySet(Set<DelegateEventEntity> delegateEventEntitySet) {
        this.delegateEventEntitySet = delegateEventEntitySet;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
