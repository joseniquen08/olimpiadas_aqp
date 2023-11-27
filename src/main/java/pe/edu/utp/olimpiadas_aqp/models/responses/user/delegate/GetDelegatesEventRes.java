package pe.edu.utp.olimpiadas_aqp.models.responses.user.delegate;

public class GetDelegatesEventRes {
    private Long delegateId;
    private Long delegateEventId;
    private String fullName;
    private Long phone;

    public Long getDelegateId() {
        return delegateId;
    }

    public void setDelegateId(Long delegateId) {
        this.delegateId = delegateId;
    }

    public Long getDelegateEventId() {
        return delegateEventId;
    }

    public void setDelegateEventId(Long delegateEventId) {
        this.delegateEventId = delegateEventId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
