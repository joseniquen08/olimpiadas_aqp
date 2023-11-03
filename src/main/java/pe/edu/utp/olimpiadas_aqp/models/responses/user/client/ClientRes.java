package pe.edu.utp.olimpiadas_aqp.models.responses.user.client;

public class ClientRes {
    private Long clientId;
    private String fullName;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
