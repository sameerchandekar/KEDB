<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%@page import="com.kedb.jdbc.*"%>
<%@page import="com.kedb.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Problem</title>
<LINK href="../CSS/ViewIncident.css" rel="stylesheet" type="text/css">

<script type="text/javascript">

function callModify(num){

	document.myform.action="/KEDB/JSP/ModifyIncident.jsp?number="+num;
document.myform.submit();
	
	
}

function callDelete(num) {
	document.myform.action="/KEDB/JSP/DeleteIncident.jsp?"+num;
	document.myform.submit();
	
}



</script>


</head>
<body  style="background-color:#dae5f4;">
<%
		Operations ops= new Operations();
		String nbr=request.getParameter("number");
	
		
			ProblemDetails in= new ProblemDetails();
			in=ops.problem(nbr);
			
		%>

<form name="myform" action="" method="post">

<input type="hidden" name="no" value="<%=in.getProblemNumber()%>">
<table border="0" align="center" class="form_label1" style="width: 80%;" cellpadding="2px" cellspacing="5px">

<tr><td class="form_label">Incident Number </td><td>
<%=in.getProblemNumber()%></td>
</tr>


<tr>
<td class="form_label">Problem Title </td><td><%=in.getProblemTitle()%></td>
</tr>

<tr>
<td class="form_label">Problem Description </td><td><%=in.getProblemDescription()%></td>
</tr>


<tr>
<td class="form_label">ETA </td><td><%=in.getETA()%></td>
</tr>

<tr>
<td class="form_label">Application </td><td><%=in.getApplication()%></td>
</tr>

<tr>
<td class="form_label">Permanent Resolution </td><td><%=in.getPermanantResolution()%></td>
</tr>

<tr>
<td class="form_label">RCA </td><td><%=in.getRCA()%></td>
</tr>

<tr>
<td class="form_label">Work Group </td><td><%=in.getWorkGroup()%></td>
</tr>

<tr><td class="form_label">Username </td><td><%=in.getUserName()%></td></tr>
<tr><td class="form_label">Last Updated By </td><td><%=in.getLastupdUser()%></td></tr>

<tr><td class="form_label">Last Updated on </td><td><%=in.getLastupdTimestamp()%></td></tr>
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