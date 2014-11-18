package com.kedb.bean;

public class LoginAccessTable 
{
private String UserName;
private String Password;
private String IsAdmin;
private String IsSpoc;
public String getUserName() {
	return UserName;
}
public void setUserName(String userName) {
	UserName = userName;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getIsAdmin() {
	return IsAdmin;
}
public void setIsAdmin(String isAdmin) {
	IsAdmin = isAdmin;
}
public String getIsSpoc() {
	return IsSpoc;
}
public void setIsSpoc(String isSpoc) {
	IsSpoc = isSpoc;
}

}
