package com.csr.common.dto;

import java.util.*;

public abstract class Person {

	private String firstName = "";
	private String lastName = "";
	private String middleName = "";

	private Date dateOfBirth; //Date
	private String countryOfBirth;
	private String cityOfBirth;
	private String nickName;
	private String gender;

	private LinkedList names;
	private String salutation;
	protected Hashtable identifiers;

	private String title;
	private String occupation;
	private String department;

	public Person() {
	}

	public Person(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		if (!(null == middleName) || ("".equals(middleName)))
			this.middleName = middleName;
	}

	public void setMiddleName2(String middleName) {
		if (!(null == middleName) || ("".equals(middleName)))
			this.middleName = middleName;
	}

	/**
	 * @return
	 */
	public String getCityOfBirth() {
		return cityOfBirth;
	}

	/**
	 * @return
	 */
	public String getCountryOfBirth() {
		return countryOfBirth;
	}

	/**
	 * @return
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @return
	 */
	public Hashtable getIdentifiers() {
		return identifiers;
	}

	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @return
	 */
	public LinkedList getNames() {
		return names;
	}

	/**
	 * @return
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param string
	 */
	public void setCityOfBirth(String string) {
		cityOfBirth = string;
	}

	/**
	 * @param string
	 */
	public void setCountryOfBirth(String string) {
		countryOfBirth = string;
	}

	/**
	 * @param date
	 */
	public void setDateOfBirth(Date date) {
		dateOfBirth = date;
	}

	/**
	 * @param string
	 */
	public void setFirstName(String string) {
		firstName = string;
	}

	/**
	 * @param string
	 */
	public void setGender(String string) {
		gender = string;
	}

	/**
	 * @param hashtable
	 */
	public void setIdentifiers(Hashtable hashtable) {
		identifiers = hashtable;
	}

	/**
	 * @param string
	 */
	public void setLastName(String string) {
		lastName = string;
	}

	/**
	 * @param string
	 */
	public void setMiddleName(String string) {
		if (!(null == string) || ("".equals(string)))
			middleName = string;
	}

	/**
	 * @param list
	 */
	public void setNames(LinkedList list) {
		names = list;
	}

	/**
	 * @param string
	 */
	public void setNickName(String string) {
		nickName = string;
	}

	public String toString() {
		return lastName + ", " + firstName;
	}
}