package com.agency.test;

import java.math.BigDecimal;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.agency.models.AddressBook;
import com.agency.models.HouseInfo;
import com.agency.services.AddressBookCRUD;
import com.agency.services.HouseInfoCRUD;
import com.agency.services.hibernate.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class HouseTest {

	@Autowired
	@Qualifier("addressBookCRUDHibernate")
	private AddressBookCRUD addressBookCRUD;
	@Autowired
	@Qualifier("houseInfoCRUDHibernate")
	private HouseInfoCRUD houseInfoCRUD;
	
	
//	@org.junit.Test
//	public void testAdd() throws MyException {
//		// TODO Auto-generated method stub
//		HouseInfo houseInfo = new HouseInfo();
//		houseInfo.setH_id(880);
//		AddressBook addressBook = addressBookCRUD.getById(226);
//		houseInfo.setAddressBook(addressBook);
//		houseInfo.setH_type("出售");
//		houseInfo.setSize(new BigDecimal(120));
//		houseInfo.setLayout("三室一厅");
//		houseInfo.setHouse_status("待售");
//		houseInfo.setS_price(new BigDecimal(2200000));
//		houseInfo.setR_price(new BigDecimal(0));
//		houseInfo.setAddress("重庆大学");
//		houseInfoCRUD.add(houseInfo);
//	}
//	@org.junit.Test
//	public void testAAdd(){
//		AddressBook addressBook = new AddressBook();
//		addressBook.setA_type("客户");
//		addressBook.setName("李四");
//		addressBook.setSex("男");
//		addressBook.setPhone_number("1587426358");
//		addressBookCRUD.add(addressBook);
//	}
	
//	@org.junit.Test
//	public void testGet(){
//		List<AddressBook> addressBook =addressBookCRUD.getByName("付帅");
//		for (AddressBook addressBook2 : addressBook) {
//			System.out.println(addressBook2.getName());
//		}
//	}
//	
	@org.junit.Test
	public void testChange() throws MyException{
		System.out.println(houseInfoCRUD.getAll().size());
	}
	
//	@org.junit.Test
//	public void testGetByAddress(){
//		boolean result = false;
//		if(houseInfoCRUD.getByAddress("红旗")!=null){
//			result=true;
//		}
//		
//		System.out.println(result);	
//	}
	
//	@org.junit.Test
//	public void testGetByRP(){
//		List<HouseInfo> houseInfos = houseInfoCRUD.getByRentprice(new BigDecimal(9990.00));
//		for (HouseInfo houseInfo : houseInfos) {
//			
//			System.out.println(houseInfo.getR_price().floatValue());
//		}
//	}
	
//	@org.junit.Test
//	public void testGetBySP(){
//		List<HouseInfo> houseInfos = houseInfoCRUD.getBySealprice(new BigDecimal(1730000));
//		for (HouseInfo houseInfo : houseInfos) {
//			System.out.println(houseInfo.getS_price().floatValue());
//			
//		}
//	}
	
//	public void testGetBySize(){
//		List<HouseInfo> houseInfos = houseInfoCRUD.getBySize(new BigDecimal(88));
//		for (HouseInfo houseInfo : houseInfos) {
//			
//			System.out.println(houseInfo.getSize().floatValue());
//		}
//	}
	
}
