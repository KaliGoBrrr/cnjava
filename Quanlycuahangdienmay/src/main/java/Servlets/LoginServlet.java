package Servlets;

import java.io.IOException;
import java.io. PrintWriter; 
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging. Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import Servlets.MySQLConntUtils;
import Servlets.UserAccount; 
import Servlets.DBUtils;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;

	
public LoginServlet () {
	super();

}
 
protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	response.getWriter().append("Served at: ").append(request.getContextPath());
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	Connection conn;
		try {
			conn = MySQLConntUtils.getMySQLConnection();
		
			String Username=request.getParameter("Username");
			String PassWord=request.getParameter("PassWord");
			UserAccount usr=new UserAccount (Username, PassWord); 
			
			
			UserAccount u=DBUtils.findUser(conn, usr.getUsername (), usr.getPassWord());
		
			if(u != null)
			{		
				UserAccount user=new UserAccount (u);
					request.setAttribute("Username", "Chào bạn: "+ user.getUsername());
		request.getRequestDispatcher("/Trangchu.jsp").forward(request, response);
		}
		else
		{
		
		response.setContentType("text/html;charset=UTF-8");
			try (PrintWriter out = response.getWriter()) {
				
				out.println("<!DOCTYPE html>");
				out.println("<html>"); 
				out.println("<head>");
				out.println("<title>Thông báo</title>");
				out.println("</head>"); 
				out.println("<body>");
				out.println("<h1>Thông tin đăng nhập không chính xác <a href=Login.jsp>Nhập lại</a></h1>");
				out.println("</body>"); 
				out.println("</html>");
				}
			}
		} catch (ClassNotFoundException ex) {
			
Logger.getLogger(LoginServlet.class.getName()). log (Level.SEVERE, null, ex); 
		} catch (SQLException ex) {
			
Logger.getLogger(LoginServlet.class.getName()).log (Level.SEVERE, null, ex);
				}
				}
			}