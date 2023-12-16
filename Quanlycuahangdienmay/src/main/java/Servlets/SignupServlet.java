package Servlets;

import static Servlets.DBUtils.insertUserAccount;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation. WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SignupServlet", urlPatterns = {"/SignupServlet"}) 
public class SignupServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException { 
		Connection conn = null; //connect SQL
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			String Username=request.getParameter("Username");
			String Gender=request.getParameter("Gender");
			String PassWord=request.getParameter("PassWord");
			
			UserAccount usr=new UserAccount(Username, Gender, PassWord);
			
			DBUtils.insertUserAccount(conn, usr);
			request.setAttribute("Username", Username);
			request.getRequestDispatcher("/Signup.jsp").forward(request, response);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(SignupServlet.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(SignupServlet.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					Logger.getLogger(SignupServlet.class.getName()).log(Level.SEVERE, null, ex);
}}}}}