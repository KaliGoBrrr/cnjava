package Servlets;

import java.sql.Date;

public class Donhang {

	private String ma_don_hang;
	private String ma_khach_hang;
	private String ma_san_pham;
	private String ngay_mua_hang;
	
	public Donhang(String ma_don_hang, String ma_khach_hang, String ma_san_pham, String ngay_mua_hang) {
		this.ma_don_hang = ma_don_hang;
		this.ma_khach_hang = ma_khach_hang;
		this.ma_san_pham = ma_san_pham;
		this.ngay_mua_hang = ngay_mua_hang;

	}
	
	public Donhang(String ma_don_hang, String ngay_mua_hang) {
		this.ma_don_hang = ma_don_hang;
		this.ngay_mua_hang = ngay_mua_hang;

	}
	
	public Donhang() {}
	
	public Donhang(Donhang us) {
		this.ma_don_hang = us.ma_don_hang;
		this.ma_khach_hang = us.ma_khach_hang;
		this.ma_san_pham = us.ma_san_pham;
		this.ngay_mua_hang = us.ngay_mua_hang;

	}

	public String getMa_don_hang() {
		return ma_don_hang;
	}

	public void setMa_don_hang(String ma_don_hang) {
		this.ma_don_hang = ma_don_hang;
	}

	public String getMa_khach_hang() {
		return ma_khach_hang;
	}

	public void setMa_khach_hang(String ma_khach_hang) {
		this.ma_khach_hang = ma_khach_hang;
	}

	public String getMa_san_pham() {
		return ma_san_pham;
	}

	public void setMa_san_pham(String ma_san_pham) {
		this.ma_san_pham = ma_san_pham;
	}

	public String getNgay_mua_hang() {
		return ngay_mua_hang;
	}

	public void setNgay_mua_hang(String ngay_mua_hang) {
		this.ngay_mua_hang = ngay_mua_hang;
	}

}
