package com.student.dto;

public class Student {
	private int ID;
	private String NAME;
	private long PHONE;
	private String MAILID;
	private String BRANCH ;  
	private String LOCATION ;
	private String  PASSWORD ;
	private String DATE;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public long getPHONE() {
		return PHONE;
	}
	public void setPHONE(long pHONE) {
		PHONE = pHONE;
	}
	public String getMAILID() {
		return MAILID;
	}
	public void setMAILID(String mAILID) {
		MAILID = mAILID;
	}
	public String getBRANCH() {
		return BRANCH;
	}
	public void setBRANCH(String bRANCH) {
		BRANCH = bRANCH;
	}
	public String getLOCATION() {
		return LOCATION;
	}
	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getDATE() {
		return DATE;
	}
	public void setDATE(String dATE) {
		DATE = dATE;
	}
	@Override
	public String toString() {
		return "Student [ID=" + ID + ", NAME=" + NAME + ", PHONE=" + PHONE + ", MAILID=" + MAILID + ", BRANCH=" + BRANCH
				+ ", LOCATION=" + LOCATION + ", DATE=" + DATE + "]";
	}
}
