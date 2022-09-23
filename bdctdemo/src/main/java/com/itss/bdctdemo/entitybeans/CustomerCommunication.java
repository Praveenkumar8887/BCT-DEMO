package com.itss.bdctdemo.entitybeans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_COMMUNICATION" )
public class CustomerCommunication implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5397655102271624115L;

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Id
	@Column(name = "CUSTOMER_ID")
	private String customerID;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "COUNTRY_CODE")
	private String countryCode;

	@Column(name = "PHONE_NO")
	private String phoneNo;

}
