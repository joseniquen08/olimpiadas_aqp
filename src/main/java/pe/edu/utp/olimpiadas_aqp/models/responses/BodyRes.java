package pe.edu.utp.olimpiadas_aqp.models.responses;

import org.springframework.http.HttpStatus;

public class BodyRes<T> {
    private HttpStatus status = HttpStatus.OK;
    private String message;
    private T data;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
