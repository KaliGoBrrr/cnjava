package Servlets;

import static Servlets.DBUtils.insertKhachhang;
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

@WebServlet(name = "KhachHangServlet", urlPatterns = {"/KhachHangServlet"}) 
public class KhachHangServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException { 
		Connection conn = null; //connect SQL
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			String ma_khach_hang=request.getParameter("ma_khach_hang");
			String ten_khach_hang=request.getParameter("ten_khach_hang");
			String dia_chi=request.getParameter("dia_chi");
			String dien_thoai=request.getParameter("dien_thoai");
			String email=request.getParameter("email");
			Khachhang usr=new Khachhang(ma_khach_hang, ten_khach_hang, dia_chi, dien_thoai, email);
			
			DBUtils.insertKhachhang(conn, usr);
			request.setAttribute("ma_khach_hang", ma_khach_hang);
			request.getRequestDispatcher("/KhachHangnew.jsp").forward(request, response);
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