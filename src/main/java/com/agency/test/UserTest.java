package com.agency.test;
//package com.myyd.test;
//
//import java.util.List;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.myyd.domains.User;
//import com.myyd.services.UserCRUD;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
//public class UserTest
//{
//	@Autowired
//	@Qualifier("userCRUDHibernate")
//	private UserCRUD userCRUD;
//
//	@Before
//	@org.junit.Test
//	public void testUserAdd()
//	{
//		User u = new User();
//		u.setUserName("Kotori");
//		u.setUserID( 1);
//		u.setPassWord("qwe");
//		userCRUD.add(u);
//	}
//	
//	@org.junit.Test
//	public void testgetByID()
//	{
//		User u=new User();
//		u=userCRUD.getByID(1);
//		System.out.println(u.getUserID());
//	}
//	
//	@org.junit.Test
//	public void testgetByName()
//	{
//		User users;
//		users=userCRUD.getByName("Kotori");
//		System.out.println(users.getUserName());
//	}
//	
//	@org.junit.Test
//	public void testgetAll()
//	{
//		List<User> users;
//		users=userCRUD.getAll();
//		System.out.println("getall");
//		for(User ut:users)
//		{
//			System.out.println(ut.getUserName());
//		}
//	}
//	
//	@org.junit.Test
//	public void testedit()
//	{
//		User u=new User();
//		u.setUserName("Allen");
//		u.setPassWord("all");
//		userCRUD.edit(1, u);
//		System.out.println(u.getUserName());
//	}
//	
//	@org.junit.Test
//	public void testdeleteById()
//	{
//		userCRUD.deleteById(4);
//	}
//	
//	@org.junit.Test
//	public void testdeleteByName()
//	{
//		userCRUD.deleteByName("Kotori");
//	}
//	
//	@After
//	@org.junit.Test
//	public void testdeleteAll()
//	{
//		userCRUD.deleteAll();
//	}
//}
