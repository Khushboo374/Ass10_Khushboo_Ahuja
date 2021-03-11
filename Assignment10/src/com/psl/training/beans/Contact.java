package com.psl.training.beans;

import java.io.Serializable;
import java.util.List;

public class Contact implements Serializable,Comparable<Contact>{
	private int contactId;
	private String ContactName;
	private String emailAddress;
	private List<String> contactNumber;
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(int contactId, String contactName, String address, List<String> contactNumber) {
		super();
		this.contactId = contactId;
		ContactName = contactName;
		emailAddress = address;
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
		return emailAddress;
	}
	public void setAddress(String address) {
		emailAddress = address;
	}
	public List<String> getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(List<String> contactNumber) {
		this.contactNumber = contactNumber;
	}
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", ContactName=" + ContactName + ", Address=" + emailAddress
				+ ", contactNumber=" + contactNumber + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ContactName == null) ? 0 : ContactName.hashCode());
		result = prime * result + contactId;
		result = prime * result + ((contactNumber == null) ? 0 : contactNumber.hashCode());
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (ContactName == null) {
			if (other.ContactName != null)
				return false;
		} else if (!ContactName.equals(other.ContactName))
			return false;
		if (contactId != other.contactId)
			return false;
		if (contactNumber == null) {
			if (other.contactNumber != null)
				return false;
		} else if (!contactNumber.equals(other.contactNumber))
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		return true;
	}
	@Override
	public int compareTo(Contact o) {
		// TODO Auto-generated method stub
		return this.getContactName().compareTo(o.getContactName());
	}
}
