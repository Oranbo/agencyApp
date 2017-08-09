package com.agency.test;

import java.awt.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.agency.models.Usr;
import com.agency.services.UsrCRUD;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class UsrTest {
	@Autowired
	@Qualifier("usrCRUDHibernate")
	private UsrCRUD usrCRUD;
	
//	@Before
//	@org.junit.Test
//	public void testUserAdd(){
//		Usr usr=new Usr();
//		usr.setLogin_name("aoe");
//		usr.setPasswd("221131");
//		usrCRUD.add(usr);		
//	}

	@Before
	@org.junit.Test
	public void testGetByName(){
		Usr usr=usrCRUD.getByName("aoe");
		System.out.println(usr.getId()+usr.getLogin_name());
		
	}
	
//	@Before
//	@org.junit.Test
//	public void testGetAll(){
//		java.util.List<Usr> usr = usrCRUD.getAll();
//		for (Usr usr2 : usr) {
//			System.out.println(usr2.getId()+usr2.getLogin_name());
//		}
//		
//	}
	
//	@Before
//	@org.junit.Test
//	public void testGetByID(){
//		Usr usr =usrCRUD.getById(20170323);
//		System.out.println(usr.getId()+usr.getLogin_name());
//		
//	}
}
