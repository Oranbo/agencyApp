package com.agency.services.hibernate;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.agency.models.HouseInfo;
import com.agency.services.Constants;
import com.agency.services.HouseInfoCRUD;
/**
 * 
 * @author BlackOrange
 *
 */
@Service("houseInfoCRUDHibernate")
public class HouseInfoCRUDHibernate implements HouseInfoCRUD {

	
	private HibernateTemplate ht;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		ht = new HibernateTemplate(sessionFactory);
	}
	@Override
	@Transactional
	public void add(HouseInfo houseInfo) throws MyException {
		// TODO 自动生成的方法存根
		if (isDecValid(houseInfo.getDecoration())
				&&isStatusValid(houseInfo.getHouse_status())
				&&isTypeValid(houseInfo.getH_type())) {
			System.out.println("添加开始");
			ht.save(houseInfo);
			System.out.println("添加成功");	
		}	
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<HouseInfo> getAll() {
		// TODO 自动生成的方法存根
		List<HouseInfo> houseInfos = (List<HouseInfo>) ht.find("from HouseInfo");
		return houseInfos;
	}

	@Override
	@Transactional
	public HouseInfo getById(int id) {
		// TODO 自动生成的方法存根
		return ht.get(HouseInfo.class, id);
	}

	@Override
	@Transactional
	public void changeHouseStatus(int id, String status) throws MyException {
		// TODO 自动生成的方法存根
		while (isStatusValid(status)) {
			HouseInfo houseInfo = this.getById(id);
			houseInfo.setHouse_status(status);
		}		
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		// TODO 自动生成的方法存根
		HouseInfo houseInfo = this.getById(id);
		ht.delete(houseInfo);
	}

	@Override
	@Transactional
	public void deleteAll() {
		// TODO 自动生成的方法存根
		List<HouseInfo> houseInfos = this.getAll();
		for(HouseInfo houseInfo:houseInfos){
			ht.delete(houseInfo);
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<HouseInfo> getByAddress(String address) {
		// TODO 自动生成的方法存根
		List<HouseInfo> houseInfos = (List<HouseInfo>) ht.find("from HouseInfo where address like ?", "%"+address+"%");
		return houseInfos;
	}
	@Override
	@Transactional
	public List<HouseInfo> getByRentprice(BigDecimal r_price) {
		// TODO 自动生成的方法存根
		BigDecimal x = new BigDecimal(1000);
		BigDecimal low = r_price.subtract(x).floatValue()>0 ? r_price.subtract(x):new BigDecimal(0);
		BigDecimal high = r_price.add(x);
		@SuppressWarnings("unchecked")
		List<HouseInfo> houseInfos = (List<HouseInfo>) ht.find("from HouseInfo where r_price between ? and ?",low,high);
		return houseInfos;
	}
	@Override
	@Transactional
	public List<HouseInfo> getBySealprice(BigDecimal s_price) {
		// TODO 自动生成的方法存根
		BigDecimal x = new BigDecimal(100000);
		BigDecimal low = s_price.subtract(x).floatValue()>0 ? s_price.subtract(x):new BigDecimal(0);
		BigDecimal high = s_price.add(x);
		@SuppressWarnings("unchecked")
		List<HouseInfo> houseInfos = (List<HouseInfo>) ht.find("from HouseInfo where s_price between ? and ?",low,high);
		return houseInfos;
	}
	@Override
	@Transactional
	public List<HouseInfo> getBySize(BigDecimal size) {
		// TODO 自动生成的方法存根
		BigDecimal x = new BigDecimal(10);
		BigDecimal low = size.subtract(x).floatValue()>0 ? size.subtract(x):new BigDecimal(0);
		BigDecimal high = size.add(x);
		@SuppressWarnings("unchecked")
		List<HouseInfo> houseInfos = (List<HouseInfo>) ht.find("from HouseInfo where size between ? and ?",low,high);
		return houseInfos;
	}
	@Override
	@Transactional
	public List<HouseInfo> getByLayout(String layout) {
		// TODO 自动生成的方法存根
		@SuppressWarnings("unchecked")
		List<HouseInfo> houseInfos = (List<HouseInfo>) ht.find("from HouseInfo where layout like ?",layout+"%");
		return houseInfos;
	}
	@Override
	@Transactional
	public List<HouseInfo> getByFloor(int floor) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<HouseInfo> houseInfos = (List<HouseInfo>) ht.find("from HouseInfo where floor = ?", floor);
		return houseInfos;
	}
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<HouseInfo> getByDecoration(String decoration) throws MyException {
		// TODO Auto-generated method stub
		List<HouseInfo> houseInfos = null;
		while (isDecValid(decoration)) {
			houseInfos = (List<HouseInfo>) ht.find("from HouseInfo where decoration = ?", decoration);
		}
		return houseInfos;
	}
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<HouseInfo> getByRentType(String rtype) throws MyException {
		// TODO Auto-generated method stub
		List<HouseInfo> houseInfos = null;
		while (isRtValid(rtype)) {
			houseInfos = (List<HouseInfo>) ht.find("from HouseInfo where rent_type = ?", rtype);
		}
		return houseInfos;
	}
	@Override
	@Transactional
	public void changeSellStatus(int h_id, String sell_status) {
		// TODO Auto-generated method stub
		HouseInfo houseInfo =getById(h_id);
		houseInfo.setSell_status(sell_status);
	}
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<HouseInfo> getBySellStatus(String sell_status) throws DataAccessException, MyException {
		// TODO Auto-generated method stub
		List<HouseInfo> houseInfos = null;
//		while (isSSValid(sell_status)) {
			houseInfos = (List<HouseInfo>) ht.find("from HouseInfo where sell_status = ?", sell_status);
//		}
		return houseInfos;
	}
	@Override
	@Transactional
	public void updateHouseInfo(HouseInfo houseInfo) throws MyException {
		// TODO Auto-generated method stub
		String decoration = houseInfo.getDecoration();
		String house_status = houseInfo.getHouse_status();
		String h_type = houseInfo.getH_type();
		String sell_status = houseInfo.getSell_status();
		String rent_type = houseInfo.getRent_type();
//		while (isDecValid(decoration)&&isRtValid(rent_type)&&isSSValid(sell_status)
//				&&isStatusValid(house_status)&&isTypeValid(h_type)) {
//			ht.update(houseInfo);
//		}
		ht.update(houseInfo);
	}
	private boolean isStatusValid(String status) throws MyException {
		if (status.equals(Constants.enumUtil.rented.getName())
				|status.equals(Constants.enumUtil.sented.getName())
				|status.equals(Constants.enumUtil.wait_rent.getName())
				|status.equals(Constants.enumUtil.wait_sent.getName())) {			
			return true;
		}else {
			throw new MyException("状态信息不符合规则！");
			
		}
	}
	private boolean isTypeValid(String types) throws MyException {
		if(types.equals(Constants.enumUtil.rent.getName())
				|types.equals(Constants.enumUtil.sent.getName())
				|types.equals(Constants.enumUtil.rent_sent.getName())){
			return true;
		}else{
			throw new MyException("类型信息不符合规则！");
		}
	}
	
	private boolean isDecValid(String dec) throws MyException {
		if (dec.equals(Constants.enumUtil.high.getName())
				|dec.equals(Constants.enumUtil.low.getName())
				|dec.equals(Constants.enumUtil.normal.getName())) {
			return true;
		}else {
			throw new MyException("装修信息不符合规则！");
		}
	}
	
	private boolean isRtValid(String rent_type) throws MyException {
		if (rent_type.equals(Constants.enumUtil.one.getName())
				|rent_type.equals(Constants.enumUtil.all.getName())
				|rent_type.equals(Constants.enumUtil.join.getName())) {
			return true;
		}else {
			throw new MyException("出租类型信息不符合规则！");
		}
	}
	private boolean isSSValid(String sell_status) throws MyException {
		if(sell_status.equals(Constants.enumUtil.online.getName())
				|sell_status.equals(Constants.enumUtil.offline.getName())){
			return true;
		}else {
			throw new MyException("售卖状态信息不符合规则！");
		}
	}
	
}
