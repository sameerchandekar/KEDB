package com.kedb.servlet;

import java.io.IOException;

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
 * Servlet implementation class AddProblemServlet
 */
@WebServlet("/AddProblemServlet")
public class AddProblemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProblemServlet() {
        super();
        
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		HttpSession hs = request.getSession(true);
		String name=(String) hs.getAttribute("uname");
		
		Util u=new Util();
		Operations op=new Operations();
try{
String ProblemNumber=request.getParameter("PN");
String ProblemTitle=request.getParameter("PT");
String ProblemDescription=request.getParameter("PD");
//String ProblemNumber=request.getParameter("PN");
//String WorkAround=request.getParameter("WA");
//String CauseCode=request.getParameter("CC");
String Application=request.getParameter("APP");
String ETA=request.getParameter("ETA");
String WorkGroup=request.getParameter("WG");
String RCA=request.getParameter("RCA");
String PR=request.getParameter("PR");
//String createDate=request.getParameter("CD");
//CreateDate=u.getQuerydate(CreateDate);
//CloseDate=u.getQuerydate(CloseDate);

System.out.println(Application+""+ ProblemNumber+""+ ProblemTitle+""+ProblemDescription+""+ETA+""+WorkGroup+""+RCA+""+PR );

HttpSession s=request.getSession();
//String UserName=s.getAttribute("uname").toString();
boolean flag =op.addProblem(ProblemNumber, ProblemTitle, ProblemDescription, RCA, PR, ETA, WorkGroup, Application,name);
if(flag)
{
RequestDispatcher rd=request.getRequestDispatcher("/JSP/AddProblem.jsp?success=true");
response.sendRedirect("/KEDB/JSP/AddProblem.jsp?success=true");
//rd.forward(request, response);
}
else
{

RequestDispatcher rd=request.getRequestDispatcher("/JSP/AddProblem.jsp?success=false");
response.sendRedirect("/KEDB/JSP/AddProblem.jsp?success=false");
//rd.forward(request, response);
	}
}catch(Exception e)
{
	e.printStackTrace();}
	}
		
		
		
		
		
	}


