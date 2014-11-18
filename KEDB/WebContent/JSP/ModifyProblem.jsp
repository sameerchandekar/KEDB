<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.kedb.jdbc.*"%>
    <%@page import="com.kedb.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Problem</title>
</head>
<body>
<%
System.out.println("in modify servlet....");
Operations ops= new Operations();
String nbr=request.getParameter("number");
ProblemDetails pb= new ProblemDetails();
pb=ops.problem(nbr);
%>
<form action="/KEDB/ModifyProblemServlet" method="post">
<input type="hidden" name="pno" value="<%=pb.getProblemNumber()%>">
<table border="1" align="center">
<tr><td>Problem Number </td><td>
<%=pb.getProblemNumber()%></td>
</tr>
<tr><td>Problem Title </td><td><input type="text" name="pt" value="<%=pb.getProblemTitle()%>"></td></tr>
<tr><td>Problem Description </td><td><input type="text" name="pdesc" value="<%=pb.getProblemDescription()%>"></td></tr>
<tr><td>RCA </td><td><input type="text" name="rca"  value="<%=pb.getRCA()%>"></td></tr>
<tr><td>Permanent Resolution </td><td><input type="text" name="prca" value="<%=pb.getPermanantResolution()%>"></td></tr>
<tr><td>ETA </td><td><input type="text" name="eta" value="<%=pb.getETA()%>"></td></tr>
<tr><td>Application </td><td><%=pb.getApplication()%></td></tr>
<tr><td>Workgroup </td><td><%=pb.getWorkGroup()%></td></tr>
<tr><td>Last Updated User </td><td><%=pb.getLastupdUser()%></td></tr>
<tr><td>Last Updated Timestamp </td><td><%=pb.getLastupdTimestamp()%></td></tr>
<tr><td>Username </td><td><%=pb.getUserName()%></td></tr>
<tr><td>
<input type="submit" name="Modify" value="Modify"></td>
<td>
<%
String success=request.getParameter("success");

try{
	

if(success.equals("true"))
{
	
	
	%>
	<script type="text/javascript">
	alert("Problem modified successfully.");
	</script>
	<!-- <font color="green">
	data updated succefully! YOU can close this windows.
	</font> -->
	<%
}
if(success.equals("false"))
{
%>
	<script type="text/javascript">
	alert("Some error while modifying problem. Please try again later.");
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