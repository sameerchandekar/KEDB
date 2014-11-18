package com.kedb.servlet;

import com.kedb.jdbc.*;
import com.kedb.bean.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/ModifyServlet")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("in modify servlet....");
		Operations ops= new Operations();
		String nbr=request.getParameter("number");
		String ticket=request.getParameter("tkt");
		if(ticket.equals("inc"))
		{
			Incident_Details in= new Incident_Details();
			in=ops.incident(nbr);
			
			System.out.println("in inc"+in.getIncidentNumber());
			HttpSession session=request.getSession();
			session.setAttribute("no",in.getIncidentNumber());
			session.setAttribute("title",in.getIncidentTitle());
			session.setAttribute("desc",in.getIncidentDescription());
			session.setAttribute("pno",in.getProblemNumber());
			session.setAttribute("waround",in.getWorkAround());
			session.setAttribute("cc",in.getCauseCode());
			session.setAttribute("app",in.getApplication());
			session.setAttribute("cdate",in.getCreateDate());
			session.setAttribute("ccdate",in.getCloseDate());
			session.setAttribute("uname",in.getUserName());
			session.setAttribute("wg",in.getWorkGroup());
			session.setAttribute("luser",in.getLastUpdatedUser());
			System.out.println("luser...."+in.getLastUpdatedUser());
			session.setAttribute("lts",in.getLastUpdatedTimeStamp());
			System.out.println("lts...."+in.getLastUpdatedTimeStamp());
			
			
			response.sendRedirect("/KEDB/JSP/ModifyIncident.jsp");
			

			
		}
		
		if(ticket.equals("prb"))
		{
			ProblemDetails pb= new ProblemDetails();
			pb=ops.problem(nbr);
			
			System.out.println("in prb"+pb.getProblemNumber());
			HttpSession session=request.getSession();
			session.setAttribute("pno",pb.getProblemNumber());
			session.setAttribute("pt",pb.getProblemTitle());
			session.setAttribute("pdesc",pb.getProblemDescription());
			session.setAttribute("rca",pb.getRCA());
			session.setAttribute("prca",pb.getPermanantResolution());
			session.setAttribute("eta",pb.getETA());
			session.setAttribute("app",pb.getApplication());
			session.setAttribute("wg",pb.getWorkGroup());
			session.setAttribute("luu",pb.getLastupdUser());
			session.setAttribute("lut",pb.getLastupdTimestamp());
			session.setAttribute("unm",pb.getUserName());
			
			response.sendRedirect("/KEDB/JSP/ModifyProblem.jsp");
			
			
		}	
	
		
		
	}

}
