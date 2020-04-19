package model;

public class Patient {

	private String pname;
	private int pnic;
	private String Gender;
	private String phonenumber;
	private String password;
	private String username;

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPnic() {
		return pnic;
	}

	public void setPnic(int pnic) {
		this.pnic = pnic;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Patient [pname=" + pname + ", pnic=" + pnic + ", Gender=" + Gender + ", phonenumber=" + phonenumber
				+ ", password=" + password + ", username=" + username + "]";
	}

}
