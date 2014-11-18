package com.kedb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedb.jdbc.Operations;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		Enumeration<String> en=request.getParameterNames();
		String LOB=request.getParameter("LOB");
		String E2E=request.getParameter("E2E");
		String APP=request.getParameter("APP");
		
		Operations op=new Operations();
		Vector<String> v=new Vector<String>();
		Vector<String[]> v1=new Vector<String[]>();
		if((LOB!=null))
		{
			System.out.println("INSIDE AJAX LOB");
		v=op.getE2E(LOB);
		Iterator<String> it=v.iterator();
		pw.print("Portfolio :<select id='E2E' name='E2E' onchange=\"sendInfo1(this);\"  class=\"form_styles\">");
		pw.print("<option>--select--</option>");
		while(it.hasNext())
		{
		pw.print("<option>"+it.next()+"</option>");
		}
		}
		if((E2E!=null))
		{
			System.out.println("INSIDE AJAX E2E");
			v1=op.getApp(E2E);
			Iterator<String[]> it=v1.iterator();
			pw.print("<span>Application :<select id='APP' name='APP' onchange=\"getWorkGroup(this);\" class=\"form_styles\">");
			pw.print("<option>--select--</option>");
			while(it.hasNext())
			{
				String[] temp=new String[2];
				temp=it.next();
					System.out.println("E2E :");
					pw.print("<option>"+temp[0]+"</option>");
				}
			
			pw.print("</select>");
			pw.print("&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; ");
			
			
			Iterator<String[]> it1=v1.iterator();
			pw.print(" Work Group :<select id='WG' name='WG' onchange=\"getApp();\" class=\"form_styles\">");
			pw.print("<option>--select--</option>");
			while(it1.hasNext())
			{
				String[] temp=new String[2];
				temp=it1.next();
				
					System.out.println("E2E :");
					pw.print("<option>"+temp[1]+"</option>");
				}
			
			}
		pw.print("</select></span>");
	}

}
