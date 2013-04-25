package com.taven.web.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class UserModel {
	//@NotNull(message="{username.not.empty}")//需JSR-303验证框架支持
	//@Length(min=5, max=20, message="用户名长度必须在5-20之间")  
	//@Pattern(regexp = "^[a-zA-Z_]\\w{4,19}$", message = "用户名必须以字母下划线开头，可由字母数字下划线组成")  
	private String username;
	
	private String password;
	
	@NumberFormat(style=Style.NUMBER, pattern="#,###")  
    private int totalCount;  
    @NumberFormat(style=Style.PERCENT)  
    private double discount;  
    @NumberFormat(style=Style.CURRENCY)  
    private double sumMoney;  
      
    @DateTimeFormat(iso=ISO.DATE)   
    private Date registerDate;  
      
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")   
    private Date orderDate;

    
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(double sumMoney) {
		this.sumMoney = sumMoney;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}  
    
    
}
