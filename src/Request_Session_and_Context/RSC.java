package Request_Session_and_Context;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//1st way


//@WebServlet(description = "rsc example", urlPatterns = { "/rscpath" }
//			, initParams = @WebInitParam(name = "defaultuser" , value = "Chaman" )
//		)

public class RSC extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter writer = response.getWriter();
		String userName = request.getParameter("name");
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		if(userName != "" && userName != null)
		{
			session.setAttribute("SavedUserName", userName);
			context.setAttribute("SavedUserName", userName);
		}
		
		
		writer.println("Request parameter has username as : " + userName);
		
		////1 per user/per browser
		writer.println("Session parameter has username as : " +  (String)  (session.getAttribute("SavedUserName") ));
		
		//1 per application
		writer.println("Context parameter has username as : " +  (String)  (context.getAttribute("SavedUserName") ));
		
		
		//you can do the same using xml file
		writer.println("Init parameter has default username as : " + (String) (this.getServletConfig().getInitParameter("defaultuser")));
	}

}
