
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
<title>Quick-Fix:Add Incident</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css"> 
 <script src="//code.jquery.com/jquery-1.10.2.js"></script>
 <script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script> 
 <script src="../commonScript.js"></script> 
 <link rel="stylesheet" href="/resources/demos/style.css">  
 <LINK href="../CSS/homepage.css" rel="stylesheet" type="text/css">
 <LINK href="../CSS/AddIncident.css" rel="stylesheet" type="text/css">
 <script> 
 
 function getApp()
 {
 	var index = myform.WG.selectedIndex;
 	myform.APP.selectedIndex=index;	
 	
 		
 }

 function getWorkGroup()
 {
 	var index = myform.APP.selectedIndex;
 	myform.WG.selectedIndex=index;		
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
 document.getElementById("E2E").innerHTML=val; 
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

function addIncidentValidate1()
{
	alert("in ssss");
	}


</script>
</head>
<body style="background-color:#dae5f4;">
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>

<%

//if(session)
//String name=session.getAttribute("uname").toString();
//out.print(session.getAttribute("uname"));
//session.equals(null)||session.equals("")
//session.equals(null);


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
<%@ include file="Header.jsp" %> 
  
  </div>
        <div id="main_body" style="background-image: none;">

<form name="myform" action="../AddIncidentServlet" method="post" onsubmit="return addIncidentValidate();">
<%
if(success!=null)
{
	if(success.equals("true")){
%>
<script type="text/javascript">
	alert("Incident added successfully.");
	</script>
<%
	}
	else{
%>
<script type="text/javascript">
	alert("Some issue in adding incident. Please try again later");
	</script>
<%} }%>

<table cellpadding="15"  align="center" border="0" style=" width: 90%;">
<tr>
<td style="width:50%;"><span class="form_label">LOB:</span><select id="lob" name="LOB" onchange="sendInfo(this);" class="form_styles" >
<option>--select--</option>
<option>GCC</option>
<option>GMS</option>
<option>JAPA</option>
<option>CTT</option>
<option>MBT</option>
<option>OMS</option>
</select></td>



<td  id="E2E" style="font-size:x-large;font-family:calibri;font-weight: 700;width:50%;"> <span class="form_label">Portfolio:</span><select id="E2E" name="E2E" onchange="subE2E();" class="form_styles">
<option>--select--</option>
</select>
</td>
</tr>

<tr>

<td colspan="2" id="APP" style="font-size:x-large;font-family:calibri;font-weight: 700;"><span class="form_label">Application:</span><select id="APP" name="APP" onchange="subAPP();"  class="form_styles">
<option>--select--</option>
</select></td>

<!--  <td id="WG" style="font-size:x-large;font-family:calibri;font-weight: 700;"><span class="form_label">Work Group:</span><select id="WG" name="WG" onchange="subAPP();"  class="form_styles"> 

<option>--select--</option>
</select></td>-->

</tr>

<tr>
<td style="width:50%;"><span class="form_label">IncidentNumber:</span><br><input type="text" name="IN" id="IN" class="form_styles"/></td>
<td  style="width:50%;"><span class="form_label">ProblemNumber:</span><br><input type="text" name="PN" id="PN" class="form_styles"/></td>
</tr>




<tr>
<td style="width:50%;"><span class="form_label">CreateDate:</span><br><input type="text" id="datepicker" name="CD" class="form_styles"/>
</td>

<td  style="width:50%;"><span class="form_label">CloseDate:</span><br><input type="text" id="datepicker1" name="CCD" class="form_styles"/>
</td>
</tr>
<tr>
<td style="width:50%;" ><span class="form_label">IncidentTitle:</span><br><input type="text" name="IT" id="IT" class="form_styles" style="width: 90%;"/></td>

<td  style="width:50%;"><span class="form_label">CauseCode:</span><br><select name="CC" id="CC" class="form_styles">
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

<td colspan="2"><span class="form_label">IncidentDescription:</span> <br><textarea rows="4" cols="90" name="ID" id="ID" class="form_styles"> </textarea></td>
</tr>
<tr>
<td colspan="2"><span class="form_label">WorkAround:</span><br><textarea rows="4" cols="90" name="WA" id="WA" class="form_styles"> </textarea></td>
</tr>

<tr>
<td colspan="3">
<center>
<input type="submit" value="Submit" align="middle" width="23" class="form_styles" id="submit" style="float: right;"/>
</center>
</td>
</tr>


</table>
</form>
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