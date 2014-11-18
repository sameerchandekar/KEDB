<%@page import="com.kedb.bean.TwoVector"%>
<%@page import="com.kedb.jdbc.Connection"%>
<%@page import="java.sql.*"%>
<%@page import="com.kedb.jdbc.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to KEDB:Known Error Database System</title>

<LINK href="../CSS/homepage.css" rel="stylesheet" type="text/css">
<style type="text/css">
#modify_butt{
display: none;
}

#delete_butt{
display: none;
}


#reg_butt{
display: none;
}


</style>

<script type="text/javascript">

function Search()
{
	
var a=document.getElementById("advsrh").value;
	
	document.search.action="/KEDB/JSP/AdvanceSearch.jsp?srch="+a;
	document.search.submit();
}



function maxWindow()
{
	
	role();
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


function role()
{
	
	
	 var a= document.getElementById("role").value;
 
	 if(a=="admin")
	 {
		 document.getElementById("modify_butt").style.display = "block";
		 document.getElementById("delete_butt").style.display = "block";
		 document.getElementById("reg_butt").style.display = "block";
	 }
	
	 
	 
	 
}



function clear_fun_adv()
{
	document.getElementById('advsrh').setAttribute("value","");
	
	
}
function validate_adv()
{
	 var a= document.getElementById("advsrh").value;
	 
	 if(a==null || a=="")
	 {
		 alert('Please enter your query first then click GO');
		 return false;
	 }
	 
	 else
		 {
     
     return true;
		 }
	
}






</script>






<script type="text/javascript">






 
</script>
  








</head>

<body    onload="maxWindow();">

<%
String search=request.getParameter("Search");
String addIncident=request.getParameter("AddIncident");
String addProblem=request.getParameter("AddProblem");
String modify=request.getParameter("Modify");
String delete=request.getParameter("Delete");
%>
<input type="hidden" id="role" value="<%=session.getAttribute("role") %>">


 <ul id="menu_wrap" class="Black"> <li class="button"><a href="HomePage.jsp" id="kedb">Quick-Fix</a></li> <li class="button"><a href="Search.jsp">Search</a></li><li class="button"><a href="AddIncident.jsp">Add Incident</a></li><li class="button"><a href="AddProblem.jsp">Add Problem</a></li><li class="button" id="modify_butt"><a href="Modify.jsp">Modify</a></li> <li class="button" id="delete_butt"><a href="Delete.jsp" >Delete</a></li> <li class="button" id="reg_butt"><a href="Register.jsp" >Register</a></li> 
 
 <li class="search"><a href="#"></a>
 
 <form name="search" action="" method="post"> 
  <input  id="advsrh" type="text" onclick="clear_fun_adv();" Value="Put your query and click 'GO'"/>  
  </form>
  <li class="button">
  <a href="javascript:Search();" onclick="return validate_adv();" onmouseover="clear_fun_adv();" >&gt;GO</a>
  </li>
  
  
  
 
 
 
 
  
   <li class="button" style="float: right;"><a href="/KEDB/LogoutServlet">Log Out</a></li></ul>
  
    <span id ="wc_user">Welcome <font color="white"><%=session.getAttribute("uname") %></font> </span>
  
  
  
 
  </body>
  </html>