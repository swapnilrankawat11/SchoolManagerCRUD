package com.setmax.dto;

public class StudentDetails {
	private int serialNo;
	private String fullName, motherName, fatherName, standard, contactNumber, fees;

	public int getSerialNo() {
		return serialNo;
	}

	public StudentDetails() {
	}

	public StudentDetails(int serialNo, String fullName, String motherName, String fatherName, String standard,
			String fees, String contactNumber) {
		this.serialNo = serialNo;
		this.fullName = fullName;
		this.motherName = motherName;
		this.fatherName = fatherName;
		this.standard = standard;
		this.fees = fees;
		this.contactNumber = contactNumber;
	}

	public StudentDetails(String fullName, String motherName, String fatherName, String standard, String fees,
			String contactNumber) {
		this.fullName = fullName;
		this.motherName = motherName;
		this.fatherName = fatherName;
		this.standard = standard;
		this.fees = fees;
		this.contactNumber = contactNumber;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getFees() {
		return fees;
	}

	public void setFees(String fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "StudentDetails [serialNo=" + serialNo + ", fullName=" + fullName + ", motherName=" + motherName
				+ ", fatherName=" + fatherName + ", standard=" + standard + ", contactNumber=" + contactNumber
				+ ", fees=" + fees + "]";
	}

}