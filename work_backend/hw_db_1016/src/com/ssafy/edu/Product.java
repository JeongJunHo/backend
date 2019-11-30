package com.ssafy.edu;

import java.util.Date;

public class Product {
	private String code;
	private String name;
	private int price;
	private int stock;
	private String memo;
	private String reg_mb_id;
	private Date reg_date;
	private String up_mb_id;
	private Date up_date;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(String code, String name, int price, int stock, String memo, String reg_mb_id, Date reg_date, String up_mb_id,
			Date up_date) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.memo = memo;
		this.reg_mb_id = reg_mb_id;
		this.reg_date = reg_date;
		this.up_mb_id = up_mb_id;
		this.up_date = up_date;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getReg_mb_id() {
		return reg_mb_id;
	}
	public void setReg_mb_id(String reg_mb_id) {
		this.reg_mb_id = reg_mb_id;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getUp_mb_id() {
		return up_mb_id;
	}
	public void setUp_mb_id(String up_mb_id) {
		this.up_mb_id = up_mb_id;
	}
	public Date getUp_date() {
		return up_date;
	}
	public void setUp_date(Date up_date) {
		this.up_date = up_date;
	}
	@Override
	public String toString() {
		return "ProductVO [code=" + code + ", name=" + name + ", price=" + price + ", stock=" + stock + ", reg_mb_id="
				+ reg_mb_id + ", reg_date=" + reg_date + ", up_mb_id=" + up_mb_id + ", up_date=" + up_date + "]";
	}
}
