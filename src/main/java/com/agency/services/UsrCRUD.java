package com.agency.services;

import java.util.List;

import com.agency.models.Usr;

public interface UsrCRUD {

	public void add(Usr usr);
	public Usr getById(int id);
	public Usr getByName(String userName);
	public List<Usr> getAll();
	public void deleteById(int id);
	public void deleteAll();
	public void changePasswd(int id,String passwd);

}
