package com.fantasticfour.healthcare.payment;

public class Payment {
	public int payID;  //me name tikama denna DB eke fields tikata
	public String date;
	public String time;
	public String amount;
	public String cardNo;
	public String cvv;
	
	public int getPayID() {
		return payID;
	}
	public void setPayID(int payID) {
		this.payID = payID;
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
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	@Override
	public String toString() {
		return "Payment [payID=" + payID + ", date=" + date + ", time=" + time + ", amount=" + amount + ", cardNo="
				+ cardNo + ", cvv=" + cvv + "]";
	}
	
	
	
}
