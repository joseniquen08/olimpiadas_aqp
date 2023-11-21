package pe.edu.utp.olimpiadas_aqp.models.responses.player;

public class CreatePlayerRes {
    private int status;
    private String message;
    private GetPlayerRes player;

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public GetPlayerRes getPlayer() {
        return this.player;
    }

    public void setPlayer(GetPlayerRes player) {
        this.player = player;
    }
}
