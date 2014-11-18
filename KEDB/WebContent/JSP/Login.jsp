<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Syntel:Known Error Database System</title>
<style type="text/css">
div.login {
position:relative;
top:5%;
left:70%;
    width: 220px;
    height:200px;
    padding: 10px;
    border: 5px aqua appworkspace;
    margin: 0px;
   background-image: url("../IMAGES/3.png");
   box-shadow: 10px 10px 5px #888888;
    
}


#heading
{
font-family:sans-serif;
color:#FFFAF0;
font-size:50px;
width:100%;
height:10%;
background: -moz-linear-gradient(top, #4D94B8 0%, #006699 100%);background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#4D94B8), color-stop(100%,#006699));background: -webkit-linear-gradient(top, #4D94B8 0%,#006699 100%);background: -o-linear-gradient(top, #4D94B8 0%,#006699 100%);background: -ms-linear-gradient(top, #4D94B8 0%,#006699 100%);filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#4D94B8', endColorstr='#006699',GradientType=0 );background: linear-gradient(top, #4D94B8 0%,#006699 100%);

position: relative;
top:0px;
font-weight:900;;
font-stretch: expanded;
border-bottom-color:black; 


}

#l1{
font-family: fantasy;
color:;
font-size:x-large;


}

.l2
{
font-family:cursive;
color:;
font-size: medium;
width:210px ;
height:45px ;
opacity:0.5;


}


.l2:hover
{
opacity:1;
}


#desc_div
{

font-family:serif;
color:black;
font-size:large;
position:relative;
left:1%;
top:-40% ;
background-color: white;
z-index:-5;

width:65%;





}

</style>

<script type="text/javascript">
function clear_fun()
{
	document.getElementById('idf').setAttribute("value","");
	document.getElementById('pwd').setAttribute("value","");
	document.getElementById('pwd').setAttribute("type","password");
}
function validate()
{
	 var a= document.getElementById("idf").value;
	 var b= document.getElementById("pwd").value;
	 if(a==null || a=="" || b==null || b=="" )
	 {
		 alert('Fields cannot be left blank');
		 return false;
	 }
	 
	 else
		 {
     
     return true;
		 }
	
}

</script>


<script type="text/javascript">


function maxWindow()
{
	
	
window.moveTo(0,0);
if (document.all)
{
top.window.resizeTo(screen.availWidth,screen.availHeight);
}
else if (document.layers||document.getElementById)
{
if (top.window.outerHeight<screen.availHeight||top.window.outerWidth<screen.availWidth)
{
top.window.outerHeight = screen.availHeight;
top.window.outerWidth = screen.availWidth;
}
}
}
</script>






</head>
<body onload="maxWindow();">











<div style="width: 80%; height:70%; position:absolute; top:10%; left:10%; border:solid;  border-color:#4D94B8;" id="body_div">

<div id="heading">Quick-Fix</div>
<br>
<div class="login">


<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>



<%
String ifValid=request.getParameter("invalid");
String LoggedOut=request.getParameter("LoggedOut");
System.out.println("IF valid is : "+ifValid);
if((ifValid!=null))//if((ifValid!=null)||ifValid!=""||!(ifValid.equals("null")))
{	System.out.println("inside if : ");
%>
<font color="red" size="2" face="arial">ohh..!! You are not a valid user.</font>
<%
}

if((LoggedOut!=null))//if((ifValid!=null)||ifValid!=""||!(ifValid.equals("null")))
{	System.out.println("inside if : ");
%>
<font color="red" size="2" face="arial">You are logged out !!</font>
<%
}

if(session.equals(null))
{
System.out.println("inside if session: ");
String role=session.getAttribute("Role").toString();
String uname=session.getAttribute("uname").toString(); 
%>
 <a href="/KEDB/Logout">Logout</a>
<% 
}
%>









<form action="/KEDB/LoginServlet" onsubmit="return validate();" method="post">

<input type="text" Class="l2" name="id" value="Your Id here" id="idf" onclick="clear_fun()">
<br><br>
<input type="text" Class="l2" name="pwd" value="Your password here" id="pwd"  onclick="clear_fun()">

<br><br><br>
<input type="submit" Class="l2" Value="Login" onmouseover="clear_fun()">

</form>
</div>

 <img style="opacity:0.8; height:60%; width:68%; position: relative; top:-35% ; left:; z-index: -10;" src="../IMAGES/4.jpg"/>


<div id="desc_div">
  <img src="../IMAGES/QFlogo1.jpg">

</div>
   <img style="opacity:0.8; height: 14%; width: 11%; position:absolute; top:-2% ; left:88% ;" src="../IMAGES/amex.png">
   <img style="opacity:0.8; width:28%; height:10%;  position:absolute; top:90%; left:70% ;" src="../IMAGES/logo.jpg">
</div>

</body>
</html>

