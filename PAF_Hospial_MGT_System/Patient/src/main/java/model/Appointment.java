package model;

public class Appointment {
	public int appointNo;
	public String date;
	public String time;
	public String location;
	public String pname;
	public String dname;
	public int getAppointNo() {
		return appointNo;
	}
	public void setAppointNo(int appointNo) {
		this.appointNo = appointNo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "Appoinment [appointNo=" + appointNo + ", date=" + date + ", time=" + time + ", location=" + location
				+ ", pname=" + pname + ", dname=" + dname + "]";
	}
	
}
