<%@page import="com.kedb.bean.TwoVector"%>
<%@page import="com.kedb.jdbc.Connection"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.kedb.jdbc.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quick-Fix:Known Error Database System</title>

<LINK href="../CSS/homepage.css" rel="stylesheet" type="text/css">



</head>

<body>
<%

    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>

<%

Operations op=new Operations();
String count1=op.countGCCI();
String count2=op.countGCCP();

String count3=op.countGMSI();
String count4=op.countGMSP();

String count5=op.countCTTI();
String count6=op.countCTTP();

String count7=op.countJAPAI();
String count8=op.countJAPAP(); 

String count9=op.countMBTI();
String count10=op.countMBTP();

Vector<String[]> gcci=op.topGCCI();
Vector<String[]> gccp=op.topGCCP();  
 
Vector<String[]> gmsi=op.topGMSI();
Vector<String[]> gmsp=op.topGMSP();

Vector<String[]> ctti=op.topCTTI();
Vector<String[]> cttp=op.topCTTP();

Vector<String[]> japai=op.topJAPAI();
Vector<String[]> japap=op.topJAPAP();
 

Vector<String[]> mbti=op.topMBTI();
Vector<String[]> mbtp=op.topMBTP(); 

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


   
 
  
 <div id="strip">
<%@ include file="Header.jsp" %> 
  </div>
  
        <div id="main_body">
        
        
        
       
        <div class="login" id="gcc_span" onmouseover="showdivGCC();"><div class="span_head">GCC</div><div class="span_desc" id="gcc_desc">
       <center><span style="text-align: center;">Total number of Incidents:<%=count1 %> 
Total number of Problems:<%=count2%> <hr>
Latest 3 Incident: <br>

      <% 
         Iterator<String[]> igcci=gcci.iterator();
	while(igcci.hasNext())
	{
		String[] temp1=igcci.next();
		
			String temp=temp1[0]; 
			
%>

<%=temp%><br>
		<%
			

	}
%>

<hr>

Latest 3 Problem: <br>

      <% 
         Iterator<String[]> igccp=gccp.iterator();
	while(igccp.hasNext())
	{
		String[] temp1=(String[])igccp.next();
		for(int j=1;j<2;j++)
		{
			String temp=temp1[j-1]; 
			
%>

<%=temp%><br>
		<%
			
}
	}
%>
 </span>  </center> </div> </div>
                               
                               
                               <div class="login"  id="gms_span" onmouseover="showdiGMSv();"><div class="span_head">GMS</div> <div class="span_desc" id="gcc_desc">
                         <center>     <span>Total number of Incidents: <%=count3%>
Total number of Problems: <%=count4%><hr>
Latest 3 Incident: <br>

      <% 
         Iterator<String[]> igmsi=gmsi.iterator();
	while(igmsi.hasNext())
	{
		String[] temp1=igmsi.next();
		
			String temp=temp1[0]; 
			
%>

<%=temp%><br>
		<%
			

	}
%>

<hr>

Latest 3 Problem: <br>

      <% 
         Iterator<String[]> igmsp=gmsp.iterator();
	while(igmsp.hasNext())
	{
		String[] temp1=(String[])igmsp.next();
		for(int j=1;j<2;j++)
		{
			String temp=temp1[j-1]; 
			
%>

<%=temp%><br>
		<%
			
}
	}
%>
</span> </center> </div></div>
                               
                               
                               
                               <div class="login"  id="japa_span" onmouseover="showdivJAPA();"><div class="span_head">JAPA</div> <div class="span_desc" id="gcc_desc">
                           <center>     <span>Total number of Incidents: <%=count7%>
Total number of Problems: <%=count8%><hr>
Latest 3 Incident: <br>

      <% 
         Iterator<String[]> ijapai=japai.iterator();
	while(ijapai.hasNext())
	{
		String[] temp1=ijapai.next();
		
			String temp=temp1[0]; 
			
%>

<%=temp%><br>
		<%
			

	}
%>

<hr>

Latest 3 Problem: <br>

      <% 
         Iterator<String[]> ijapap=japap.iterator();
	while(ijapap.hasNext())
	{
		String[] temp1=(String[])ijapap.next();
		for(int j=1;j<2;j++)
		{
			String temp=temp1[j-1]; 
			
%>

<%=temp%><br>
		<%
			
}
	}
%>

 </span></center> </div> </div>
  
    
                               <div class="login"  id="ctt_span" onmouseover="showdivCTT();"><div class="span_head">CTT</div> <div class="span_desc" id="gcc_desc">
                        <center>        <span>Total number of Incidents: <%=count5%>
Total number of Problems:<%=count6%> <hr>
Latest 3 Incident: <br>

      <% 
         Iterator<String[]> ictti=ctti.iterator();
	while(ictti.hasNext() )
	{
		String[] temp1=ictti.next();
		
			String temp=temp1[0]; 
			
%>

<%=temp%><br>
		<%
			

	}
%>

<hr>

Latest 3 Problem: <br>

      <% 
         Iterator<String[]> icttp=cttp.iterator();
	while(icttp.hasNext())
	{
		String[] temp1=(String[])icttp.next();
		for(int j=1;j<2;j++)
		{
			String temp=temp1[j-1]; 
			
%>

<%=temp%><br>
		<%
			
}
	}
%>
</span></center> </div> </div>
  
  
  
    <div class="login"  id="mbt_span" onmouseover="showdivMBT();"><div class="span_head">MBT</div> <div class="span_desc" id="gcc_desc">
   <center>  <span>Total number of Incidents: <%=count9%>
Total number of Problems: <%=count10%><hr>
Latest 3 Incident: <br>

<% 
         Iterator<String[]> imbti=mbti.iterator();
	while(imbti.hasNext() )
	{
		String[] temp1=imbti.next();
		
			String temp=temp1[0]; 
			
%>

<%=temp%><br>
		<%
			

	}
%>

<hr>

Latest 3 Problem: <br>

      <% 
         Iterator<String[]> imbtp=mbtp.iterator();
	while(imbtp.hasNext())
	{
		String[] temp1=(String[])imbtp.next();
		for(int j=1;j<2;j++)
		{
			String temp=temp1[j-1]; 
			
%>

<%=temp%><br>
		<%
			
}
	}
%>

</span></center> </div> </div>
  
  
  
  
  
  
  
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