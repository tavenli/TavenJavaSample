package com.taven.app.hibernate.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_USER_OTHERINFO")
public class UserOtherInfoVO extends IdEntity {

	@Column(name = "hobby")
	private String hobby;
	@Column(name = "address")
	private String address;
	@OneToOne
	@JoinColumn(name = "user_id")
	private UserInfoVO userInfo;

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserInfoVO getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfoVO userInfo) {
		this.userInfo = userInfo;
	}

}
