package com.kedb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kedb.jdbc.Operations;

/**
 * Servlet implementation class ModifyIncidentServlet
 */
@WebServlet("/ModifyIncidentServlet")
public class ModifyIncidentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyIncidentServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	
	{
		PrintWriter pw=response.getWriter();
		
		HttpSession session=request.getSession();
		//String no=(String)session.getAttribute("no");
		String no=request.getParameter("no");
		String title=request.getParameter("title");
		String desc=request.getParameter("desc");
		String pno=request.getParameter("pno");
		String waround=request.getParameter("waround");
		String cc=request.getParameter("CC");
		//String app=request.getParameter("app");
		//String cdate=request.getParameter("cdate");
		//String ccdate=request.getParameter("ccdate");
		//String uname=request.getParameter("uname");
		///String wg=request.getParameter("wg");
		String luser=(String)session.getAttribute("uname");
		
		//String lts=request.getParameter("lts");
		
		
		
		Operations op=new Operations();
		int modify=op.modifyIncident(title,desc,pno,waround,cc,luser,no);
		
		if(modify>0)
		{
			//KEDB/JSP/ModifyIncident.jsp?number="+number+""
			pw.print("");
			pw.print("Data modified successfully");
		  response.sendRedirect("/KEDB/JSP/ModifyIncident.jsp?number="+no+""+"&success=true");
		}
		else
		{
			response.sendRedirect("/KEDB/JSP/ModifyIncident.jsp?number="+no+""+"&success=false");
		}
		
		
	}

}
