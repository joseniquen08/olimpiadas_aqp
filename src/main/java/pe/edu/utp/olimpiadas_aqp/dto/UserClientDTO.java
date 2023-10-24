package pe.edu.utp.olimpiadas_aqp.dto;

public class UserClientDTO {
    private String fullName;
    private String email;
  
    private String ruc;
    private String representative;
    private String phone;

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRepresentative() {
		return this.representative;
	}

	public void setRepresentative(String representative) {
		this.representative = representative;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}