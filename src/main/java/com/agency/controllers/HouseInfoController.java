package com.agency.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agency.models.HouseInfo;
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
public class HouseInfoController {
	@Autowired
	@Qualifier("houseInfoCRUDHibernate")
	private HouseInfoCRUD hic;
	
	@RequestMapping(value="/addHouse.json")
	public String addHouse(		
			@RequestParam("houseInfo")String houseInfo)throws IOException, MyException{
		HashMap<String, Object> results = new HashMap<String, Object>();
		houseInfo = Utl.convert(houseInfo);
		System.out.println("=========="+houseInfo);
		ObjectMapper mapper = new ObjectMapper();
		HouseInfo hInfo = mapper.readValue(houseInfo, HouseInfo.class);
		hic.add(hInfo);
		results.put("status", 0);
		String str = mapper.writeValueAsString(results);
		return str;
		
	}

	@RequestMapping(value="/changeHouseStatus.json")
	public HashMap<String, Object> changeStatus(
			@RequestParam("h-id") String h_id,
			@RequestParam("house_status") String house_status) throws IOException{
		HashMap<String, Object> results = new HashMap<String, Object>();		
		HouseInfo houseInfo = hic.getById(Integer.parseInt(h_id));
		houseInfo.setHouse_status(house_status);
		results.put("status", 0);
		return results;
		
	}
	
	@RequestMapping(value="/updateHouseInfo.json")
	public String updateInfo(
			@RequestParam("houseInfo") String houseInfo) throws JsonParseException, JsonMappingException, IOException, MyException{
		houseInfo = Utl.convert(houseInfo);
		ObjectMapper mapper = new ObjectMapper();
		HouseInfo houseInfo2 = mapper.readValue(houseInfo, HouseInfo.class);
		hic.updateHouseInfo(houseInfo2);
		return mapper.writeValueAsString(houseInfo2);
		
	}
	
	@RequestMapping(value="/getAllHouses.json")
	public String getAll() throws IOException{
		List<HouseInfo> houses= hic.getAll();
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(houses);
		return jsonResult;	
	}
	
	@RequestMapping(value="/getByAddress.json")
	public String getByAddress(
			@RequestParam("address") String address) throws IOException{
		address = Utl.convert(address);
		List<HouseInfo> houses= hic.getByAddress(address);
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(houses);
		return jsonResult;	
		
	}
	
	@RequestMapping(value="/getByRentprice.json")
	public String getByRprice(
			@RequestParam("r_price") String r_price) throws IOException{
		BigDecimal price = new BigDecimal(r_price);
		List<HouseInfo> houses= hic.getByRentprice(price);
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(houses);
		return jsonResult;	
		
	}
	
	@RequestMapping(value="/getBySealprice.json")
	public String getBySprice(
			@RequestParam("s_price") String s_price) throws IOException{
		BigDecimal price = new BigDecimal(s_price);
		List<HouseInfo> houses= hic.getBySealprice(price);
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(houses);
		return jsonResult;	
		
	}
	
	@RequestMapping(value="/getByLayout.json")
	public String getByLayout(
			@RequestParam("layout") String layout) throws IOException{	
		layout = Utl.convert(layout);
		List<HouseInfo> houses= hic.getByLayout(layout);
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(houses);
		return jsonResult;	
		
	}
	@RequestMapping(value="/deleteByID.json")
	public String deleteById(
			@RequestParam("id") String id) throws IOException{	
		int i= Integer.parseInt(Utl.convert(id));
		hic.deleteById(i);
		HashMap<String, Integer> result = new HashMap<>();
		result.put("status", 0);
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);
		return jsonResult;	
		
	}
	@RequestMapping(value="/changeInfo.json")
	public String changeSellStatus(
			@RequestParam("houseInfo") String house_info) throws JsonParseException, JsonMappingException, IOException, MyException{
		house_info = Utl.convert(house_info);
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, Object> results = new HashMap<String,Object>();
		HouseInfo houseInfo = mapper.readValue(house_info, HouseInfo.class);
		hic.updateHouseInfo(houseInfo);
		results.put("status", 0);
		return mapper.writeValueAsString(results);
		
	}
	
	@RequestMapping(value="/getHousesBySellStatus.json")
	public String getBySellStatus(
			@RequestParam("sell_status") String sell_status) throws JsonProcessingException, DataAccessException, MyException, UnsupportedEncodingException{
		sell_status = Utl.convert(sell_status);
		System.out.println(sell_status);
		String jsonString = null;
		ObjectMapper mapper = new ObjectMapper();
		List<HouseInfo> houseInfos = hic.getBySellStatus(sell_status);
		jsonString = mapper.writeValueAsString(houseInfos);
		
		return jsonString;
	}
	
	@RequestMapping(value="/getByDecoration.json")
	public String getByDecoration(
			@RequestParam("decoration")String decoration) throws MyException, JsonProcessingException, UnsupportedEncodingException{
		decoration = Utl.convert(decoration);
		List<HouseInfo> houseInfos = hic.getByDecoration(decoration);	
		ObjectMapper mapper = new ObjectMapper();
		String jsonString  = mapper.writeValueAsString(houseInfos);
		return jsonString;
		
	}
	
	@RequestMapping(value="/getByFloor.json")
	public String getByFloor(
			@RequestParam("floor") int floor) throws JsonProcessingException{
		List<HouseInfo> houseInfos = hic.getByFloor(floor);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString  = mapper.writeValueAsString(houseInfos);
		return jsonString;
	}
}
