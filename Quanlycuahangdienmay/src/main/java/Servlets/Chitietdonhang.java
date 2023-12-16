package Servlets;

public class Chitietdonhang {
	
	private String ma_chi_tiet_don_hang;
	private String ma_don_hang;
	private String ma_san_pham;
	private int so_luong;
	private Double don_gia;
	private Double tong_tien;
	
	public Chitietdonhang(String ma_chi_tiet_don_hang, String ma_don_hang, String ma_san_pham, int so_luong,
			Double don_gia, Double tong_tien) {
		this.ma_chi_tiet_don_hang = ma_chi_tiet_don_hang;
		this.ma_don_hang = ma_don_hang;
		this.ma_san_pham = ma_san_pham;
		this.so_luong = so_luong;
		this.don_gia = don_gia;
		this.tong_tien = tong_tien;
	}
	
	public Chitietdonhang(String ma_chi_tiet_don_hang, String ma_don_hang, String ma_san_pham, int so_luong,
			Double don_gia) {
		this.ma_chi_tiet_don_hang = ma_chi_tiet_don_hang;
		this.ma_don_hang = ma_don_hang;
		this.ma_san_pham = ma_san_pham;
		this.so_luong = so_luong;
		this.don_gia = don_gia;
	}
	
	public Chitietdonhang() {}
	
	public Chitietdonhang(Chitietdonhang us) {
		this.ma_chi_tiet_don_hang = us.ma_chi_tiet_don_hang;
		this.ma_don_hang = us.ma_don_hang;
		this.ma_san_pham = us.ma_san_pham;
		this.so_luong = us.so_luong;
		this.don_gia = us.don_gia;
		this.tong_tien = us.tong_tien;
	}

	public String getMa_chi_tiet_don_hang() {
		return ma_chi_tiet_don_hang;
	}

	public void setMa_chi_tiet_don_hang(String ma_chi_tiet_don_hang) {
		this.ma_chi_tiet_don_hang = ma_chi_tiet_don_hang;
	}

	public String getMa_don_hang() {
		return ma_don_hang;
	}

	public void setMa_don_hang(String ma_don_hang) {
		this.ma_don_hang = ma_don_hang;
	}

	public String getMa_san_pham() {
		return ma_san_pham;
	}

	public void setMa_san_pham(String ma_san_pham) {
		this.ma_san_pham = ma_san_pham;
	}

	public int getSo_luong() {
		return so_luong;
	}

	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}

	public Double getDon_gia() {
		return don_gia;
	}

	public void setDon_gia(Double don_gia) {
		this.don_gia = don_gia;
	}

	public Double getTong_tien() {
		return tong_tien;
	}

	public void setTong_tien(Double tong_tien) {
		this.tong_tien = tong_tien;
	}
}
