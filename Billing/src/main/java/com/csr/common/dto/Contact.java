package com.csr.common.dto;

import java.util.*;
import java.net.*;

public class Contact extends Person {

	private String status;
	private String spouseName;
	private String bestContactTime;
	private List contactDetails;

//	private Address			defaultAddress;
//	private EmailAddress	defaultEmailAddress;
//	private PhoneNumber		defaultPhoneNumber;
	private URL				defaultURL;

	public Contact() {
	}

	class ContactDetail {

//		private Address address; //type: billing, shipping, recipient, home
//		private EmailAddress emailAddress; //type: work, home
//		private PhoneNumber phoneNumber; //type: cell, home, office, fax
		private URL url;
		private Map identifiers;

		public ContactDetail() {
		}
	}
}