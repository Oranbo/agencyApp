package com.agency.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agency.models.AddressBook;
import com.agency.models.Usr;
import com.agency.services.AddressBookCRUD;
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
public class AddressBookController {
	@Autowired
	@Qualifier("addressBookCRUDHibernate")
	private AddressBookCRUD addressBookCRUD;
	
	@RequestMapping(value="/getPersonByName.json")
	public String getByName(
			@RequestParam("name")String name)throws IOException{
		name =Utl.convert(name);
		System.out.println(name);
		List<AddressBook> people = addressBookCRUD.getByName(name);
		Collections.sort(people);
//		HashMap<String, Object> results = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(people);
		return json;	
	}
	
	@RequestMapping(value="/getPersonByType.json")
	public String getByType(
			@RequestParam("type")String type)throws IOException{
		type =Utl.convert(type);
		System.out.println(type);
		List<AddressBook> people = addressBookCRUD.getByType(type);
		Collections.sort(people);
//		HashMap<String, Object> results = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(people);
		return json;	
	}
	
	@RequestMapping(value="/getPersonByID.json")
	public String getByID(
			@RequestParam("id")String id)throws IOException{
		id =Utl.convert(id);
		System.out.println(id);
		AddressBook people = addressBookCRUD.getById(Integer.parseInt(id));
//		Collections.sort(people);
		System.out.println(people.getName());
//		HashMap<String, Object> results = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(people);
		return json;	
	}
//	@RequestMapping(value="/getPersonByUsr.json")
//	public String getByUsr(
//			@RequestParam("id")String id)throws IOException{
//		ObjectMapper mapper = new ObjectMapper();
//		id =Utl.convert(id);
//		int i = Integer.parseInt(id);
//		AddressBook people = JDBCUtil.getByUsrID(i);
//		String json = mapper.writeValueAsString(people);
//		return json;	
//	}
	@RequestMapping(value="/addPerson.json")
	public String add(@RequestParam("personInfo")String personInfo) throws IOException{
		personInfo = Utl.convert(personInfo);
		ObjectMapper mapper = new ObjectMapper();
		AddressBook addressBook = mapper.readValue(personInfo, AddressBook.class);
		addressBookCRUD.add(addressBook);
		HashMap<String, Object> results = new HashMap<String, Object>();
		results.put("status", 0);
		String json = mapper.writeValueAsString(results);
		return json;
		
	}
	
	@RequestMapping(value="/getAllPeople.json")
	public String getAll() throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		List<AddressBook> addressBooks = addressBookCRUD.getAll();
		String json = mapper.writeValueAsString(addressBooks);
		return json;	
	}
	
	@RequestMapping(value="/deleteAllPeople.json")
	public String deleteAll() throws JsonProcessingException{
		HashMap<String, Object> results = new HashMap<>();
		ObjectMapper mapper = new ObjectMapper();
		addressBookCRUD.deleteAll();
		results.put("status", 0);
		String json = mapper.writeValueAsString(results);
		return json;
	}
	@RequestMapping(value="/deletePeopleById.json")
	public String deleteByID(
			@RequestParam("id")String id) throws JsonProcessingException, UnsupportedEncodingException{
		int i = Integer.parseInt(Utl.convert(id));
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, Object> results = new HashMap<>();
		addressBookCRUD.deleteById(i);
		results.put("status", 0);
		String json = mapper.writeValueAsString(results);
		return json;
	}
	
	@RequestMapping(value="/editPerson.json")
	public String edit(@RequestParam("personInfo") String jsonString) throws IOException{
//		HashMap<String, Object> results = new HashMap<>();	
		ObjectMapper mapper = new ObjectMapper();
		AddressBook addressBook = mapper.readValue(jsonString, AddressBook.class);
		addressBookCRUD.editById(addressBook.getA_id(), addressBook.getName(), addressBook.getSex(), addressBook.getPhone_number(), addressBook.getAddress(), addressBook.getHead_pictures());
		AddressBook addressBook2 = addressBookCRUD.getById(addressBook.getA_id());
		String json = mapper.writeValueAsString(addressBook2);
		return json;	
	}
	
	@RequestMapping(value="/updatePersonInfo.json")
	public String updateInfo(
			@RequestParam("personInfo") String personInfo) throws JsonParseException, JsonMappingException, IOException{
		personInfo = Utl.convert(personInfo);
		System.out.println(personInfo);
		ObjectMapper mapper = new ObjectMapper();
		AddressBook addressBook = mapper.readValue(personInfo, AddressBook.class);
		addressBookCRUD.updatePersonInfo(addressBook);
		HashMap<String, Object> results = new HashMap<String, Object>();
		results.put("status", 0);
		String json = mapper.writeValueAsString(results);
		return json;
	}
	
}
