package com.kedb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kedb.jdbc.Operations;

/**
 * Servlet implementation class ModifyProblemServlet
 */
@WebServlet("/ModifyProblemServlet")
public class ModifyProblemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyProblemServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	
	{
		System.out.println("in modify pro setlet");
		HttpSession session=request.getSession();
		//String pno=(String)session.getAttribute("pno");
		String pno=request.getParameter("pno");
		System.out.println("pno..."+pno);
		String pt=request.getParameter("pt");
		String pdesc=request.getParameter("pdesc");
		String rca=request.getParameter("rca");
		String prca=request.getParameter("prca");
		String eta=request.getParameter("eta");
		//String app=request.getParameter("app");
		//String wg=request.getParameter("wg");
		//String luu=request.getParameter("luu");
		String luu=(String)session.getAttribute("uname");
		//String lut=request.getParameter("lut");
		//String unm=request.getParameter("unm");
		Operations op=new Operations();
		int modifyPro=op.modifyProblem(pt,pdesc,rca,prca,eta,luu,pno);
		
		if(modifyPro>0)
		{
			
			response.sendRedirect("/KEDB/JSP/ModifyProblem.jsp?number="+pno+""+"&success=true");
		}
		else
		{
			response.sendRedirect("/KEDB/JSP/ModifyProblem.jsp?number="+pno+""+"&success=false");
		}
	}

}
