package model;

import java.io.Serializable;

public class Bill implements Serializable{

	private Integer id;
	private String gname;
	private Integer num ;
	private double price;
	//0为未付款1为付款
	private Integer paystatus;
	private String pname;
	private String ginfo;
	private String bdate;
	private String username;
	private String trading_unit;
	
	public String getTrading_unit() {
		return trading_unit;
	}
	public void setTrading_unit(String trading_unit) {
		this.trading_unit = trading_unit;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Integer getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(Integer paystatus) {
		this.paystatus = paystatus;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getGinfo() {
		return ginfo;
	}
	public void setGinfo(String ginfo) {
		this.ginfo = ginfo;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	

	
}
