package com.agency.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agency.models.BusinessOrder;
import com.agency.models.HouseInfo;
import com.agency.services.BusinessOrderCRUD;
import com.agency.services.HouseInfoCRUD;
import com.agency.services.hibernate.MyException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 
 * @author BlackOrange
 *
 */
@RestController
public class BusinessOrderController {
	@Autowired
	@Qualifier("businessOrderCRUDHibernate")
	private BusinessOrderCRUD businessOrderCRUD;
	
	@Autowired
	@Qualifier("houseInfoCRUDHibernate")
	private HouseInfoCRUD hic;
	
	@RequestMapping(value="/addOrder.json")
	public String addOrder(
			@RequestParam("order") String order) throws JsonParseException, JsonMappingException, IOException{
		order = Utl.convert(order);
		HashMap<String, Object> results = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		BusinessOrder businessOrder = mapper.readValue(order, BusinessOrder.class);

		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Date now=new Date();
		businessOrder.setB_date(date.format(now));
		businessOrderCRUD.add(businessOrder);
		results.put("status", 0);
		String json = mapper.writeValueAsString(results);
		return json;		
	}
	@RequestMapping(value="/getOrdersByEid.json")
	public String getByEid(
			@RequestParam("employee_id")int employee_id) throws JsonProcessingException{
		System.out.println(employee_id);
		List<BusinessOrder> businessOrders = businessOrderCRUD.getByEmployeeId(employee_id);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(businessOrders);
		return json;		
	}
	
	@RequestMapping(value="/getAllOrders.json")
	public String getAll() throws JsonProcessingException{
		List<BusinessOrder> businessOrders = businessOrderCRUD.getAll();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(businessOrders);
		return json;
		
	}
	
	@RequestMapping(value="/deleteOrdersByid.json")
	public HashMap<String, Object> deleteByid(
			@RequestParam("id") int id){
		businessOrderCRUD.deleteById(id);
		HashMap<String, Object> result = new HashMap<>();
		result.put("status", 0);
		return result;
		
	}
	
	@RequestMapping(value="/deleteAllOrders.json")
	public HashMap<String, Object> deleteAll(){
		businessOrderCRUD.deleteAll();
		HashMap<String, Object> result = new HashMap<>();
		result.put("status", 0);
		return result;
		
	}
}
