package pe.edu.utp.olimpiadas_aqp.models.responses.user.client;

import pe.edu.utp.olimpiadas_aqp.dto.ClientDTO;

public class CreateClientRes {
    private String message;
    private int status;
    private ClientDTO user;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ClientDTO getUser() {
        return user;
    }

    public void setUser(ClientDTO user) {
        this.user = user;
    }
}
