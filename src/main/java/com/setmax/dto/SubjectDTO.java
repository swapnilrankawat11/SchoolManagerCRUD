package com.setmax.dto;

public class SubjectDTO {
	private int id;
	private String name;
	private boolean isLanguage;

	public SubjectDTO() {
	}

	public int getId() {
		return id;
	}

	public SubjectDTO(int id, String name, boolean isLanguage) {
		this.id = id;
		this.name = name;
		this.isLanguage = isLanguage;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "SubjectDTO [id=" + id + ", name=" + name + ", isLanguage=" + isLanguage + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getIsLanguage() {
		return isLanguage;
	}

	public void setIsLanguage(boolean isLanguage) {
		this.isLanguage = isLanguage;
	}

}