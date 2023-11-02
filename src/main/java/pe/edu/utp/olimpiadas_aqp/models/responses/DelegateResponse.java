package pe.edu.utp.olimpiadas_aqp.models.responses;

import pe.edu.utp.olimpiadas_aqp.dto.ClientDTO;
import pe.edu.utp.olimpiadas_aqp.dto.DelegateDTO;

public class DelegateResponse {
    private String message;
    private int status;
    private DelegateDTO user;

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

    public DelegateDTO getUser() {
        return user;
    }

    public void setUser(DelegateDTO user) {
        this.user = user;
    }
}
