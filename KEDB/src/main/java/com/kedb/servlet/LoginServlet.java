package com.kedb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.kedb.jdbc.*;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
Operations op=new Operations();
		try
{
String uname=request.getParameter("id");
String pswd=request.getParameter("pwd");
boolean flag=op.validate(uname,pswd);
if(flag==true)
{
String role=op.checkRole(uname,pswd);
System.out.println("role is "+role);
if(role.equals("admin"))
{
	System.out.println("in if loop"+role);
	RequestDispatcher rd=request.getRequestDispatcher("/JSP/HomePage.jsp?");
	HttpSession session=request.getSession(true);
	session.setAttribute("uname", uname);
	session.setAttribute("admin", true);
	session.setAttribute("role","admin");
	String s=session.getId();
	response.sendRedirect("/KEDB/JSP/HomePage.jsp?id="+s);
	//rd.forward(request, response);
}
else if(role=="spoc")
{
	RequestDispatcher rd=request.getRequestDispatcher("/JSP/HomePage.jsp");
	HttpSession session=request.getSession(true);
	session.setAttribute("uname", uname);
	session.setAttribute("spoc", true);
	session.setAttribute("role","spoc");
	String s=session.getId();
	response.sendRedirect("/KEDB/JSP/HomePage.jsp?id="+s);
	//rd.forward(request, response);
}
else
{
	RequestDispatcher rd=request.getRequestDispatcher("/JSP/HomePage.jsp");
	HttpSession session=request.getSession(true);
	session.setAttribute("uname", uname);
	session.setAttribute("user", true);
	session.setAttribute("role","user");
	String s=session.getId();
	response.sendRedirect("/KEDB/JSP/HomePage.jsp?id="+s);
	//rd.forward(request, response);

	}
}
else
{
	RequestDispatcher rd=request.getRequestDispatcher("/JSP/Login.jsp?invalid=true");
	response.sendRedirect("/KEDB/JSP/Login.jsp?invalid=true");
	
	//rd.forward(request, response);

}

}
catch(Exception e)
{
	e.printStackTrace();
	RequestDispatcher rd=request.getRequestDispatcher("/JSP/Login.jsp?exception=true");
	rd.forward(request, response);
	
	}
		
		
	}

}
