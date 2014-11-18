<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%@page import="com.kedb.jdbc.*;"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

function getLob() {
	
	var lob= document.getElementById("incno").value;
	
}

</script>


</head>
<body>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>


<form action="LobToWrkgrp.jsp" method="get" name="LobFilter">

<select id="LOB" " name="LOB">   <!-- onchange="getLob();--> 
   <option value="LOB1">LOB1</option>
   <option value="LOB2">LOB2</option>
   <option value="LOB3">LOB3</option>
   <option value="LOB4">LOB4</option>
</select>

<select id="E2E" name="E2E">

<% 

 try{
	 
	 PrintWriter pw=response.getWriter();
	 String lob=request.getParameter("LOB");
pw.write("parameter "+lob);
 ArrayList<String> data=new ArrayList<String>();
	 
 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 java.sql.Connection con=DriverManager.getConnection("jdbc:odbc:DSN","","");
 Statement st=con.createStatement();
 String sql="select E2E from LOB where LOB='"+lob+"'";
 ResultSet rs=st.executeQuery(sql);
 
 ResultSetMetaData md = rs.getMetaData();
	int col = md.getColumnCount();	
	String row[]=new String[18];
	
	
	int j=0;
	while(rs.next()) //(18) To copy result in array
	{
	for (int i = 1; i <=col; i++)
		{
		row[i-1]=rs.getString(i);	
		data.add(row[i-1]);
		}		
		
	}
	
   Iterator it = data.iterator();
   while(it.hasNext()){
	   String temp=it.next().toString();
	   System.out.println("data is "+temp);
   %>
   
 <option ><%=temp%></option>

   <%}
  }catch(Exception e){
	 e.printStackTrace();
  }     
 %>
 </select>


<select id="LOB">
   <option value="LOB1">LOB1</option>   
</select>

<input type="text" name="WORKGROUP" value=""/><br>


<input type="submit" name="submit" value="submit"/>


</form>
</body>
</html>