package pe.edu.utp.olimpiadas_aqp.models.responses.auth;

import pe.edu.utp.olimpiadas_aqp.models.responses.user.GetUserRes;

public class LoginRes {
    private String token;
    private int status;
    private String message;
    private GetUserRes user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public GetUserRes getUser() {
        return user;
    }

    public void setUser(GetUserRes user) {
        this.user = user;
    }
}
