package com.agency.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.agency.models.HouseInfo;
import com.agency.services.hibernate.MyException;

public interface HouseInfoCRUD {

	public void add(HouseInfo houseInfo) throws MyException;
	public List<HouseInfo> getAll();
	public HouseInfo getById(int id);
	public void changeHouseStatus(int id,String status) throws MyException;
	public void deleteById(int id);
	public void deleteAll();
	public void  changeSellStatus(int h_id,String sell_status); 
	public List<HouseInfo> getByAddress(String address);
	public List<HouseInfo> getByRentprice(BigDecimal r_price);
	public List<HouseInfo> getBySealprice(BigDecimal s_price);
	public List<HouseInfo> getBySize(BigDecimal size);
	public List<HouseInfo> getByLayout(String layout);
	public List<HouseInfo> getByFloor(int floor);
	public List<HouseInfo> getByDecoration(String decoration) throws MyException; 
	public List<HouseInfo> getByRentType(String rtype) throws MyException;
	public List<HouseInfo> getBySellStatus(String sell_status) throws DataAccessException, MyException;
	void updateHouseInfo(HouseInfo houseInfo) throws MyException;
}
