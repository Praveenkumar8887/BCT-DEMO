package com.itss.bdctdemo.entitybeans;



public class CustomerBean {
	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public String getAccountNonExpired() {
		return accountNonExpired;
	}
	public void setAccountNonExpired(String accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public String getCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public void setCredentialsNonExpired(String credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	public String getAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(String accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	private String customerID;
	private String password;
	private String firstName;
	private String lastName;
	private String gender;
	private String enabled;
	private String accountNonExpired;
	private String credentialsNonExpired;
	private String accountNonLocked;

}
