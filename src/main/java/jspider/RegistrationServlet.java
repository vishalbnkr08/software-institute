package jspider;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		fetch the data from user
		String name = req.getParameter("name") ;
		String email = req.getParameter("email") ;
		String yop = req.getParameter("yop") ;
		String stream = req.getParameter("stream") ;
		String password = req.getParameter("password") ;
		
//		Store information in database
		try {
			Class.forName("com.mysql.cj.jdbc.Driver") ;
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspider", "root", "root") ;
			PreparedStatement ps = con.prepareStatement("insert into student (name, email, yop, stream, password)values (?, ?, ?, ?, ?)") ;
			ps.setString(1, name) ;
			ps.setString(2, email) ;
			ps.setString(3, yop) ;
			ps.setString(4, stream) ;
			ps.setString(5, password) ;
			
			ps.execute() ;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		create session and stored information inside server
//		HttpSession session = req.getSession() ;
//		session.setAttribute("name", name) ;
//		session.setAttribute("email", email) ;
//		session.setAttribute("yop", yop) ;
//		session.setAttribute("stream", stream) ;
//		session.setAttribute("password", password) ;
		
//		after registration redirect to login page 
		PrintWriter pw = resp.getWriter() ;
		pw.write("Successfully Register !") ;
		RequestDispatcher rd = req.getRequestDispatcher("Login.html") ;
		rd.include(req, resp) ;
		resp.setContentType("text/html") ;
		
	}
}
