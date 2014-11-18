<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%@page import="com.kedb.jdbc.*"%>
<%@page import="com.kedb.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Incident</title>
<LINK href="../CSS/ViewIncident.css" rel="stylesheet" type="text/css">

<script type="text/javascript">

function callModify(num){

	//alert("number is :"+num);
	document.myform.action="/KEDB/JSP/ModifyIncident.jsp?number="+num;
document.myform.submit();
	
	
}

function callDelete(num) {
	//alert("number is :"+num);
	document.myform.action="/KEDB/JSP/DeleteIncident.jsp?number="+num;
	document.myform.submit();
	
}



</script>

</head>
<body style="background-color:#dae5f4;">
<%
		Operations ops= new Operations();
		String nbr=request.getParameter("number");
	
		
			Incident_Details in= new Incident_Details();
			in=ops.incident(nbr);
			
		%>

<form name="myform" action="" method="post">

<input type="hidden" name="no" value="<%=in.getIncidentNumber()%>">
<table border="0" align="center" class="form_label1" style="width: 80%;" cellpadding="2px" cellspacing="5px">

<tr><td>Incident Number </td><td>
<%=in.getIncidentNumber()%></td>
</tr>


<tr>
<td><span class="form_label">Incident Title</span> </td><td><%=in.getIncidentTitle()%></td>
</tr>

<tr>
<td><span class="form_label">Incident Description</span> </td><td><%=in.getIncidentDescription()%></td>
</tr>

<tr>
<td><span class="form_label">Problem Number</span> </td><td><%=in.getProblemNumber()%></td>
</tr>

<tr>
<td><span class="form_label">Workaround</span> </td><td><%=in.getWorkAround()%></td>
</tr>

<tr>
<td><span class="form_label">Cause Code</span> </td><td><%=in.getCauseCode()%></td>
</tr>

<tr>
<td><span class="form_label">Application</span> </td><td><%=in.getApplication()%></td>
</tr>

<tr>
<td><span class="form_label">Create Date</span> </td><td><%=in.getCreateDate()%></td>
</tr>

<tr>
<td><span class="form_label">Close Date</span> </td><td><%=in.getCloseDate()%></td>
</tr>

<tr><td><span class="form_label">Username </span> </td><td><%=in.getUserName()%></td></tr>
<tr><td><span class="form_label">Workgroup </td><td><%=in.getWorkGroup()%></td></tr>
<tr><td><span class="form_label">Last Updated User</span> </td><td><%=in.getLastUpdatedUser()%></td></tr>
<tr><td><span class="form_label">Last Updated Timestamp</span> </td><td><%=in.getLastUpdatedTimeStamp()%></td></tr>
<tr>
<td><input type="button" name="modify" id="modify" value="Click to Modify" onclick="callModify('<%=nbr%>');" >
</td>
<td><input type="button" name="delete" id="delete" value="Click to Delete" onclick="callDelete('<%=nbr%>');">
</td>


</tr>
</table>
</form>
</body>
</html>