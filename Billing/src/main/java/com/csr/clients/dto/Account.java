package com.csr.clients.dto;

import java.util.*;
import java.math.*;

public class Account
{
	private String accountID;
	private String accountName;
	private String status; //open, closed, suspended
	private BigDecimal accountBalance;
	private List effectiveDates;
	private Client client;

	public Account() {
	}
}