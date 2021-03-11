package com.psl.training.service;

import java.util.ArrayList;
import java.util.List;

import com.psl.training.beans.Contact;

@SuppressWarnings("serial")
class ContactNotFoundException extends Exception{
	public ContactNotFoundException() {
		super();
		this.getMessage();
		this.printStackTrace();
		// TODO Auto-generated constructor stub
	}
}

public class ContactService {
	public void addContact(Contact contact,List<Contact> contacts) {
		if(contacts.contains(contact)) {
			System.out.println("Contact already exist in the list");
		}
		else {
			contacts.add(contact);
			System.out.println("Contact added successfully");
		}
	}
	
	public void removeContact(Contact contact, List<Contact> contacts)throws ContactNotFoundException{
		if(contacts.contains(contact)) {
			contacts.remove(contact);
			System.out.println("Contact removed successfully");
		}
		else {
			throw new ContactNotFoundException();
		}
	}
	
	public Contact searchContactByName(String name, List<Contact> contacts) throws ContactNotFoundException{
		for(Contact c:contacts) {
			if(c.getContactName().equals(name)) {
				System.out.print("Contact found");
				return c;
			}
		}
		throw new ContactNotFoundException();
	}
	
	public List<Contact> SearchContactByNumber(String number, List<Contact> contacts)throws ContactNotFoundException{
		List<String> contactNos = new ArrayList<>();
		List<Contact> foundContacts = new ArrayList<>();
		for(Contact c:contacts) {
			contactNos.addAll(c.getContactNumber());
			for(String no : contactNos) {
				if(no.contains(number))
					foundContacts.add(c);
			}
		}
		if(foundContacts.size() == 0)
			throw new ContactNotFoundException();
		return foundContacts;
	}
	
}
