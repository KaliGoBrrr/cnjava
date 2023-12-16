package Servlets;

import static Servlets.DBUtils.insertChitietdonhang;
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

@WebServlet(name = "ChiTietDonHangServlet", urlPatterns = {"/ChiTietDonHangServlet"}) 
public class ChiTietDonHangServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException { 
		Connection conn = null; //connect SQL
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			String ma_chi_tiet_don_hang=request.getParameter("ma_chi_tiet_don_hang");
			String ma_don_hang=request.getParameter("ma_don_hang");
			String ma_san_pham=request.getParameter("ma_san_pham");
			int so_luong=Integer.parseInt(request.getParameter("so_luong"));
			double don_gia=Double.parseDouble(request.getParameter("don_gia"));
			//double tong_tien=Double.parseDouble(request.getParameter("tong_tien"));
			
			Chitietdonhang usr=new Chitietdonhang(ma_chi_tiet_don_hang, ma_don_hang, ma_san_pham, so_luong, don_gia);//, tong_tien);
			
			DBUtils.insertChitietdonhang(conn, usr);
			request.setAttribute("ma_chi_tiet_don_hang", ma_chi_tiet_don_hang);
			request.getRequestDispatcher("/ChiTietDonHangnew.jsp").forward(request, response);
		} catch (ClassNotFoundException ex) {
            Logger.getLogger(ChiTietDonHangServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietDonHangServlet.class.getName()).log(Level.SEVERE, null, ex);
       // } catch (NumberFormatException ex) {
       //     Logger.getLogger(SanPhamServlet.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					Logger.getLogger(ChiTietDonHangServlet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}
}