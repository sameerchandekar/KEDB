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
@WebServlet("/DeleteProblemServlet")
public class DeleteProblemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteProblemServlet() {
        super();
       
    }

	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		//String pno=(String) session.getAttribute("pno");
		String pno=request.getParameter("pno");
		/*String pt=(String) session.getAttribute("pt");
		String pdesc=(String) session.getAttribute("pdesc");
		String rca=(String) session.getAttribute("rca");
		String prca=(String) session.getAttribute("prca");
		String eta=(String) session.getAttribute("eta");
		String app=(String) session.getAttribute("app");
		String wg=(String) session.getAttribute("wg");
		String luu=(String) session.getAttribute("luu");
		String lut=(String) session.getAttribute("lut");
		String unm=(String) session.getAttribute("unm");*/
		Operations op=new Operations();
		int b=op.deleteProblem(pno);
		if(b>0)
		{
			
			System.out.println("Query Executed successfully.");
			
			 response.sendRedirect("/KEDB/JSP/DeleteProblem.jsp?number="+pno+""+"&success=true");
		}
		else
		{
			System.out.println("Query failed.");
			response.sendRedirect("/KEDB/JSP/DeleteProblem.jsp?number="+pno+""+"&success=false");
			
		}
		
		
		
	}

}
