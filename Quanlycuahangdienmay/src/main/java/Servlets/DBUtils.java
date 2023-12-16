package Servlets;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList; 
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBUtils {
//////////////////////////////////////////////////////////////////////////////////////////////
	public static UserAccount findUser(Connection conn, String Username, String PassWord) throws SQLException {
	
		String sql = "SELECT a.Username, a.PassWord, a.Gender FROM UserAccount a WHERE a.Username = ? AND a.PassWord = ?";

	
	PreparedStatement pstm = conn.prepareStatement(sql);
	
	pstm.setString(1, Username);
	
	pstm.setString(2, PassWord);
	
	ResultSet rs = pstm.executeQuery();
	
	
	if (rs.next()) {
		String Gender = rs.getString("Gender");
		UserAccount user = new UserAccount();
		user.setUsername(Username);
		user.setPassWord(PassWord);
		user.setGender(Gender);
		return user;
	}
	
	return null;
}
		
public static UserAccount findUser(Connection conn, String Username) throws SQLException { 
	String sql = "SELECT a.Username, a.PassWord, a.Gender FROM UserAccount a WHERE a.Username = ?";

		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, Username);
		
		ResultSet rs = pstm.executeQuery();
		
		
		if (rs.next()) {
			String PassWord=rs.getString("PassWord");
			String Gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUsername(Username);
			user.setPassWord(PassWord);
			user.setGender(Gender);
			
			return user;
		}
		return null;
	}
	public static void insertUserAccount(Connection conn, UserAccount user) throws SQLException {
		String sql = "INSERT INTO UserAccount(Username, Gender, PassWord) VALUES (?,?,?)";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, user.getUsername());
		pstm.setString(2, user.getGender());
		pstm.setString(3, user.getPassWord());
		pstm.executeUpdate ();
		}
///////////////////////////////////////////////////////////////////////////////////////////////
public static Danhmuc findDanh(Connection conn, String ma_danh_muc, String ten_danh_muc) throws SQLException {
	
	String sql = "SELECT a.ma_danh_muc, a.ten_danh_muc FROM Danhmuc a WHERE a.ma_danh_muc = ? AND a.ten_danh_muc = ?";


PreparedStatement pstm = conn.prepareStatement(sql);

pstm.setString(1, ma_danh_muc);

pstm.setString(2, ten_danh_muc);

ResultSet rs = pstm.executeQuery();


if (rs.next()) {
	Danhmuc user = new Danhmuc();
	user.setMa_danh_muc(ma_danh_muc);
	user.setTen_danh_muc(ten_danh_muc);
	return user;
}

return null;
}
	
public static Danhmuc findDanh(Connection conn, String ma_danh_muc) throws SQLException { 
String sql = "SELECT a.ma_danh_muc, a.ten_danh_muc FROM Danhmuc a WHERE a.ma_danh_muc = ?";

	
	PreparedStatement pstm = conn.prepareStatement(sql);
	pstm.setString(1, ma_danh_muc);
	
	ResultSet rs = pstm.executeQuery();
	
	
	if (rs.next()) {
		String ten_danh_muc=rs.getString("Ten_danh_muc");
		Danhmuc user = new Danhmuc();
		user.setMa_danh_muc(ma_danh_muc);
		user.setTen_danh_muc(ten_danh_muc);
		
		return user;
	}
	return null;
}
public static void insertDanhmuc(Connection conn, Danhmuc user) throws SQLException {
	String sql = "INSERT INTO Danhmuc(ma_danh_muc, ten_danh_muc) VALUES (?,?)";
	
	PreparedStatement pstm = conn.prepareStatement(sql);
	pstm.setString(1, user.getMa_danh_muc());
	pstm.setString(2, user.getTen_danh_muc());
	pstm.executeUpdate ();
	}
public static void updateDanhmuc(Connection conn, Danhmuc danhMuc) throws SQLException {
    String sql = "UPDATE Danhmuc SET ten_danh_muc = ? WHERE ma_danh_muc = ?";
    
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setString(1, danhMuc.getTen_danh_muc());
    pstm.setString(2, danhMuc.getMa_danh_muc());
    
    pstm.executeUpdate();
}

public static void deleteDanhmuc(Connection conn, String ma_danh_muc) throws SQLException {
    String sql = "DELETE FROM Danhmuc WHERE ma_danh_muc = ?";
    
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setString(1, ma_danh_muc);
    
    pstm.executeUpdate();
}

public static List<Danhmuc> findDanhmuc(Connection conn, String keyword) throws SQLException {
    List<Danhmuc> danhMucList = new ArrayList<>();
    String sql = "SELECT ma_danh_muc, ten_danh_muc FROM Danhmuc WHERE ten_danh_muc LIKE ?";
    
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setString(1, "%" + keyword + "%");
    
    ResultSet rs = pstm.executeQuery();
    
    while (rs.next()) {
        Danhmuc danhMuc = new Danhmuc();
        danhMuc.setMa_danh_muc(rs.getString("ma_danh_muc"));
        danhMuc.setTen_danh_muc(rs.getString("ten_danh_muc"));

        danhMucList.add(danhMuc);
    }
    
    return danhMucList;
}


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static Sanpham findSan(Connection conn, String ma_san_pham, String ten_san_pham, Double gia, int so_luong_trong_kho, String nha_san_xuat,
		String ma_danh_muc) throws SQLException {
	
	String sql = "SELECT a.ma_san_pham,a.ten_san_pham,a.gia,a.so_luong_trong_kho,a.nha_san_xuat,a.ma_danh_muc FROM Sanpham a WHERE a.ma_san_pham = ? AND a.ten_san_pham = ? AND a.gia = ? AND a.so_luong_trong_kho = ? AND a.nha_san_xuat = ? AND a.ma_danh_muc = ?";


PreparedStatement pstm = conn.prepareStatement(sql);

pstm.setString(1, ma_san_pham);
pstm.setString(2, ten_san_pham);
pstm.setDouble(3, gia);
pstm.setInt(4, so_luong_trong_kho);
pstm.setString(5, nha_san_xuat);
pstm.setString(6, ma_danh_muc);

ResultSet rs = pstm.executeQuery();


if (rs.next()) {
	Sanpham user = new Sanpham();
	user.setMa_san_pham(ma_san_pham);
	user.setTen_san_pham(ten_san_pham);
	user.setGia(gia);
	user.setSo_luong_trong_kho(so_luong_trong_kho);
	user.setNha_san_xuat(nha_san_xuat);
	user.setMa_danh_muc(ma_danh_muc);
	return user;
}

return null;
}
	
public static Sanpham findSan(Connection conn, String ma_san_pham) throws SQLException { 
String sql = "SELECT a.ma_san_pham,a.ten_san_pham,a.gia,a.so_luong_trong_kho,a.nha_san_xuat,a.ma_danh_muc FROM Sanpham a WHERE a.ma_san_pham = ?";

	
	PreparedStatement pstm = conn.prepareStatement(sql);
	pstm.setString(1, ma_san_pham);
	
	ResultSet rs = pstm.executeQuery();
	
	
	if (rs.next()) {
		String ten_san_pham=rs.getString("Ten_san_pham");
		double gia=rs.getDouble("Gia");
		int so_luong_trong_kho=rs.getInt("So_luong_trong_kho");
		String nha_san_xuat=rs.getString("Nha_san_xuat");
		String ma_danh_muc=rs.getString("Ma_danh_muc");
		Sanpham user = new Sanpham();
		user.setMa_san_pham(ma_san_pham);
		user.setTen_san_pham(ten_san_pham);
		user.setGia(gia);
		user.setSo_luong_trong_kho(so_luong_trong_kho);
		user.setNha_san_xuat(nha_san_xuat);
		user.setMa_danh_muc(ma_danh_muc);
		return user;
	}
	return null;
}

public static void insertSanpham(Connection conn, Sanpham user) throws SQLException {
	String sql = "INSERT INTO Sanpham(ma_san_pham, ten_san_pham, gia, so_luong_trong_kho, nha_san_xuat, ma_danh_muc) VALUES (?,?,?,?,?,?)";
	
	PreparedStatement pstm = conn.prepareStatement(sql);
	pstm.setString(1, user.getMa_san_pham());
	pstm.setString(2, user.getTen_san_pham());
	pstm.setDouble(3, user.getGia());
	pstm.setInt(4, user.getSo_luong_trong_kho());
	pstm.setString(5, user.getNha_san_xuat());
	pstm.setString(6, user.getMa_danh_muc());
	pstm.executeUpdate ();
	}
public static void updateSanpham(Connection conn, Sanpham sanPham) throws SQLException {
    String sql = "UPDATE SanPham SET ten_san_pham = ?, gia = ?, so_luong_trong_kho = ?, nha_san_xuat = ?, ma_danh_muc = ? WHERE ma_san_pham = ?";
    
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setString(1, sanPham.getTen_san_pham());
    pstm.setDouble(2, sanPham.getGia());
    pstm.setInt(3, sanPham.getSo_luong_trong_kho());
    pstm.setString(4, sanPham.getNha_san_xuat());
    pstm.setString(5, sanPham.getMa_danh_muc());
    pstm.setString(6, sanPham.getMa_san_pham());
    
    pstm.executeUpdate();
}


public static void deleteSanpham(Connection conn, String ma_san_pham) throws SQLException {
    String sql = "DELETE FROM Sanpham WHERE ma_san_pham = ?";
    
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setString(1, ma_san_pham);
    
    pstm.executeUpdate();
}

public static List<Sanpham> findSanpham(Connection conn, String keyword) throws SQLException {
    List<Sanpham> sanPhamList = new ArrayList<>();
    String sql = "SELECT ma_san_pham, ten_san_pham, gia, so_luong_trong_kho, nha_san_xuat, ma_danh_muc FROM Sanpham WHERE ten_san_pham LIKE ?";
    
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setString(1, "%" + keyword + "%");
    
    ResultSet rs = pstm.executeQuery();
    
    while (rs.next()) {
    	Sanpham sanPham = new Sanpham();
    	sanPham.setMa_san_pham(rs.getString("ma_san_pham"));
    	sanPham.setTen_san_pham(rs.getString("ten_san_pham"));
    	sanPham.setGia(rs.getDouble("gia"));
    	sanPham.setSo_luong_trong_kho(rs.getInt("so_luong_trong_kho"));
    	sanPham.setNha_san_xuat(rs.getString("nha_san_xuat"));
    	sanPham.setMa_danh_muc(rs.getString("ma_danh_muc"));

    	sanPhamList.add(sanPham);
    }
    
    return sanPhamList;
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static Khachhang findKhach(Connection conn, String ma_khach_hang, String ten_khach_hang, String dia_chi, String dien_thoai, String email,
String ma_danh_muc) throws SQLException {

String sql = "SELECT a.ma_khach_hang,a.ten_khach_hang,a.dia_chi,a.dien_thoai,a.email FROM Khachhang a WHERE a.ma_khach_hang = ? AND a.ten_khach_hang = ? AND a.dia_chi = ? AND a.dien_thoai = ? AND a.email = ?";


PreparedStatement pstm = conn.prepareStatement(sql);

pstm.setString(1, ma_khach_hang);
pstm.setString(2, ten_khach_hang);
pstm.setString(3, dia_chi);
pstm.setString(4, dien_thoai);
pstm.setString(5, email);

ResultSet rs = pstm.executeQuery();


if (rs.next()) {
Khachhang user = new Khachhang();
user.setMa_khach_hang(ma_khach_hang);
user.setTen_khach_hang(ten_khach_hang);
user.setDia_chi(dia_chi);
user.setDien_thoai(dien_thoai);
user.setEmail(email);
return user;
}

return null;
}

public static Khachhang findKhach(Connection conn, String ma_khach_hang) throws SQLException { 
String sql = "SELECT a.ma_khach_hang,a.ten_khach_hang,a.dia_chi,a.dien_thoai,a.email FROM Khachhang a WHERE a.ma_khach_hang = ?";


PreparedStatement pstm = conn.prepareStatement(sql);
pstm.setString(1, ma_khach_hang);

ResultSet rs = pstm.executeQuery();


if (rs.next()) {
String ten_khach_hang=rs.getString("Ten_khach_hang");
String dia_chi=rs.getString("Dia_chi");
String dien_thoai=rs.getString("Dien_thoai");
String email=rs.getString("Email");
Khachhang user = new Khachhang();
user.setMa_khach_hang(ma_khach_hang);
user.setTen_khach_hang(ten_khach_hang);
user.setDia_chi(dia_chi);
user.setDien_thoai(dien_thoai);
user.setEmail(email);
return user;
}
return null;
}

public static void insertKhachhang(Connection conn, Khachhang user) throws SQLException {
String sql = "INSERT INTO Khachhang(ma_khach_hang, ten_khach_hang, dia_chi, dien_thoai, email) VALUES (?,?,?,?,?)";

PreparedStatement pstm = conn.prepareStatement(sql);
pstm.setString(1, user.getMa_khach_hang());
pstm.setString(2, user.getTen_khach_hang());
pstm.setString(3, user.getDia_chi());
pstm.setString(4, user.getDien_thoai());
pstm.setString(5, user.getEmail());
pstm.executeUpdate ();
}
public static void updateKhachhang(Connection conn, Khachhang khachHang) throws SQLException {
String sql = "UPDATE KhachHang SET ten_khach_hang = ?, dia_chi = ?, dien_thoai = ?, email = ? WHERE ma_khach_hang = ?";

PreparedStatement pstm = conn.prepareStatement(sql);
pstm.setString(1, khachHang.getTen_khach_hang());
pstm.setString(2, khachHang.getDia_chi());
pstm.setString(3, khachHang.getDien_thoai());
pstm.setString(4, khachHang.getEmail());
pstm.setString(5, khachHang.getMa_khach_hang());

pstm.executeUpdate();
}


public static void deleteKhachhang(Connection conn, String ma_khach_hang) throws SQLException {
String sql = "DELETE FROM Khachhang WHERE ma_khach_hang = ?";

PreparedStatement pstm = conn.prepareStatement(sql);
pstm.setString(1, ma_khach_hang);

pstm.executeUpdate();
}

public static List<Khachhang> findKhachhang(Connection conn, String keyword) throws SQLException {
    List<Khachhang> khachHangList = new ArrayList<>();
    String sql = "SELECT ma_khach_hang, ten_khach_hang, dia_chi, dien_thoai, email FROM Khachhang WHERE dien_thoai LIKE ? OR ten_khach_hang LIKE ? OR ma_khach_hang LIKE ?";
    
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setString(1, "%" + keyword + "%");
    pstm.setString(2, "%" + keyword + "%"); // ten_khach_hang
    pstm.setString(3, "%" + keyword + "%"); // ma_khach_hang

    ResultSet rs = pstm.executeQuery();
    
    while (rs.next()) {
    	Khachhang khachHang = new Khachhang();
    	khachHang.setMa_khach_hang(rs.getString("ma_khach_hang"));
    	khachHang.setTen_khach_hang(rs.getString("ten_khach_hang"));
    	khachHang.setDia_chi(rs.getString("dia_chi"));
    	khachHang.setDien_thoai(rs.getString("dien_thoai"));
    	khachHang.setEmail(rs.getString("email"));

    	khachHangList.add(khachHang);
    }
    
    return khachHangList;
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static Donhang findDon(Connection conn, String ma_don_hang, String ma_khach_hang, String ma_san_pham, String ngay_mua_hang) throws SQLException {

String sql = "SELECT a.ma_don_hang,a.ma_khach_hang,a.ma_san_pham,a.ngay_mua_hang FROM Donhang a WHERE a.ma_don_hang = ? AND a.ma_khach_hang = ? AND a.ma_san_pham = ? AND a.ngay_mua_hang = ?";


PreparedStatement pstm = conn.prepareStatement(sql);

pstm.setString(1, ma_don_hang);
pstm.setString(2, ma_khach_hang);
pstm.setString(3, ma_san_pham);
pstm.setString(4, ngay_mua_hang);

ResultSet rs = pstm.executeQuery();


if (rs.next()) {
Donhang user = new Donhang();
user.setMa_don_hang(ma_don_hang);
user.setMa_khach_hang(ma_khach_hang);
user.setMa_san_pham(ma_san_pham);
user.setNgay_mua_hang(ngay_mua_hang);

return user;
}

return null;
}

public static Donhang findDon(Connection conn, String ma_don_hang) throws SQLException { 
String sql = "SELECT a.ma_don_hang,a.ma_khach_hang,a.ma_san_pham,a.ngay_mua_hang FROM Donhang a WHERE a.ma_don_hang = ?";

PreparedStatement pstm = conn.prepareStatement(sql);
pstm.setString(1, ma_don_hang);

ResultSet rs = pstm.executeQuery();


if (rs.next()) {
String ma_khach_hang=rs.getString("Ma_khach_hang");
String ma_san_pham=rs.getString("Ma_san_pham");
String ngay_mua_hang=rs.getString("Ngay_mua_hang");
Donhang user = new Donhang();
user.setMa_don_hang(ma_don_hang);
user.setMa_khach_hang(ma_khach_hang);
user.setMa_san_pham(ma_san_pham);
user.setNgay_mua_hang(ngay_mua_hang);

return user;
}
return null;
}

public static void insertDonhang(Connection conn, Donhang user) throws SQLException {
String sql = "INSERT INTO Donhang(ma_don_hang, ma_khach_hang, ma_san_pham, ngay_mua_hang) VALUES (?,?,?,?)";

PreparedStatement pstm = conn.prepareStatement(sql);
pstm.setString(1, user.getMa_don_hang());
pstm.setString(2, user.getMa_khach_hang());
pstm.setString(3, user.getMa_san_pham());
pstm.setString(4, user.getNgay_mua_hang());
pstm.executeUpdate ();
}

public static void updateDonhang(Connection conn, Donhang donHang) throws SQLException {
    String sql = "UPDATE DonHang SET ma_khach_hang = ?, ma_san_pham = ?, ngay_mua_hang = ?  WHERE ma_don_hang = ?";
    PreparedStatement pstm = conn.prepareStatement(sql);
    
    pstm.setString(1, donHang.getMa_khach_hang());
    pstm.setString(2, donHang.getMa_san_pham());
    pstm.setString(3, donHang.getNgay_mua_hang());
    pstm.setString(4, donHang.getMa_don_hang());
    
    pstm.executeUpdate();
}


public static void deleteDonhang(Connection conn, String ma_don_hang) throws SQLException {
String sql = "DELETE FROM Donhang WHERE ma_don_hang = ?";

PreparedStatement pstm = conn.prepareStatement(sql);
pstm.setString(1, ma_don_hang);

pstm.executeUpdate();
}

public static List<Donhang> findDonhang(Connection conn, String keyword) throws SQLException {
    List<Donhang> donHangList = new ArrayList<>();
    String sql = "SELECT ma_don_hang, ma_khach_hang, ma_san_pham, ngay_mua_hang FROM Donhang WHERE ma_don_hang LIKE ? OR ma_khach_hang LIKE ? OR ma_san_pham LIKE ? OR ngay_mua_hang LIKE ?";
    
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setString(1, "%" + keyword + "%");
    pstm.setString(2, "%" + keyword + "%"); 
    pstm.setString(3, "%" + keyword + "%");
    pstm.setString(4, "%" + keyword + "%");
    ResultSet rs = pstm.executeQuery();
    
    while (rs.next()) {
    	Donhang donHang = new Donhang();
    	donHang.setMa_don_hang(rs.getString("ma_don_hang"));
    	donHang.setMa_khach_hang(rs.getString("ma_khach_hang"));
    	donHang.setMa_san_pham(rs.getString("ma_san_pham"));
    	donHang.setNgay_mua_hang(rs.getString("ngay_mua_hang"));

    	donHangList.add(donHang);
    }
    
    return donHangList;
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static Chitietdonhang findChi(Connection conn, String ma_chi_tiet_don_hang, String ma_don_hang, String ma_san_pham, int so_luong, Double don_gia,
		Double tong_tien) throws SQLException {

String sql = "SELECT a.ma_chi_tiet_don_hang,a.ma_don_hang,a.ma_san_pham,a.so_luong,a.don_gia,a.tong_tien FROM Chitietdonhang a WHERE a.ma_chi_tiet_don_hang = ? AND a.ma_don_hang = ? AND a.ma_san_pham = ? AND a.so_luong = ? AND a.don_gia = ? AND a.tong_tien = ?";

PreparedStatement pstm = conn.prepareStatement(sql);

pstm.setString(1, ma_chi_tiet_don_hang);
pstm.setString(2, ma_don_hang);
pstm.setString(3, ma_san_pham);
pstm.setInt(4, so_luong);
pstm.setDouble(5, don_gia);
pstm.setDouble(6, tong_tien);

ResultSet rs = pstm.executeQuery();


if (rs.next()) {
Chitietdonhang user = new Chitietdonhang();
user.setMa_chi_tiet_don_hang(ma_chi_tiet_don_hang);
user.setMa_don_hang(ma_don_hang);
user.setMa_san_pham(ma_san_pham);
user.setSo_luong(so_luong);
user.setDon_gia(don_gia);
user.setTong_tien(tong_tien);
return user;
}

return null;
}

public static Chitietdonhang findChi(Connection conn, String ma_chi_tiet_don_hang) throws SQLException { 
String sql = "SELECT a.ma_chi_tiet_don_hang,a.ma_don_hang,a.ma_san_pham,a.so_luong,a.don_gia,a.tong_tien FROM Chitietdonhang a WHERE a.ma_chi_tiet_don_hang = ?";


PreparedStatement pstm = conn.prepareStatement(sql);
pstm.setString(1, ma_chi_tiet_don_hang);

ResultSet rs = pstm.executeQuery();


if (rs.next()) {
String ma_don_hang=rs.getString("ma_don_hang");
String ma_san_pham=rs.getString("ma_san_pham");
int so_luong=rs.getInt("so_luong");
double don_gia=rs.getDouble("don_gia");
double tong_tien=rs.getDouble("tong_tien");
Chitietdonhang user = new Chitietdonhang();
user.setMa_chi_tiet_don_hang(ma_chi_tiet_don_hang);
user.setMa_don_hang(ma_don_hang);
user.setMa_san_pham(ma_san_pham);
user.setSo_luong(so_luong);
user.setDon_gia(don_gia);
user.setTong_tien(tong_tien);
return user;
}
return null;
}

public static void insertChitietdonhang(Connection conn, Chitietdonhang user) throws SQLException {
String sql = "INSERT INTO Chitietdonhang(ma_chi_tiet_don_hang, ma_don_hang, ma_san_pham, so_luong, don_gia) VALUES (?,?,?,?,?)";

PreparedStatement pstm = conn.prepareStatement(sql);
pstm.setString(1, user.getMa_chi_tiet_don_hang());
pstm.setString(2, user.getMa_don_hang());
pstm.setString(3, user.getMa_san_pham());
pstm.setInt(4, user.getSo_luong());
pstm.setDouble(5, user.getDon_gia());
//pstm.setDouble(6, user.getTong_tien());
pstm.executeUpdate ();
}

public static void updateChitietdonhang(Connection conn, Chitietdonhang chiTietDonHang) throws SQLException {
String sql = "UPDATE ChiTietDonHang SET ma_don_hang = ?, ma_san_pham = ?, so_luong = ?, don_gia = ?, tong_tien = ? WHERE ma_chi_tiet_don_hang = ?";

PreparedStatement pstm = conn.prepareStatement(sql);
pstm.setString(1, chiTietDonHang.getMa_don_hang());
pstm.setString(2, chiTietDonHang.getMa_san_pham());
pstm.setInt(3, chiTietDonHang.getSo_luong());
pstm.setDouble(4, chiTietDonHang.getDon_gia());
pstm.setDouble(5, chiTietDonHang.getTong_tien());
pstm.setString(6, chiTietDonHang.getMa_chi_tiet_don_hang());

pstm.executeUpdate();
}


public static void deleteChitietdonhang(Connection conn, String ma_chi_tiet_don_hang) throws SQLException {
String sql = "DELETE FROM Chitietdonhang WHERE ma_chi_tiet_don_hang = ?";

PreparedStatement pstm = conn.prepareStatement(sql);
pstm.setString(1, ma_chi_tiet_don_hang);

pstm.executeUpdate();
}

public static List<Chitietdonhang> findChitietdonhang(Connection conn, String keyword) throws SQLException {
List<Chitietdonhang> chiTietDonHangList = new ArrayList<>();
String sql = "SELECT ma_chi_tiet_don_hang, ma_don_hang, ma_san_pham, so_luong, don_gia, tong_tien FROM Chitietdonhang WHERE ma_chi_tiet_don_hang LIKE ? OR ma_don_hang LIKE ? OR ma_san_pham LIKE ?";

PreparedStatement pstm = conn.prepareStatement(sql);
pstm.setString(1, "%" + keyword + "%");
pstm.setString(2, "%" + keyword + "%");
pstm.setString(3, "%" + keyword + "%");
ResultSet rs = pstm.executeQuery();

while (rs.next()) {
Chitietdonhang chiTietDonHang = new Chitietdonhang();
chiTietDonHang.setMa_chi_tiet_don_hang(rs.getString("ma_chi_tiet_don_hang"));
chiTietDonHang.setMa_don_hang(rs.getString("ma_don_hang"));
chiTietDonHang.setMa_san_pham(rs.getString("ma_san_pham"));
chiTietDonHang.setSo_luong(rs.getInt("so_luong"));
chiTietDonHang.setDon_gia(rs.getDouble("don_gia"));
chiTietDonHang.setTong_tien(rs.getDouble("tong_tien"));

chiTietDonHangList.add(chiTietDonHang);
}

return chiTietDonHangList;
}
}