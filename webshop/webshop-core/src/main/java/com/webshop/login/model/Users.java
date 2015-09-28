package com.webshop.login.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user_login")

public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer loginid;

	@Column(name="username")
	private String username;
	@Column(name="timestamp")
	private Timestamp timestamp;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the timestamp
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the loginid
	 */
	public Integer getLoginid() {
		return loginid;
	}
	/**
	 * @param loginid the loginid to set
	 */
	public void setLoginid(Integer loginid) {
		this.loginid = loginid;
	}

}
