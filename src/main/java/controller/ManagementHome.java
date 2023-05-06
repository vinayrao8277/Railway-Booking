package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/managementLogin")
public class ManagementHome extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		if(email.equals("admin"))
		{
			if(password.equals("admin"))
			{
				resp.getWriter().print("<h1 style='color:green';>Login Success</h1>");
				req.getRequestDispatcher("ManagementHome.html").include(req, resp);
			}
			else
			{
				resp.getWriter().print("<h1 style='color:red';>Invalid Password</h1>");
				req.getRequestDispatcher("ManagementLogin.html").include(req, resp);
			}
		}
		else
		{
			resp.getWriter().print("<h1 style='color:red';>Invalid E-Mail</h1>");
			req.getRequestDispatcher("ManagementLogin.html").include(req, resp);
		}
	}
}
