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
<title>Quick-Fix:Search Results</title>
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

	 MyWindow=window.open('ViewIncident.jsp?number='+incno,'MyWindow','width=700, height=500,scrollbars=yes,top=30,left=100');
}

function openProblem(prbno) 
{

	   MyWindow=window.open('ViewProblem.jsp?number='+prbno,'MyWindow','width=700, height=500,scrollbars=yes,top=30,left=100');
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
<body style="background-color:#dae5f4;">


  <div id="strip">
<%@ include file="Header.jsp" %> 
  
  </div>
  
     <div id="main_body" style="background-image: none;">
  
<div>
<%

HttpSession hs=request.getSession();
Operations op=new Operations();

String advsrch=request.getParameter("srch");

%>


<form name="myform" action="/KEDB/JSP/AdvanceSearch.jsp" method="post">
<input type="text" name="srch" value="<%=advsrch%>" class="css_corner "/>
<input type="submit" value="Search" id="submit_adv"/>
</form>

   <br>

</div>
<table style="width:99.7%; height: 90px;" border="1" class="TFtable" >
<%
int i=0;
int k=0;
Operations op1=new Operations();
HashMap<String,String>  h=new HashMap<String,String>();

Enumeration<String> e=request.getParameterNames();
Enumeration<String> e1=null;
while(e.hasMoreElements())
{
	String temp=e.nextElement();
if(!(temp.equals(null)))
{	
k++;
String value=request.getParameter(temp);
System.out.print("values passed :"+value);
if(!(value.equals(null)||value==""||value.equals("--select--")))
{
h.put(temp,value);
i++;
}

}
}
Vector<String[]> vd=null;

{
String query=op1.createQuery2(advsrch);
vd=op1.search(query);
}
if(vd==null)
{	
%>
<p>No data found</p>
<%
}
else if(!(vd==null))
{
	
		%><tr>
		
	        <th class="style4">Incident Number</th>
            <th class="style11">Incident Title</th>
            <th class="style14">Problem Number</th>
            <th class="style12">Application</th>
            <th class="style7">Create date</th>
            <th class="style3">Close date</th>
            <th class="style3">Work Group</th>
           </tr>
          
         <% 
         Iterator<String[]> it=vd.iterator();
	while(it.hasNext())
	{%><tr><%
		String[] temp1=(String[])it.next();
		for(int j=1;j<=7;j++)
		{
			String temp=temp1[j-1]; 
			if(j==1)
			{
%>

<td><a href="javascript:openIncident('<%=temp%>');" ><%=temp%></a></td> 
<%
}
else if(j==3)
{
%>
 <td><a href="javascript:openProblem('<%=temp%>');" ><%=temp%></a></td> 
<%
}
else
{
%>
 <td><%=temp%></td>

<%
}
}
	%></tr><%
}
}

%>




    </table>
    
    </div>
    
    
</body>

</html>