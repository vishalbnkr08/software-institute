package jspider;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/readlogincookie")
public class ReadLoginCookie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession() ;
		ResultSet rs = (ResultSet) hs.getAttribute("userdetails") ;
		
		System.out.println(rs);
		try {
			ResultSetMetaData rsmd = rs.getMetaData() ;
			if (rsmd.getColumnCount()>0) {
				RequestDispatcher rd = req.getRequestDispatcher("Welcome.jsp") ;
				rd.forward(req, resp);
			} else {
				System.out.println("hi");
				PrintWriter out = resp.getWriter() ;
				out.write("please login first !");
				RequestDispatcher rd = req.getRequestDispatcher("Login.html") ;
				rd.include(req, resp);
				resp.setContentType("text/html");
			}
		} 
		
		 catch ( NullPointerException e) {
			 System.out.println("hello");
				PrintWriter out = resp.getWriter() ;
				out.write("please login first !");
				RequestDispatcher rd = req.getRequestDispatcher("Login.html") ;
				rd.include(req, resp);
				resp.setContentType("text/html");
		 }
		catch (SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
