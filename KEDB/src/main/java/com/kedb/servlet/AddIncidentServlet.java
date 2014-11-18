package com.kedb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kedb.jdbc.Operations;
import com.kedb.util.Util;

/**
 * Servlet implementation class AddIncidentServlet
 */
@WebServlet("/AddIncidentServlet")
public class AddIncidentServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		HttpSession hs = request.getSession(true);
		String name=(String) hs.getAttribute("uname");
		
		Util u=new Util();
		Operations op=new Operations();
try{
String IncidentNumber=request.getParameter("IN");
String IncidentTitle=request.getParameter("IT");
String IncidentDescription=request.getParameter("ID");
String ProblemNumber=request.getParameter("PN");
String WorkAround=request.getParameter("WA");
String CauseCode=request.getParameter("CC");
String Application=request.getParameter("APP");
String CreateDate=request.getParameter("CD");
String CloseDate=request.getParameter("CCD");
String WorkGroup=request.getParameter("WG");
//CreateDate=u.getQuerydate(CreateDate);
//CloseDate=u.getQuerydate(CloseDate);

HttpSession s=request.getSession();
//String UserName=s.getAttribute("uname").toString();
boolean flag =op.addData(IncidentNumber, IncidentTitle, IncidentDescription, ProblemNumber, WorkAround, CauseCode, Application, CreateDate, CloseDate,name, WorkGroup);
if(flag)
{
RequestDispatcher rd=request.getRequestDispatcher("/JSP/AddIncident.jsp?success=true");
response.sendRedirect("/KEDB/JSP/AddIncident.jsp?success=true");
//rd.forward(request, response);
}
else
{

RequestDispatcher rd=request.getRequestDispatcher("/JSP/AddIncident.jsp?success=false");
response.sendRedirect("/KEDB/JSP/AddIncident.jsp?success=false");
//rd.forward(request, response);
	}
}catch(Exception e)
{
	e.printStackTrace();}
	}

}
