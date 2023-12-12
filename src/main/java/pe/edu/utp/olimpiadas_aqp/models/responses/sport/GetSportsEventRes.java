package pe.edu.utp.olimpiadas_aqp.models.responses.sport;

public class GetSportsEventRes {
    private Long sportId;
    private Long sportEventId;
    private String name;
    private String delegate;
    private String description;
    private int totalCategories;

    public Long getSportId() {
        return sportId;
    }

    public void setSportId(Long sportId) {
        this.sportId = sportId;
    }

    public Long getSportEventId() {
        return sportEventId;
    }

    public void setSportEventId(Long sportEventId) {
        this.sportEventId = sportEventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDelegate() {
        return delegate;
    }

    public void setDelegate(String delegate) {
        this.delegate = delegate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalCategories() {
        return totalCategories;
    }

    public void setTotalCategories(int totalCategories) {
        this.totalCategories = totalCategories;
    }
}
