package com.agency.services;

import java.util.List;

import com.agency.models.BusinessOrder;

public interface BusinessOrderCRUD {

	public void add(BusinessOrder businessOrder);
	public BusinessOrder getById(int id);
	public List<BusinessOrder> getByEmployeeId(int employee_id);
	public List<BusinessOrder> getAll();
	public void deleteById(int id);
	public void deleteAll();
	
}
