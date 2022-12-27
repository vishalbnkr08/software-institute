package jspider;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

@WebServlet("/confirmservlet")
public class ConfirmServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cpswd = req.getParameter("confirm_pswd") ;
		
		HttpSession session = req.getSession() ;
		String pswd = (String) session.getAttribute("pswd") ;
		
		
		
		if(pswd.equals(cpswd)) {
			session.setAttribute("cpswd", cpswd);
			RequestDispatcher rd = req.getRequestDispatcher("editForm.jsp") ;
			rd.forward(req, resp);
		}
		else {
			PrintWriter out = resp.getWriter() ;
			out.write("please enter correct password !");
			RequestDispatcher rd = req.getRequestDispatcher("confirmation.jsp") ;
			rd.include(req, resp);
			resp.setContentType("text/html");
		}
	}
}
