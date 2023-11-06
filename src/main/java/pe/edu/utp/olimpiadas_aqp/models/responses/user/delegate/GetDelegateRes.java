package pe.edu.utp.olimpiadas_aqp.models.responses.user.delegate;

public class GetDelegateRes {
    private Long delegateId;
    private Long dni;
    private Long phone;

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
}
