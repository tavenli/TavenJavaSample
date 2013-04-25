package com.taven.app.hibernate.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Friend")
public class FriendVO extends IdEntity {

	@Column(name = "friend_name")
	private String friendName;
	@Column(name = "remark")
	private String remark;

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
