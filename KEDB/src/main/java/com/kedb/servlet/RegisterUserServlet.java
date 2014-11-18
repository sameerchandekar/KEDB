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
 * Servlet implementation class RegisterUserServlet
 */
@WebServlet("/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegisterUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession hs = request.getSession(true);
		String name=(String) hs.getAttribute("uname");
		
		Util u=new Util();
		Operations op=new Operations();
		
		try{
			String username=request.getParameter("username");
			String password=request.getParameter("pwd");
			String isAdmin=request.getParameter("isAdmin");
			String isSpoc=request.getParameter("isSpoc");
			boolean admin=false;
			boolean spoc=false;
			
			if(isAdmin.equals("yes"))
			{
				admin=true;
			}
			else {
				admin=false;
			}
			
			if(isSpoc.equals("yes"))
			{
				spoc=true;
			}
			else {
				spoc=false;
			}
			
			
			
			System.out.println(" "+username+" "+password+" "+isAdmin+" "+isSpoc);
			
			HttpSession s=request.getSession();
			//String UserName=s.getAttribute("uname").toString();
			boolean flag =op.addUser(username,password,admin,spoc);
			if(flag)
			{
			//RequestDispatcher rd=request.getRequestDispatcher("/JSP/Register.jsp?success=true");
			response.sendRedirect("/KEDB/JSP/Register.jsp?success=true");
			
			}
			else
			{

			//RequestDispatcher rd=request.getRequestDispatcher("/JSP/AddIncident.jsp?success=false");
			response.sendRedirect("/KEDB/JSP/Register.jsp?success=false");
			//rd.forward(request, response);
				}
			}catch(Exception e)
			{
				
				e.printStackTrace();}
				}
	
	
	}


