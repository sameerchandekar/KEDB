
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%@page import="com.kedb.jdbc.*"%>
<%@page import="com.kedb.bean.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>KEDB:Add Incident Details</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css"> 
 <script src="//code.jquery.com/jquery-1.10.2.js"></script>
 <script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script> 
 <script src="../commonScript.js"></script> 
 <link rel="stylesheet" href="/resources/demos/style.css">  
 <LINK href="../CSS/homepage.css" rel="stylesheet" type="text/css">
  <LINK href="../CSS/AddIncident.css" rel="stylesheet" type="text/css">
  
 <script>  
 $(function() { 
	 $( "#datepicker" ).datepicker(); 
	 $( "#datepicker1" ).datepicker(); 
	 }
 );  
 

 </script>
<!-- Add onsumbit validation and submit using javascript 
Add calender to insert date and apply css
-->

<script type="text/javascript">

function subLOB()
{
	var a=document.getElementById("lob").value;
	
	document.myform.action="/KEDB/JSP/AddIncident.jsp?LOB1="+a;
	document.myform.submit();
}

function subE2E()
{
	var a=document.getElementById("e2e").value;
	document.myform.action="/KEDB/JSP/AddIncident.jsp?E2E1="+a;
	document.myform.submit();
	
}

function subApp()
{
	var a=document.getElementById("app").value;
	
	document.myform.action="HomePage.jsp?app="+a;
	document.myform.submit();
}


</script>
</head>
<body>

<%
TwoVector tv=new TwoVector();
HttpSession hs=request.getSession();
Vector<String> v=null;
Vector<String> v1=null;
Vector<String> v2=null;
Operations op=new Operations();
String LOB=request.getParameter("LOB1");
String E2E=request.getParameter("E2E1");
String success=request.getParameter("success");
if(LOB!=null)
{
	v=op.getE2E(LOB);
}
if(E2E!=null)
{
	tv=op.getAppWork(E2E);
	v1=tv.v1;
	v2=tv.v2;
}


%>
<div id="strip">
 <ul id="menu_wrap" class="Black"> <li class="button"><a href="HomePage.jsp" id="kedb">KEDB</a></li> <li class="button"><a href="Search.jsp">Advanced Search</a></li><li class="button"><a href="AddIncident.jsp">Add Incident</a></li><li class="button"><a href="AddProblem.jsp">Add Problem</a></li><li class="button"><a href="Modify.jsp">Modify</a></li> <li class="button"><a href="Delete.jsp">Delete</a></li> <li class="search"><a href="#"></a><input type="text"  /></li></ul>
  
  <span id ="wc_user">Welcome <font color="white"><%=session.getAttribute("uname") %></font> <a href="logout.jsp" class="log_out">Log out</a></span>
  
  
  </div>
  
        <div id="main_body">

<form name="myform" action="AddIncident.jsp" method="post">
<%
if(success!=null)
{
	if(success.equals("true")){
%>
<p style="color: green">
Data inserted successfully
</p>
<%
	}
	else{
%>
<p style="color: red">
Problem inserting data. Possible reasons are :
* Duplicate Incident Present
* Problem record is no present for entered problem record
</p>
<%} }%>

<table cellpadding="15"  align="center" border="0" style=" width: 75%;">
<tr>
<td><span class="form_label">LOB:</span><select id="lob" name="LOB" onchange="subLOB();" class="form_styles">
<option>--select--</option>
<option>GCC</option>
<option>GMS</option>
<option>OMS</option>
<option>CTT</option>
</select></td>
<td><span class="form_label">E2E:</span>
<select id="e2e" name="E2E" onchange="subE2E();" class="form_styles">
<option>--select--</option>
<%
if(v!=null){
Iterator it=v.iterator(); 
while(it.hasNext())
{
	String  temp=it.next().toString();
	session.setAttribute("LOB", temp);
%>
<option><%=session.getAttribute("LOB")%></option>


<%
}}
%>
</select></td>
</tr>
</table>

</form>



<form name="myform1" action="../AddIncidentServlet" method="post" onsubmit="return addIncidentValidate();" method="">
<table cellpadding="15"  align="center" border="0" style=" width: 75%;">


<tr>
<td><span class="form_label">Application:</span><select id="app" type="text" name="A" class="form_styles"/>
<option class="form_styles">--select--</option>
<%if(v1!=null){
Iterator it1=v1.iterator(); 
while(it1.hasNext())
{
	String  temp=it1.next().toString();
	session.setAttribute("E2E", temp);
%>
<option><%=session.getAttribute("E2E")%></option>

<%
}}
%></select>
</td>
<td> <span class="form_label">WorkGroup:</span><select name="WG" class="form_styles">
<option>--select--</option>
<%if(v2!=null){
Iterator it2=v2.iterator(); 
while(it2.hasNext())
{
	String  temp=it2.next().toString();
	session.setAttribute("WG", temp);
%>
<option><%=session.getAttribute("WG")%></option>

<%
}}
%></select>
</tr>
<tr>
<td><span class="form_label">IncidentNumber:</span><br><input type="text" name="IN" id="IN" class="form_styles"/></td>
<td><span class="form_label">ProblemNumber:</span><br><input type="text" name="PN" id="PN" class="form_styles"/></td>
</tr>




<tr>
<td><span class="form_label">CreateDate:</span><br><input type="text" id="datepicker" class="form_styles"/>
</td>

<td><span class="form_label">CloseDate:</span><br><input type="text" id="datepicker1" class="form_styles"/>
</td>
</tr>
<tr>
<td ><span class="form_label">IncidentTitle:</span><br><input type="text" name="IT" id="IT" class="form_styles" style="width: 90%;"/></td>

<td><span class="form_label">CauseCode:</span><br><select name="CC" id="CC" class="form_styles">
<option>select</option>
<option>dd</option>
<option>ff</option>
</select>
</td>
</tr>



<tr>

<td colspan="2"><span class="form_label">IncidentDescription</span> <br><textarea rows="4" cols="90" name="ID" id="ID" class="form_styles"> </textarea></td>
</tr>
<tr>
<td colspan="2"><span class="form_label">WorkAround</span><br><textarea rows="4" cols="90" name="WA" id="WA" class="form_styles"> </textarea></td>
</tr>

<tr>
<td colspan="2">
<center>
<input type="submit" value="Submit" align="middle" width="23" class="form_styles" id="submit"/>
</center>
</td>
</tr>


</table>
</form>
</div>
    <div id="footer">&copy; Developed by KEDB Development Team at Old Amex,DLF Chennai.<span style="float: right;"><script type="text/javascript" src="http://counter5.statcounterfree.com/private/counter.js?c=8767e1dff3d822720e3d7a4b284070cd"></script></span></div>
</body>
</html>