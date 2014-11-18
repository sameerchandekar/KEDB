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
<title>View Incident</title>



</head>
<body>

<%

String currentUser=(String)session.getAttribute("uname");

System.out.println("in modify incident jsp....");
		Operations ops= new Operations();
		String nbr=request.getParameter("number");
		//String ticket=request.getParameter("tkt");
		
			Incident_Details in= new Incident_Details();
			in=ops.incident(nbr);
			
		%>
<form action="/KEDB/ModifyIncidentServlet" method="post">

<input type="hidden" name="luser" value="<%=currentUser%>" >
<input type="hidden" name="no" value="<%=in.getIncidentNumber()%>">
<table border="1" align="center">

<tr>
<td>Incident Number </td><td><%=in.getIncidentNumber()%></td>
</tr>


<tr>
<td>Incident Title </td><td><input type="text" name="title" value="<%=in.getIncidentTitle()%>"></td>
</tr>

<tr>
<td>Incident Description </td><td><input type="text" name="desc" value="<%=in.getIncidentDescription()%>"></td>
</tr>

<tr>
<td>Problem Number </td><td><input type="text" name="pno" value="<%=in.getProblemNumber()%>"></td>
</tr>

<tr>
<td>Workaround </td><td><input type="text" name="waround" value="<%=in.getWorkAround()%>"></td>
</tr>

<tr>
<td>Cause Code </td><td>
<select name="CC" id="CC" >
<option selected="selected"><%=in.getCauseCode()%></option>
<option >Connectivity_Issue</option>
<option>Database_Issue</option>
<option>Scheduled_Change</option>
<option>Manual_Error</option>
<option>Code_Issue</option>
<option>Infrastructure Issue</option>
<option>Others</option>
</select>

</tr>

<tr>
<td>Application </td><td><%=in.getApplication()%></td>
</tr>

<tr>
<td>Create Date </td><td><%=in.getCreateDate()%></td>
</tr>

<tr>
<td>Close Date </td><td><%=in.getCloseDate()%></td>
</tr>

<tr><td>Username </td><td><%=in.getUserName()%></td></tr>
<tr><td>Workgroup </td><td><%=in.getWorkGroup()%></td></tr>
<tr><td>Last Updated User </td><td><%=in.getLastUpdatedUser()%></td></tr>
<tr><td>Last Updated Timestamp </td><td><%=in.getLastUpdatedTimeStamp()%></td></tr>
<tr>
<td><input type="submit" name="Modify" id="Modify" value="Modify">
</td>
<td>
<%
String success=request.getParameter("success");

try{
	

if(success.equals("true"))
{
	
	
	%>
	<script type="text/javascript">
	alert("Incident modified successfully.");
	</script>
	
	<%
}
if(success.equals("false"))
{
%>
	<script type="text/javascript">
	alert("Some error while updating incident. Please try again later.");
	</script>
	<%
}

}
catch(Exception e)
{
	
}
%>

</td>

</tr>
</table>
</form>
</body>
</html>