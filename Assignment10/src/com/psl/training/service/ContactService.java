package com.psl.training.service;

import java.util.List;

import com.psl.training.beans.Contact;

public class ContactService {
	void addContact(Contact contact,List<Contact> contacts) {
		if(contacts.contains(contact)) {
			System.out.println("Contact already exist in the list");
		}
		else {
			contacts.add(contact);
		}
	}
}
