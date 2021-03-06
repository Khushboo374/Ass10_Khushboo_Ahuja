package com.psl.training.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.psl.training.beans.Contact;
import com.psl.training.dao.ContactsDao;

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
				System.out.println("Contact found");
				return c;
			}
		}
		throw new ContactNotFoundException();
	}
	
	public List<Contact> SearchContactByNumber(String number, List<Contact> contacts) throws ContactNotFoundException{
		List<String> contactNos = new ArrayList<>();
		List<Contact> foundContacts = new ArrayList<>();
		for(Contact c:contacts) {
			if(c.getContactNumber() != null) {
			contactNos.addAll(c.getContactNumber());
			for(String no : contactNos) {
				if(no.contains(number)) {
					foundContacts.add(c);
					break;
			}}
		}}
		if(foundContacts.size() == 0)
			throw new ContactNotFoundException();
		return foundContacts;
	}
	
	public void addContactNumber(int contactId, String contactNo, List<Contact> contacts) throws ContactNotFoundException {
		for(Contact c : contacts) {
			if(c.getContactId() == contactId) {
				if(c.getContactNumber() != null) {
				c.getContactNumber().add(contactNo);
				System.out.println("Number added successfully");
				return;
				}
				else {
					List<String> num = new ArrayList<>();
					num.add(contactNo);
					c.setContactNumber(num);
					return;
				}
			}
		}
		throw new ContactNotFoundException();
	}
	
	public void sortContactsByName(List<Contact> contacts) {
		Collections.sort(contacts);
	}
	
	public void readContactsFromFile(List<Contact> contacts, String fileName) {
		File file = new File(fileName);
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNext()) {
				String data[] = sc.nextLine().split(",");
				Contact contact = new Contact();
				if(data.length == 3) {
					contact.setContactId(Integer.parseInt(data[0]));
					contact.setContactName(data[1]);
					contact.setAddress(data[2]);
				}
				else if(data.length==4) {
					contact.setContactId(Integer.parseInt(data[0]));
					contact.setContactName(data[1]);
					contact.setAddress(data[2]);
					contact.setContactNumber(List.of(data[3].split(",")));
				}
				contacts.add(contact);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void serializeContactDetails(List<Contact> contacts , String fileName) {
		File file = new File(fileName);
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(contacts);
			
			fos.close();
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Contact> deserializeContact(String fileName){
		List<Contact> contacts = new ArrayList<>();
		File file = new File(fileName);
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			contacts = (List<Contact>) ois.readObject();
			
			fis.close();
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contacts;
	}
	
	
	public Set<Contact> populateContactFromDb(){
		return ContactsDao.populateContactFromDb();
	}
	
	public Boolean addContacts(List <Contact> existingContact,Set <Contact> newContacts) {
		if(newContacts.size() == 0) {
			System.out.println("No new contacts to add.");
			return false;
		}
		existingContact.addAll(newContacts);
		System.out.println("New contacts added successfully.");
		return true;
	}
}
