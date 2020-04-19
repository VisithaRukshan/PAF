package model;

public class Doctor {
	
	public int docID;
	public String name;
	public String specialization;
	public String contactNo;
	public String password;
	public int getDocID() {
		return docID;
	}
	public void setDocID(int docID) {
		this.docID = docID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	@Override
	public String toString() {
		return "Doctor [docID=" + docID + ", name=" + name + ", specialization=" + specialization + ", contactNo="
				+ contactNo + "]";
	}
	
}
