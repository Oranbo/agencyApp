package com.agency.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agency.models.Usr;
import com.agency.services.UsrCRUD;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 
 * @author BlackOrange
 *
 */
@RestController
public class UsrController {
	@Autowired
	@Qualifier("usrCRUDHibernate")
	private UsrCRUD usrCRUD;
	
	@RequestMapping(value="/regeister.json") 
	public HashMap<String, Object> addUser(
			@RequestParam("userName") String userName,
			@RequestParam("passWord") String passWord) throws IOException
	{
		HashMap<String, Object> results = new HashMap<String, Object>();
		if(usrCRUD.getByName(userName) != null)
		{
			results.put("status", 1);
			return results;
		}

//		String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";//������ʽ
//		Pattern p = Pattern.compile(str);
//		Matcher m = p.matcher(userName);
//		if (!m.find())
//		{
//			results.put("status", 2);
//			return results;
//		}
	
		Usr usr = new Usr();
		usr.setPasswd(passWord);
		usr.setLogin_name(userName);
		usrCRUD.add(usr);
		results.put("status", 0);
		
		return results;
	}
	
	@RequestMapping(value="/login.json") 
	public String login(
			@RequestParam("userName") String userName,
			@RequestParam("passWord") String passWord) throws IOException
	{
		HashMap<String, Object> results = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = "";
		if (usrCRUD.getByName(userName) ==null)
		{
			results.put("status", 1);
			jsonResult = mapper.writeValueAsString(results);
			return jsonResult;
		}
		if (!usrCRUD.getByName(userName).getPasswd().equals(passWord))
		{
			results.put("status", 2);
			jsonResult = mapper.writeValueAsString(results);
			return jsonResult;
		}
		
		results.put("status", 0);
		jsonResult = mapper.writeValueAsString(results);
		return jsonResult;
	}
	@RequestMapping(value="/getByLogName.json")
	public String getByName(@RequestParam("name")String name) throws JsonProcessingException, UnsupportedEncodingException{
		name=Utl.convert(name);
		Usr user = usrCRUD.getByName(name);
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = "";
		jsonResult = mapper.writeValueAsString(user);
		return jsonResult;
		
	}
	
	@RequestMapping(value="/getBackPassword.json")
	public String getPassword(@RequestParam("loginName")String loginName,
			@RequestParam("phone_number")String phone_number,
			@RequestParam("realName")String realName) throws JsonProcessingException, UnsupportedEncodingException{
		realName=Utl.convert(realName);
		Usr user = usrCRUD.getByName(loginName);
		String info = null;
		HashMap<String, Object> result = new HashMap<>();
		if (user.getAddressBook().getName().equals(realName)&&
			user.getAddressBook().getPhone_number().equals(phone_number)) {
			info = Utl.getResult(phone_number, user.getPasswd());
			result.put("status", 0);
		}else {
			result.put("status", 1);
		}
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = "";
		jsonResult = mapper.writeValueAsString(result);
		System.out.println(jsonResult);
		return jsonResult;
		
	}
}
