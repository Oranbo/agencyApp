package com.agency.test;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.agency.controllers.AddressBookController;
import com.agency.models.AddressBook;
import com.agency.models.Usr;
import com.agency.services.AddressBookCRUD;
import com.agency.services.UsrCRUD;
import com.agency.services.hibernate.UsrCRUDHibernate;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

public class AddressTest {

	@Autowired
	@Qualifier("addressBookCRUDHibernate")
	private AddressBookCRUD addressBookCRUD;
	
	@Autowired
	@Qualifier("usrCRUDHibernate")
	private UsrCRUD uc;
	
//	@org.junit.Test
//	public void testGetByUsr(){
////		Usr user = uc.getById(20170324);
////		System.out.println(user.getLogin_name());
////		AddressBook addressBook = addressBookCRUD.getById(222);
////		System.out.println(1111);
//		AddressBook a = JDBCUtil.getByUsrID(20170324);
//		System.out.println(a.getPhone_number());
//	}
//	@org.junit.Test
//	public void testAd() throws IOException{
//		AddressBookController aa = new AddressBookController();
//		AddressBook addressBook = new AddressBook();
//		addressBook.setA_type("客户");
//		addressBook.setName("啊飞");
//		addressBook.setPhone_number("1334576087");
//		addressBook.setSex("男");
//		addressBook.setAddress("p县");
//		addressBookCRUD.add(addressBook);
////		ObjectMapper mapper = new ObjectMapper();
////		String str = mapper.writeValueAsString(addressBook);
////		aa.add(str);
//	}
//	@org.junit.Test
//	public void testGetAll(){
//		List<AddressBook> addressBooks=addressBookCRUD.getAll();
////		Collections.sort(addressBooks);
//		addressBookCRUD.deleteById(222);
////		for (AddressBook addressBook : addressBooks) {
////			System.out.println(addressBook.getName());
////		}
//	}
}
