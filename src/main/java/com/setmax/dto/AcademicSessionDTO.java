package com.setmax.dto;

public class AcademicSessionDTO {
	private int id;
	private String sessionStart;
	private String sessionEnd;
	boolean isCurrentSession;

	public AcademicSessionDTO() {

	}

	public String getSessionStart() {
		return sessionStart;
	}

	public void setSessionStart(String sessionStart) {
		this.sessionStart = sessionStart;
	}

	public String getSessionEnd() {
		return sessionEnd;
	}

	public void setSessionEnd(String sessionEnd) {
		this.sessionEnd = sessionEnd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getIsCurrentSession() {
		return isCurrentSession;
	}

	public void setIsCurrentSession(boolean isCurrentSession) {
		this.isCurrentSession = isCurrentSession;
	}

	@Override
	public String toString() {
		return "AcademicSessionDTO [id=" + id + ", sessionStart=" + sessionStart + ", sessionEnd=" + sessionEnd
				+ ", isCurrentSession=" + isCurrentSession + "]";
	}

}
