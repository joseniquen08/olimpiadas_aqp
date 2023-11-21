package pe.edu.utp.olimpiadas_aqp.models.responses.category;

public class CreateCategoryRes {
    private int status;
    private String message;
    private GetCategoryRes category;

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

    public GetCategoryRes getCategory() {
        return this.category;
    }

    public void setCategory(GetCategoryRes category) {
        this.category = category;
    }

 


   
}
