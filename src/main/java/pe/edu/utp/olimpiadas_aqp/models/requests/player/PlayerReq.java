package pe.edu.utp.olimpiadas_aqp.models.requests.player;

import java.sql.Date;

public class PlayerReq {
    private String name;
    private String gender;
    private Date dateBirth;
    private double size;
    private double weight;
    private int numberTshirt;
    private Long teamId;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateBirth() {
        return this.dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public double getSize() {
        return this.size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getNumberTshirt() {
        return this.numberTshirt;
    }

    public void setNumberTshirt(int numberTshirt) {
        this.numberTshirt = numberTshirt;
    }

     public Long getTeamId() {
        return this.teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }


}
