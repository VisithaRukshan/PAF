package model;

public class Hospital {

	private int hostId;
	private String name;
	private String location;
	private String teleNo;

	public int getHostId() {
		return hostId;
	}

	public void setHostId(int hostId) {
		this.hostId = hostId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTeleNo() {
		return teleNo;
	}

	public void setTeleNo(String teleNo) {
		this.teleNo = teleNo;
	}

	@Override
	public String toString() {
		return "Hospital [hostId=" + hostId + ", name=" + name + ", location=" + location + ", teleNo=" + teleNo + "]";
	}

}
