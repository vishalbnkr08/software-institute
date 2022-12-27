package jspider;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logoutservlet")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession() ;
		session.invalidate();
		
		
		
		PrintWriter pw = resp.getWriter() ;
		pw.write("logout Successfully !");
		RequestDispatcher rd = req.getRequestDispatcher("Home.html") ;
		rd.include(req, resp);
		resp.setContentType("text/html");
	}
}
