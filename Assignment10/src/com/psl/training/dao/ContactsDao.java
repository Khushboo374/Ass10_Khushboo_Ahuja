package com.psl.training.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.psl.training.beans.Contact;
import com.psl.training.util.DBConnectionUtil;

public class ContactsDao {
	
	static Connection con = DBConnectionUtil.getConnection();
	
	public static Set<Contact>populateContactFromDb(){
		Contact contact = null;
		Set <Contact> contacts = new LinkedHashSet<>();
		try {
			Statement stmt = con.createStatement();
			ResultSet results = stmt.executeQuery("select * from contact_tbl");
			while(results.next()) {
				contact = new Contact(results.getInt(1),results.getString(2),results.getString(3),List.of(results.getString(4).split(",")));
				contacts.add(contact);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contacts;
	}
}
