package com.taven.app.hibernate.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ORDER")
public class OrderVO extends IdEntity {

	//方式1
	//@Column(name = "user_id")
	//private String userID;
	//方式2
	@ManyToOne
	//@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public UserInfoVO userInfo;

	@Column(name = "product_name")
	private String productName;
	@Column(name = "price")
	private int price;

	public UserInfoVO getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfoVO userInfo) {
		this.userInfo = userInfo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
