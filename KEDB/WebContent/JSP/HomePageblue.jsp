<%@page import="com.kedb.bean.TwoVector"%>
<%@page import="com.kedb.jdbc.Connection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to KEDB:Known Error Database System</title>

<LINK href="../CSS/homepage1.css" rel="stylesheet" type="text/css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

 

<script  type="text/javascript">  

window.onload = maxWindow;
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

<body>

<%
String search=request.getParameter("Search");
String addIncident=request.getParameter("AddIncident");
String addProblem=request.getParameter("AddProblem");
String modify=request.getParameter("Modify");
String delete=request.getParameter("Delete");
%>

  
   
 
  
 <div id="strip">
 <ul id="menu_wrap" class="Blue"><li class="button"><a href="HomePage.jsp" id="kedb" style="width: 150px;">Quick-Fix</a></li><li class="button"><a href="Search.jsp">Advanced Search</a></li><li class="button"><a href="AddIncident.jsp">Add Incident</a></li><li class="button"><a href="AddProblem.jsp">Add Problem</a></li><li class="button"><a href="Modify.jsp">Modify</a></li><li class="button"><a href="Delete.jsp">Delete</a></li> <li class="search"><a href="#"></a><input type="text"  /><li class="button"></li><li class="button"><a href="Search.jsp">>GO</a></li> <li class="button"></li><li class="button" style="float: right;"><a href="Search.jsp">Log Out</a></li> </ul>
  <span id ="wc_user">Welcome <font color="white"><%=session.getAttribute("uname") %></font> </span>
  
  
  </div>
  
        <div id="main_body">
        
     
      
        
        <div class="login" id="gcc_span" onmouseover="showdivGCC();"><div class="span_head">GCC</div><div class="span_desc" id="gcc_desc">
        <pre>Total number of Incidents: 
Total number of Problems: </pre></div> </div>
                               
                               
                               <div class="login"  id="gms_span" onmouseover="showdiGMSv();"><div class="span_head">GMS</div> <div class="span_desc" id="gcc_desc">
                               <pre>Total number of Incidents: 
Total number of Problems: </pre></div></div>
                               
                               
                               
                               <div class="login"  id="japa_span" onmouseover="showdivJAPA();"><div class="span_head">JAPA</div> <div class="span_desc" id="gcc_desc"><pre>Total number of Incidents: 
Total number of Problems: </pre></div> </div>
  
    
                               <div class="login"  id="ctt_span" onmouseover="showdivCTT();"><div class="span_head">CTT</div> <div class="span_desc" id="gcc_desc"><pre>Total number of Incidents: 
Total number of Problems: </pre></div> </div>
  
  
  
    <div class="login"  id="mbt_span" onmouseover="showdivMBT();"><div class="span_head">MBT</div> <div class="span_desc" id="gcc_desc"><pre>Total number of Incidents: 
Total number of Problems: </pre></div> </div>
  
  

  
             </div>
  

  
  <div id="footer">&copy; Developed by KEDB Development Team at Old Amex,DLF Chennai.<span style="float: right;"><script type="text/javascript" src="http://counter5.statcounterfree.com/private/counter.js?c=8767e1dff3d822720e3d7a4b284070cd"></script></span></div>


</body>
</html>