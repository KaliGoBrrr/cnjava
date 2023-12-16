package Servlets;

import static Servlets.DBUtils.insertDonhang;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation. WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DonHangServlet", urlPatterns = {"/DonHangServlet"}) 
public class DonHangServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException { 
		Connection conn = null; //connect SQL
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			String ma_don_hang=request.getParameter("ma_don_hang");
			String ma_khach_hang=request.getParameter("ma_khach_hang");
			String ma_san_pham=request.getParameter("ma_san_pham");
			String ngay_mua_hang=request.getParameter("ngay_mua_hang");

			Donhang usr=new Donhang(ma_don_hang, ma_khach_hang, ma_san_pham, ngay_mua_hang);
			
			DBUtils.insertDonhang(conn, usr);
			request.setAttribute("ma_don_hang", ma_don_hang);
			request.getRequestDispatcher("/DonHangnew.jsp").forward(request, response);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(DonHangServlet.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(DonHangServlet.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					Logger.getLogger(DonHangServlet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}
}