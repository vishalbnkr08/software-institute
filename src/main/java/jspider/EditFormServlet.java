package jspider;

import java.io.IOException;
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

@WebServlet("/edituser")
public class EditFormServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name") ;
		String email = req.getParameter("email") ;
		String yop = req.getParameter("yop") ;
		String stream = req.getParameter("stream") ;
		String password = req.getParameter("password") ;
		
		HttpSession session = req.getSession() ;
		String cpswd = (String) session.getAttribute("cpswd") ;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver") ;
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspider", "root", "root") ;
			PreparedStatement ps = con.prepareStatement("update student set name = ?, email = ?, yop = ?, stream = ?, password = ? where password = ?" );
			ps.setString(1, name) ;
			ps.setString(2, email) ;
			ps.setString(3, yop) ;
			ps.setString(4, stream) ;
			ps.setString(5, password) ;
			ps.setString(6, cpswd) ;
			ps.execute() ;
	
			PreparedStatement ps1 = con.prepareStatement("select * from student where password = ? ") ;
			ps1.setString(1, password) ;
			ResultSet rs1 = ps1.executeQuery() ;
			session.setAttribute("update_data", rs1) ;
			
			RequestDispatcher rd = req.getRequestDispatcher("welcomeupdate.jsp") ;
			rd.forward(req, resp) ;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
