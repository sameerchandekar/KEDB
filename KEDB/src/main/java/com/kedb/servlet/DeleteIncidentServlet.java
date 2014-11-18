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
import com.sun.org.apache.xpath.internal.operations.Operation;

/**
 * Servlet implementation class DeleteIncidentServlet
 */
@WebServlet("/DeleteIncidentServlet")
public class DeleteIncidentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteIncidentServlet() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		//String no=(String) session.getAttribute("no");
		String no=request.getParameter("no");
		/*String title=(String) session.getAttribute("title");
		String desc=(String) session.getAttribute("desc");
		String pno=(String) session.getAttribute("pno");
		String waround=(String) session.getAttribute("waround");
		String cc=(String) session.getAttribute("cc");
		String app=(String) session.getAttribute("app");
		String cdate=(String) session.getAttribute("cdate");
		String ccdate=(String) session.getAttribute("ccdate");
		String wg=(String) session.getAttribute("wg");
		String luser=(String) session.getAttribute("luser");
		String lts=(String) session.getAttribute("lts");
		String uname=(String) session.getAttribute("uname");*/
		Operations op=new Operations();
		int b=op.deleteIncident(no);
		if(b>0)
		{
			
			System.out.println("Query Executed successfully.");
			
			 response.sendRedirect("/KEDB/JSP/DeleteIncident.jsp?number="+no+""+"&success=true");
		}
		else
		{
			System.out.println("Query failed.");
			 response.sendRedirect("/KEDB/JSP/DeleteIncident.jsp?number="+no+""+"&success=false");
		}
		
		
		
	}

}
