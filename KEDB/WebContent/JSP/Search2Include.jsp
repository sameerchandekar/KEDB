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
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css"> 
 <script src="//code.jquery.com/jquery-1.10.2.js"></script>
 <script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script> 
 <script src="../commonScript.js"></script> 
 <link rel="stylesheet" href="/resources/demos/style.css">  
 <LINK href="../CSS/homepage.css" rel="stylesheet" type="text/css">
 <LINK href="../CSS/Search.css" rel="stylesheet" type="text/css">


<script>  
$(function() { 
	 $( "#datepicker" ).datepicker(); 
	 $( "#datepicker1" ).datepicker(); 
	 }
);  


</script>
<script type="text/javascript">
function openIncident(incno) 
{
	   MyWindow=window.open('ViewIncident.jsp?INCNO='+incno,'MyWindow','width=700, height=450,scrollbars=yes,top=30,left=100');
}

function openProblem(prbno) 
{
	   MyWindow=window.open('ViewProblem.jsp?INCNO='+prbno,'MyWindow','width=700, height=450,scrollbars=yes,top=30,left=100');
}

var request;  
function sendInfo(LOB)  
{  
var v=LOB.value; 

var url="/KEDB/AjaxServlet?LOB="+v;  
  
if(window.XMLHttpRequest){  
request=new XMLHttpRequest();  
}  
else if(window.ActiveXObject){  
request=new ActiveXObject("Microsoft.XMLHTTP");  
}  
  
try{  
request.onreadystatechange=getInfo;  
request.open("POST",url,true);  
request.send();  
}catch(e){alert("Unable to connect to server");}  
}  
  
function getInfo(){  
if(request.readyState==4){  
var val=request.responseText;  
document.getElementById("E@E").innerHTML=val; 
}  
}




var request1;  
function sendInfo1(E2E)  
{  
var v=E2E.value; 

var url="/KEDB/AjaxServlet?E2E="+v;  
  
if(window.XMLHttpRequest){  
request1=new XMLHttpRequest();  
}  
else if(window.ActiveXObject){  
request1=new ActiveXObject("Microsoft.XMLHTTP");  
}  
  
try{  
request1.onreadystatechange=getInfo1;  
request1.open("POST",url,true);  
request1.send();  
}catch(e){alert("Unable to connect to server");}  
}  
  
function getInfo1(){  
if(request.readyState==4){  
var val=request1.responseText;  
document.getElementById("APP").innerHTML=val;

}  
}











var request2;  
function sendInfo2(APP)  
{  
var v=APP.value; 
var url="/KEDB/AjaxServlet?APP="+v;  
  
if(window.XMLHttpRequest){  
request2=new XMLHttpRequest();  
}  
else if(window.ActiveXObject){  
request2=new ActiveXObject("Microsoft.XMLHTTP");  
}  
  
try{  
request2.onreadystatechange=getInfo2;  
request2.open("POST",url,true);  
request2.send();  
}catch(e){alert("Unable to connect to server");}  
}  
  	
function getInfo2(){  
if(request2.readyState==4){  
var val=request2.responseText;  
document.getElementById("WG").innerHTML=val; 
}  
}








function subLOB()
{
	var a=document.getElementById("lob").value;
	document.myform.action="/KEDB/JSP/Search.jsp?LOB1="+a;
	document.myform.submit();
}

function subE2E()
{
	var a=document.getElementById("e2e").value;
	document.myform.action="/KEDB/JSP/Search.jsp?E2E1="+a;
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




<div>
<%
//TwoVector tv=new TwoVector();
HttpSession hs=request.getSession();
/* Vector<String> v=null;
Vector<String> v1=null;
Vector<String> v2=null;
 */
 Operations op=new Operations();
String LOB=request.getParameter("LOB1");
String E2E=request.getParameter("E2E1");
String success=request.getParameter("success");
/* if(LOB!=null)
{
	v=op.getE2E(LOB);
}
if(E2E!=null)
{
	tv=op.getAppWork(E2E);
	v1=tv.v1;
	v2=tv.v2;
}
 */

%>








<form name="myform" action="Search.jsp" method="post">
<%
if(success!=null)
{
	if(success.equals("true"))
	{
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
<table cellpadding="15"  align="center" border="0" style=" width:100%;">
<tr>
<td colspan="1"><span class="form_label">LOB:</span> <select id="lob" name="LOB" onchange="sendInfo(this);" class="form_styles"  >
<option>--select--</option>
<option>GCC</option>
<option>GMS</option>
<option>OMS</option>
<option>CTT</option>
</select>
</td>



<td colspan="1" id="E@E" style="font-size:medium;font-family:calibri;font-weight: 700;"><span class="form_label">E2E:</span>
<select id="E2E" name="E2E" onchange="subE2E();">
<option>--select--</option>
</select></td>

</tr>
<tr>

<td colspan="2"  id="APP" style="font-size:medium;font-family:calibri;font-weight: 700;"><span class="form_label">Application :</span>  
<select id="AP" name="AP" onchange="subAPP();">
<option>--select--</option>
</select></td>
</tr>
<tr>


<!-- <td colspan="1" id="WG" style="font-size:medium;font-family:calibri;font-weight: 700;"><span class="form_label">WorkGroup :</span> </td>
-->
</tr>


<tr>
<td colspan="1"><span class="form_label">IncidentNumber: </span><input type="text" name="IN"/></td>
<td colspan="1"><span class="form_label">ProblemNumber: </span><input type="text" name="PN"/></td>

</tr>
<tr>
<td colspan="2"><span class="form_label">IncidentTitle: </span><input type="text" name="IT" style="width:515px;"/></td>

</tr>
<tr>
 <td colspan="2"><span class="form_label">IncidentDescription: </span><input type="text" name="ID" style="width:468px;"/></td>
</tr>



<tr>

<td colspan="1"><span class="form_label">CreateDate: </span><input id="datepicker" type="text" name="CD"/></td>
<td colspan="1"><span class="form_label">CloseDate: </span><input id="datepicker1" type="text" name="COD"/></td>
</tr>
<tr>
<td colspan="2"><span class="form_label">WorkAround: </span><input type="text" name="WA"/></td>
</tr>
<tr>

<td colspan="2"><span class="form_label">CauseCode:</span><br><select name="CC" id="CC" class="form_styles">
<option>select</option>
<option>Connectivity_Issue</option>
<option>Database_Issue</option>
<option>Scheduled_Change</option>
<option>Manual_Error</option>
<option>Code_Issue</option>
<option>Infrastructure Issue</option>
<option>Others</option>
</select>
</td>

</tr>


<tr>
<td>

<input type="submit" value="Search" align="middle" width="23" class="form_styles" id="submit" style="float: left"/>
</td>

</tr>

</table>

</form>

   

</div>
   
</body>

</html>