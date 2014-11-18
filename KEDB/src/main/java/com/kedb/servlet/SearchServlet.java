package com.kedb.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kedb.bean.Incident_Details;
import com.kedb.jdbc.Operations;
import com.kedb.util.Util;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Util u=new Util();
		Operations op=new Operations();
try{
String choice=request.getParameter("ch");
String number=request.getParameter("no");
//CreateDate=u.getQuerydate(CreateDate);
//CloseDate=u.getQuerydate(CloseDate);

HttpSession s=request.getSession();
//String UserName=s.getAttribute("uname").toString();
ResultSet RS =op.searchData(choice,number);
Incident_Details inc=new Incident_Details();
while(RS.next())
{
	System.out.println("incise while");
	String no=RS.getString(1);
	String title=RS.getString(2);
	String desc=RS.getString(3);
	String pno=RS.getString(4);
	String waround=RS.getString(5);
	String cc=RS.getString(6);
	String app=RS.getString(7);
	String cdate=RS.getString(8);
	String ccdate=RS.getString(9);
	String uname=RS.getString(10);
	String wg=RS.getString(11);
	String luser=RS.getString(12);
	String lts=RS.getString(13);
	
	request.setAttribute("no",no);
	request.setAttribute("title",title);
	request.setAttribute("desc",desc);
	request.setAttribute("pno",pno);
	request.setAttribute("waround",waround);
	request.setAttribute("cc",cc);
	request.setAttribute("app",app);
	request.setAttribute("cdate",cdate);
	request.setAttribute("ccdate",ccdate);
	request.setAttribute("uname",uname);
	request.setAttribute("wg",wg);
	request.setAttribute("luser",luser);
	request.setAttribute("lts",lts);

	
}




RequestDispatcher rd=request.getRequestDispatcher("/JSP/SearchResult.jsp?success=true");
rd.forward(request, response);

/*if(flag)
{
RequestDispatcher rd=request.getRequestDispatcher("/JSP/demo.jsp?success=true");
rd.forward(request, response);
}
else
{

RequestDispatcher rd=request.getRequestDispatcher("/JSP/demo.jsp?success=false");
rd.forward(request, response);
	}*/

}catch(Exception e)
{
	e.printStackTrace();}
	}

}
