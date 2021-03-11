package com.psl.training.beans;

import java.util.List;

public class Contact implements Comparable<Contact>{
	private int contactId;
	private String ContactName;
	private String Address;
	private List<String> contactNumber;
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(int contactId, String contactName, String address, List<String> contactNumber) {
		super();
		this.contactId = contactId;
		ContactName = contactName;
		Address = address;
		this.contactNumber = contactNumber;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return ContactName;
	}
	public void setContactName(String contactName) {
		ContactName = contactName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public List<String> getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(List<String> contactNumber) {
		this.contactNumber = contactNumber;
	}
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", ContactName=" + ContactName + ", Address=" + Address
				+ ", contactNumber=" + contactNumber + "]";
	}
	@Override
	public int compareTo(Contact o) {
		// TODO Auto-generated method stub
		return this.getContactName().compareTo(o.getContactName());
	}
}
