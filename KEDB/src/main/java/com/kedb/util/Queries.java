package com.kedb.util;

public final class Queries 
{
	
	public static String ADD_INCIDENT="insert into Incident_Details(Incident_Number, Incident_Title, Incident_Description, Problem_Number, Work_Around, Cause_Code, Application, Create_Date, Close_Date,User_Name, Work_Group,Last_Updt_User,Last_Updt_Ts) values(?,?,?,?,?,?,?,?,?,?,?,?,DATE())";
	public static String VALIDATE="select User_Name,Password from Login_Access_Table where User_Name=? and Password=?";
	public static String CHECK_ROLE="select * from Login_Access_Table where User_Name=? and Password=?";
	public static String GET_E2E="SELECT distinct E2E from LOB where LOB=?";
	public static String GET_APP_WORK="SELECT Application,Work_Group from LOB where E2E=?";
	public static String SEARCH_INCIDENT="SELECT * from Incident_Details where Incident_Number=?";
	public static String SEARCH_PROBLEM="SELECT * from Problem_Details where Problem_Number=?";
	public static String ADD_PROBLEM="insert into Problem_Details(Problem_Number, Problem_Title, Problem_Description, RCA, Permanant_Resolution, ETA, Application, Work_Group,Last_Updtd_User,Last_Updtd_Ts, User_Name) values(?,?,?,?,?,?,?,?,?,DATE(),?)";
	
	public static final String GET_WG ="SELECT distinct Work_Group from LOB where Application=?";
	
	
	public static String DELETE_INCIDENT="delete from Incident_Details where Incident_Number=?";
	public static String DELETE_PROBLEM="delete from Problem_Details where Problem_Number=?";

	//public static String COUNT_INCIDENT_GCC= "select count(Incident_Number) from Incident_Details where Application IN (select Application from LOB where LOB='GCC')";
	public static String COUNT_INCIDENT_GCC="select count(I.Incident_Number) from Incident_Details I,LOB L where I.Application=L.Application and L.LOB='GCC'";
	public static String COUNT_INCIDENT_GMS="select count(I.Incident_Number) from Incident_Details I,LOB L where I.Application=L.Application and L.LOB='GMS'";
	public static String COUNT_INCIDENT_CTT="select count(I.Incident_Number) from Incident_Details I,LOB L where I.Application=L.Application and L.LOB='CTT'";
	public static String COUNT_INCIDENT_JAPA="select count(I.Incident_Number) from Incident_Details I,LOB L where I.Application=L.Application and L.LOB='JAPA'";
	public static String COUNT_INCIDENT_MBT="select count(I.Incident_Number) from Incident_Details I,LOB L where I.Application=L.Application and L.LOB='MBT'";
	
	public static String COUNT_PROBLEM_GCC="select count(I.Problem_Number) from Problem_Details I,LOB L where I.Application=L.Application and L.LOB='GCC'";
	public static String COUNT_PROBLEM_GMS="select count(I.Problem_Number) from Problem_Details I,LOB L where I.Application=L.Application and L.LOB='GMS'";
	public static String COUNT_PROBLEM_CTT="select count(I.Problem_Number) from Problem_Details I,LOB L where I.Application=L.Application and L.LOB='CTT'";
	public static String COUNT_PROBLEM_JAPA="select count(I.Problem_Number) from Problem_Details I,LOB L where I.Application=L.Application and L.LOB='JAPA'";
	public static String COUNT_PROBLEM_MBT="select count(I.Problem_Number) from Problem_Details I,LOB L where I.Application=L.Application and L.LOB='MBT'";

	public static String MODIFY_INCIDENT= "update Incident_Details set Incident_Title=?, Incident_Description=?, Problem_Number=?, Work_Around=?, Cause_Code=?, Last_Updt_User=?, Last_Updt_Ts=DATE() where Incident_Number=?";
	public static String MODIFY_PROBLEM= "update Problem_Details set Problem_Title=?, Problem_Description=?, RCA=?, Permanant_Resolution=?, ETA=?, Last_Updtd_User=?, Last_Updtd_Ts=DATE() where Problem_Number=?";

	public static String LOB_SERCH="(select Application from LOB where LOB='";
	public static String E2E_SERCH="(select Application from LOB where E2E='";
	public static String INC_SERCH="select * from Incident_Details where Incident_Number=";

    public static final String ADD_USER = "insert into Login_Access_Table(User_Name, Password, Is_Admin, Is_Spoc) values(?,?,?,?)";
	
	
	public static String TOP_GCCI = "select TOP 3 [I.Incident_Number] from Incident_Details I, LOB L where L.Application=I.Application and L.LOB='GCC' ORDER BY I.Last_Updt_Ts DESC";
	public static String TOP_GCCP = "select TOP 3 [P.Problem_Number] from Problem_Details P, LOB L where L.Application=P.Application and L.LOB='GCC' ORDER BY P.Last_Updtd_Ts DESC";
	
	public static String TOP_GMSI= "select TOP 3 [I.Incident_Number] from Incident_Details I, LOB L where L.Application=I.Application and L.LOB='GMS' ORDER BY I.Last_Updt_Ts DESC";
	public static String TOP_GMSP="select TOP 3 [P.Problem_Number] from Problem_Details P, LOB L where L.Application=P.Application and L.LOB='GMS' ORDER BY P.Last_Updtd_Ts DESC";
	
	public static String TOP_CTTI = "select TOP 3 [I.Incident_Number] from Incident_Details I, LOB L where L.Application=I.Application and L.LOB='CTT' ORDER BY I.Last_Updt_Ts DESC";
	public static String TOP_CTTP="select TOP 3 [P.Problem_Number] from Problem_Details P, LOB L where L.Application=P.Application and L.LOB='CTT' ORDER BY P.Last_Updtd_Ts DESC";
	
	public static String TOP_JAPAI= "select TOP 3 [I.Incident_Number] from Incident_Details I, LOB L where L.Application=I.Application and L.LOB='JAPA' ORDER BY I.Last_Updt_Ts DESC";
	public static String TOP_JAPAP="select TOP 3 [P.Problem_Number] from Problem_Details P, LOB L where L.Application=P.Application and L.LOB='JAPA' ORDER BY P.Last_Updtd_Ts DESC";
	
	public static String TOP_MBTI="select TOP 3 [I.Incident_Number] from Incident_Details I, LOB L where L.Application=I.Application and L.LOB='MBT' ORDER BY I.Last_Updt_Ts DESC";
	public static String TOP_MBTP="select TOP 3 [P.Problem_Number] from Problem_Details P, LOB L where L.Application=P.Application and L.LOB='MBT' ORDER BY P.Last_Updtd_Ts DESC";
	public static String GET_APP="SELECT Application,Work_Group from LOB where E2E=?";
	


}
