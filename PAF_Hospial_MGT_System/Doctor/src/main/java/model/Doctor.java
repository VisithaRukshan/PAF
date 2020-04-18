package model;

public class Doctor {
	public int docID;
	public String docName;
	public String specialization;
	public String contactNo;
	public String password;
	
	public int getDocID() {
		return docID;
	}
	public void setDocID(int docID) {
		this.docID = docID;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Doctor [docID=" + docID + ", docName=" + docName + ", specialization=" + specialization + ", contactNo="
				+ contactNo + ", password=" + password + "]";
	}
	
	
	
	
	
}
