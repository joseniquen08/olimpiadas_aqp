package pe.edu.utp.olimpiadas_aqp.models.responses.user.delegate;

public class DelegateRes {
    private Long delegateId;
    private String fullName;

    public Long getDelegateId() {
        return delegateId;
    }

    public void setDelegateId(Long delegateId) {
        this.delegateId = delegateId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
