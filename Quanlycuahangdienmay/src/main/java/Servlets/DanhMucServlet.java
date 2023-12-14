package Servlets;

import static Servlets.DBUtils.insertDanhmuc;
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

@WebServlet(name = "DanhMucServlet", urlPatterns = {"/DanhMucServlet"}) 
public class DanhMucServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException { 
		Connection conn = null; //connect SQL
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			String ma_danh_muc=request.getParameter("ma_danh_muc");
			String ten_danh_muc=request.getParameter("ten_danh_muc");
			
			Danhmuc usr=new Danhmuc(ma_danh_muc, ten_danh_muc);
			
			DBUtils.insertDanhmuc(conn, usr);
			DBUtils.updateDanhmuc(conn, usr);
			request.setAttribute("ma_danh_muc", ma_danh_muc);
			request.getRequestDispatcher("/DanhMucnew.jsp").forward(request, response);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(DanhMucServlet.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(DanhMucServlet.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					Logger.getLogger(DanhMucServlet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}
}