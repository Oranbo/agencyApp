package com.agency.test;

import java.math.BigDecimal;
import java.sql.Date;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.agency.models.AddressBook;
import com.agency.models.BusinessOrder;
import com.agency.services.AddressBookCRUD;
import com.agency.services.BusinessOrderCRUD;
import com.agency.services.HouseInfoCRUD;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

public class BusinessTest {

	@Autowired
	@Qualifier("businessOrderCRUDHibernate")
	private BusinessOrderCRUD businessOrderCRUD;
	
	@Autowired
	@Qualifier("houseInfoCRUDHibernate")
	private HouseInfoCRUD houseInfoCRUD;
	
	@Autowired
	@Qualifier("addressBookCRUDHibernate")
	private AddressBookCRUD addressBookCRUD;
	
//	@Autowired
//	@Qualifier("addressBookCRUDHibernate")
//	private AddressBook addressBook2;
	
	@org.junit.Test
//	public void testAdd(){
//		BusinessOrder businessOrder = new BusinessOrder();
//		businessOrder.setB_id(8);
////		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//		businessOrder.setB_date("2017-04-06");
//		businessOrder.setB_type("出租");
//		businessOrder.setHouseInfo(houseInfoCRUD.getById(8));
//		businessOrder.setReal_price(new BigDecimal(9500));
//		businessOrder.setAddressBook1(addressBookCRUD.getById(222));
//		businessOrder.setAddressBook2(addressBookCRUD.getById(223));
//		businessOrderCRUD.add(businessOrder);
//	}
	public void testGetAll(){
		businessOrderCRUD.getAll();
	}
}
