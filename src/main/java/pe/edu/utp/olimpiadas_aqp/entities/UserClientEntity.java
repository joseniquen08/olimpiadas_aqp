package pe.edu.utp.olimpiadas_aqp.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name = "userClient")
public class UserClientEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "userClient_id", nullable = false)
    private Long userId;

    @Column(name = "full_name", nullable = false, length = 256)
    private String fullName;

    @Column(nullable = false, length = 256)
    private String ruc;

    @Column(nullable = false, length = 256)
    private String representative;

    @Column(nullable = false, length = 256)
    private String phone;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserClientEntity user;

    public UserClientEntity getUser() {
        return this.user;
    }

    public void setUser(UserClientEntity user) {
        this.user = user;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

     public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
  
}