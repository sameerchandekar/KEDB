<%@page import="com.kedb.bean.TwoVector"%>
<%@page import="com.kedb.jdbc.Connection"%>
<%@page import="java.sql.*"%>
<%@page import="com.kedb.jdbc.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quick-Fix:Known Error Database System</title>
<script src="../commonScript.js"></script> 

<LINK href="../CSS/homepage.css" rel="stylesheet" type="text/css">
<LINK href="../CSS/Register.css" rel="stylesheet" type="text/css">



</head>

<body style="background-color:#dae5f4;">
<%

    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>

<%

Operations op=new Operations();
String count1=op.countGCCI();
String count2=op.countGCCP();
String count3=op.countGMSI();
String count4=op.countGMSP();
String count5=op.countCTTI();
String count6=op.countCTTP();
String count7=op.countJAPAI();
String count8=op.countJAPAP(); 



/* /* session.setAttribute("GCCI", count1.getString(1));
session.setAttribute("GCCP", count2.getString(1));
session.setAttribute("GMSI", count3.getString(1));
session.setAttribute("GMSP", count4.getString(1));
session.setAttribute("CTTI", count5.getString(1));
session.setAttribute("CTTP", count6.getString(1));
session.setAttribute("JAPAI", count7.getString(1));
session.setAttribute("JAPAP", count8.getString(1));  */
try
{
	 if(session.getAttribute("uname").equals(null))
	{
		
		out.print("session value..."+session);
		} 

}
catch(NullPointerException e)
{
	response.sendRedirect("/KEDB/JSP/Login.jsp");
}

%>


   
 
  
 <div id="strip">
<%@ include file="Header.jsp" %> 
  </div>
  
        <div id="main_body" style="background-image:none;">
           <center>
        <br> <br><br>
                
        <%

String success=request.getParameter("success");
if(success!=null)
{
	if(success.equals("true")){
%>
<p style="color: green">
User registered successfully!!!
</p>
<%
	}
	else{
%>
<p style="color: red">
User may already exists.
</p>
<%} 
	
}%>
	
<form action="/KEDB/RegisterUserServlet" method="post" onsubmit="return RegisterValidation();">
<table cellpadding="5"  align="center" border="2" style=" width: 45%;">


<tr>
<td colspan="2">
<span class="form_label">User name</span></td>
<td ><input type="text" name="username" id="username" class="form_styles" ><br><br></td>
</tr>

<tr>
<td colspan="2">
<span class="form_label">Password</span> </td><td><input type="password" name="pwd" id="pwd" class="form_styles"></td>
</tr>
<tr>

<td colspan="2">
<span class="form_label">Confirm Password</span>  </td> <td><input type="password" name="cpwd" id="cpwd" class="form_styles">
</td>
</tr>

<tr>
<td colspan="2">
<span class="form_label">Is Admin:</span></td>
<td>

<input type="radio" name="isAdmin" value="yes" id="isAdmin" class="form_styles"><span class="form_label">Yes &nbsp; &nbsp; </span>

<input type="radio" name="isAdmin" value="no" checked="checked" class="form_styles" ><span class="form_label">No</span>
 </td>
 
 </tr>
 
 
 <tr>
 <td colspan="2"><span class="form_label">Is Spoc:</span></td>
 <td><input type="radio" name="isSpoc" value="yes" id="isSpoc" class="form_styles"><span class="form_label">Yes &nbsp; &nbsp;</span>
 
 
 <input type="radio" name="isSpoc" value="no" checked="checked" class="form_styles"><span class="form_label">No</span>
 </td>
 </tr>
 
 
 <tr>
 <td colspan="3" >

<input type="submit" value="Register" align="middle" width="23" class="form_styles" id="submit"/>
</td>


  </tr>
  
  </table>
  
</form>
                </center>
             </div>
  

  
  <div id="footer">&copy; Developed by KEDB Development Team at Old Amex,DLF Chennai.
  <span style="float: right;">
  <%
	//for counter
  Operations opCount=new Operations();
  int counter=opCount.getCounter();
 %>
  
  Counter is:<%=counter%>
  
 
  </span>
  </div>

</body>
</html>