package com.csr.common.dto;

import java.util.*;

public class User extends Employee
{
	private String userName;
	private String password; // md5 hash
	private Date lastLogin;
	private List roles;
	private String status; // inactive, active, lockedOut

	public User()
	{
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return
	 */
	public List getRoles() {
		return roles;
	}

	/**
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param string
	 */
	public void setPassword(String string) {
		password = string;
	}

	/**
	 * @param list
	 */
	public void setRoles(List list) {
		roles = list;
	}

	/**
	 * @param string
	 */
	public void setUserName(String string) {
		userName = string;
	}

	public Date getLastLogin()
	{
		return lastLogin;
	}

	public void setLastLogin(Date date)
	{
		lastLogin = date;
	}

	public String toString()
	{
		return userName;
	}
}