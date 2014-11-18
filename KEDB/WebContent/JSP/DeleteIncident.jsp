<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.kedb.jdbc.*"%>
    <%@page import="com.kedb.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Incident</title>
<LINK href="../CSS/ViewIncident.css" rel="stylesheet" type="text/css">
<script src="../commonScript.js"></script> 




</head>
<body style="background-color:#dae5f4;">
<%

Operations ops= new Operations();
String nbr=request.getParameter("number");
Incident_Details in= new Incident_Details();
in=ops.incident(nbr);
%>

<form action="/KEDB/DeleteIncidentServlet" method="post" onsubmit="return confirmation();">
<input type="hidden" name="no" value="<%=in.getIncidentNumber()%>">
<table border="0" align="center" class="form_label1" style="width: 80%;" cellpadding="2px" cellspacing="5px">



<tr><td class="form_label">Incident Number </td>
<td> <%=in.getIncidentNumber() %></td>

</tr>

<tr>
<td class="form_label">Incident Title </td><td><%=in.getIncidentTitle()%></td>
</tr>

<tr>
<td class="form_label">Incident Description </td><td><%=in.getIncidentDescription()%></td>
</tr>

<tr>
<td class="form_label">Problem Number </td><td><%=in.getProblemNumber()%></td>
</tr>

<tr>
<td class="form_label">Workaround </td><td><%=in.getWorkAround()%></td>
</tr>

<tr>
<td class="form_label">Cause Code </td><td><%=in.getCauseCode()%></td>
</tr>

<tr>
<td class="form_label">Application </td><td><%=in.getApplication()%></td>
</tr>

<tr>
<td class="form_label">Create Date </td><td><%=in.getCreateDate()%></td>
</tr>

<tr>
<td class="form_label">Close Date </td><td><%=in.getCloseDate()%></td>
</tr>

<tr><td class="form_label">Username </td><td><%=in.getUserName()%></td></tr>
<tr><td class="form_label">Workgroup </td><td><%=in.getWorkGroup()%>"</td></tr>
<tr><td class="form_label">Last Updated User </td><td><%=in.getLastUpdatedUser()%></td></tr>
<tr><td class="form_label">Last Updated Timestamp </td><td><%=in.getLastUpdatedTimeStamp()%></td></tr>
<tr><td><input type="submit" name="Delete" id="delete" value="Delete"></td>
<td>

<%
String success=request.getParameter("success");

try{
	

if(success.equals("true"))
{
	
	
	%>
	<script type="text/javascript">
	alert("Incident deleted successfully.");
	window.close();
	
	</script>
	<!-- <font color="green">
	data deleted succefully! YOU can close this windows.
	</font> -->
	<%
}
if(success.equals("false"))
{
%>
	<script type="text/javascript">
	alert("Some issue in deleting incident. Please try again later.");
	</script>
	<%
}

}
catch(Exception e)
{
	
}
%>

</td></tr>

</table>
</form>
</body>
</html>