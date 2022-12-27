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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginvalidation")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		fetch data from login page
		String email = req.getParameter("email") ;
		String password = req.getParameter("password") ;
		HttpSession session = req.getSession() ;
		
		try {
//			validating login credential
			Class.forName("com.mysql.cj.jdbc.Driver") ;
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspider", "root", "root") ;
			PreparedStatement ps = con.prepareStatement("select * from student where email = ? and password = ? ") ;
			ps.setString(1, email) ;
			ps.setString(2, password) ;
			ResultSet rs = ps.executeQuery() ;
		
			PreparedStatement ps1 = con.prepareStatement("select * from student where email = ? and password = ? ") ;
			ps1.setString(1, email) ;
			ps1.setString(2, password) ;
			ResultSet rs1 = ps1.executeQuery() ;
		
			
			
			if(rs.isBeforeFirst()) {
				
				
				
				session.setAttribute("userdetails", rs) ;
				session.setAttribute("user", rs1) ;
				session.setAttribute("email", email) ;
				session.setAttribute("pswd", password);
				
//				while(rs.next()) {
//					session.setAttribute("name", rs.getString(2)) ;
//					session.setAttribute("email", rs.getString(3)) ;
//					session.setAttribute("yop", rs.getString(4)) ;
//					session.setAttribute("stream", rs.getString(5)) ;
//					session.setAttribute("pswd", rs.getString(6)) ;
//				}
				
				PrintWriter pw = resp.getWriter() ;
				pw.write("login successfully !") ;
				RequestDispatcher rd = req.getRequestDispatcher("Welcome.jsp") ;
				rd.include(req, resp) ;
				resp.setContentType("text/html") ;
			}
			else {
				PrintWriter pw = resp.getWriter() ; 
				pw.write("Invalid credential !") ;
				RequestDispatcher rd = req.getRequestDispatcher("Login.html") ;
				rd.include(req, resp) ;
				resp.setContentType("text/html") ;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
