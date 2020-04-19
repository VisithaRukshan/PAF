package model;


public class Hospital {

	public int id;

	private String telNo;
	private String hospitalName;
	private String hospitalLocation;

	
//getters and setters
	
	
	public int getId() {
		return id;
	}







	public void setId(int id) {
		this.id = id;
	}












	public String getTelNo() {
		return telNo;
	}







	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}







	public String getHospitalName() {
		return hospitalName;
	}







	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}







	public String getHospitalLocation() {
		return hospitalLocation;
	}







	public void setHospitalLocation(String hospitalLocation) {
		this.hospitalLocation = hospitalLocation;
	}




//tostring methd


	@Override
	public String toString() {
		return "Hospital [telNo=" + telNo + ", hospitalName=" + hospitalName
				+ ", hospitalLocation=" + hospitalLocation + ",  ID=" + id + "]";
	}
	
	
}
