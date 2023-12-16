package Servlets;

public class Khachhang {
	
	private String ma_khach_hang;
	private String ten_khach_hang;
	private String dia_chi;
	private String dien_thoai;
	private String email;
	
	public Khachhang(String ma_khach_hang, String ten_khach_hang, String dia_chi, String dien_thoai, String email) {
		this.ma_khach_hang = ma_khach_hang;
		this.ten_khach_hang = ten_khach_hang;
		this.dia_chi = dia_chi;
		this.dien_thoai = dien_thoai;
		this.email = email;
	}
	
	public Khachhang() {}
	
	public Khachhang(Khachhang us) {
		this.ma_khach_hang = us.ma_khach_hang;
		this.ten_khach_hang = us.ten_khach_hang;
		this.dia_chi = us.dia_chi;
		this.dien_thoai = us.dien_thoai;
		this.email = us.email;
	}

	public String getMa_khach_hang() {
		return ma_khach_hang;
	}

	public void setMa_khach_hang(String ma_khach_hang) {
		this.ma_khach_hang = ma_khach_hang;
	}

	public String getTen_khach_hang() {
		return ten_khach_hang;
	}

	public void setTen_khach_hang(String ten_khach_hang) {
		this.ten_khach_hang = ten_khach_hang;
	}

	public String getDia_chi() {
		return dia_chi;
	}

	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}

	public String getDien_thoai() {
		return dien_thoai;
	}

	public void setDien_thoai(String dien_thoai) {
		this.dien_thoai = dien_thoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
