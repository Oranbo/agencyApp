package com.agency.services.hibernate;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.agency.models.AddressBook;
import com.agency.models.Usr;
import com.agency.services.AddressBookCRUD;
/**
 * 
 * @author BlackOrange
 *
 */
@Service("addressBookCRUDHibernate")
public class AddressBookCRUDHibernate implements AddressBookCRUD {

	private HibernateTemplate ht;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		ht = new HibernateTemplate(sessionFactory);
	
	}
	@Override
	@Transactional
	public void add(AddressBook addressBook) {
		// TODO 自动生成的方法存根

		ht.save(addressBook);
	}

	@Override
	@Transactional
	public AddressBook getById(int id) {
		// TODO 自动生成的方法存根
		return ht.get(AddressBook.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<AddressBook> getAll() {
		// TODO 自动生成的方法存根
		List<AddressBook> addressBooks=(List<AddressBook>) ht.find("from AddressBook");
		Collections.sort(addressBooks);
		return addressBooks;
	}


	@Override
	@Transactional
	public void deleteById(int id) {
		// TODO 自动生成的方法存根
		AddressBook addressBook = this.getById(id);
		ht.delete(addressBook);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void deleteAll() {
		// TODO 自动生成的方法存根
		List<AddressBook> addressBooks=(List<AddressBook>) ht.find("from AddressBook");
		for(AddressBook addressBook:addressBooks){
			ht.delete(addressBook);
		}
	}
	@Override
	@Transactional
	public void editById(int id, String name, String sex, String phoneNumber, String address, byte[] head_picture) {
		// TODO 自动生成的方法存根
		AddressBook addressBook = this.getById(id);
		addressBook.setName(name);
		addressBook.setSex(sex);
		addressBook.setPhone_number(phoneNumber);
		addressBook.setAddress(address);
		addressBook.setHead_pictures(head_picture);
			
	}
	@Override
	@Transactional
	public List<AddressBook> getByName(String name) {
		// TODO 自动生成的方法存根
		@SuppressWarnings("unchecked")
		List<AddressBook> addressBooks=(List<AddressBook>) ht.find("from AddressBook where name=?",name);	
		return addressBooks;
	}
	@Override
	@Transactional
	public void updatePersonInfo(AddressBook addressBook) {
		// TODO Auto-generated method stub
		ht.update(addressBook);
	}
	@Override
	@Transactional
	public List<AddressBook> getByType(String type) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<AddressBook> addressBooks=(List<AddressBook>) ht.find("from AddressBook where a_type=?",type);	
		return addressBooks;
	}


}
