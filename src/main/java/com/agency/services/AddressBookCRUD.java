package com.agency.services;

import java.util.List;

import com.agency.models.AddressBook;
import com.agency.models.Usr;

public interface AddressBookCRUD {

	public void add(AddressBook addressBook);
	public AddressBook getById(int id);
	public List<AddressBook> getByName(String name);
	public List<AddressBook> getByType(String type);
	public List<AddressBook> getAll();
	public void editById(int id,String name,String sex,String phoneNumber,String address,byte[] head_picture);
	public void updatePersonInfo(AddressBook addressBook); 
	public void deleteById(int id);
	public void deleteAll();
}
