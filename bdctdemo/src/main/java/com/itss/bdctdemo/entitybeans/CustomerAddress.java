package com.itss.bdctdemo.entitybeans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_ADDRESS")
public class CustomerAddress implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6991979183569412032L;

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Id
	@Column(name = "CUSTOMER_ID")
	private String customerID;

	@Column(name = "STREET")
	private String street;

	@Column(name = "HOUSENO")
	private String houseNo;

	@Column(name = "CITY")
	private String city;

	@Column(name = "PINCODE")
	private String pinCode;

	@Column(name = "COUNTRY")
	private String country;

}