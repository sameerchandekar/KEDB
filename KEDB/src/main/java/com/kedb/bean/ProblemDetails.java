package com.kedb.bean;

public class ProblemDetails 
{
	private String ProblemNumber;
	private String ProblemTitle;
	private String ProblemDescription;
	private String RCA;
	private String PermanantResolution;
	private String ETA;
	private String Application;
	
	
	private String WorkGroup;
	private String UserName;
	private String LastupdUser;
	private String LastupdTimestamp;
	public String getWorkGroup() {
		return WorkGroup;
	}
	public void setWorkGroup(String workGroup) {
		WorkGroup = workGroup;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getLastupdUser() {
		return LastupdUser;
	}
	public void setLastupdUser(String lastupdUser) {
		LastupdUser = lastupdUser;
	}
	public String getLastupdTimestamp() {
		return LastupdTimestamp;
	}
	public void setLastupdTimestamp(String lastupdTimestamp) {
		LastupdTimestamp = lastupdTimestamp;
	}
	
	
	
	
	public String getProblemNumber() {
		return ProblemNumber;
	}
	public void setProblemNumber(String problemNumber) {
		ProblemNumber = problemNumber;
	}
	public String getProblemTitle() {
		return ProblemTitle;
	}
	public void setProblemTitle(String problemTitle) {
		ProblemTitle = problemTitle;
	}
	public String getProblemDescription() {
		return ProblemDescription;
	}
	public void setProblemDescription(String problemDescription) {
		ProblemDescription = problemDescription;
	}
	public String getRCA() {
		return RCA;
	}
	public void setRCA(String rCA) {
		RCA = rCA;
	}
	public String getPermanantResolution() {
		return PermanantResolution;
	}
	public void setPermanantResolution(String permanantResolution) {
		PermanantResolution = permanantResolution;
	}
	public String getETA() {
		return ETA;
	}
	public void setETA(String eTA) {
		ETA = eTA;
	}
	public String getApplication() {
		return Application;
	}
	public void setApplication(String application) {
		Application = application;
	}
	
}
