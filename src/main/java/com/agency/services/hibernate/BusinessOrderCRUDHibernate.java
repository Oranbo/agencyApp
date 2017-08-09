package com.agency.services.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.agency.models.BusinessOrder;
import com.agency.services.BusinessOrderCRUD;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 
 * @author BlackOrange
 *
 */
@Service("businessOrderCRUDHibernate")
public class BusinessOrderCRUDHibernate implements BusinessOrderCRUD {

	private HibernateTemplate ht;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		ht = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	@Transactional
	public void add(BusinessOrder businessOrder) {
		// TODO 自动生成的方法存根
		ht.save(businessOrder);
	}

	@Override
	@Transactional
	public BusinessOrder getById(int id) {
		// TODO 自动生成的方法存根
		BusinessOrder businessOrder = ht.get(BusinessOrder.class, id);
		return businessOrder;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<BusinessOrder> getByEmployeeId(int employee_id) {
		// TODO 自动生成的方法存根
		List<BusinessOrder> businessOrder = (List<BusinessOrder>) ht.find("from BusinessOrder where employee_id=?", employee_id);
		return businessOrder;
	}

	@Override
	@Transactional
	public List<BusinessOrder> getAll() {
		// TODO 自动生成的方法存根
		List<BusinessOrder> businessOrder = (List<BusinessOrder>) ht.find("from BusinessOrder");
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(businessOrder);
			System.out.println(json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return businessOrder;
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		// TODO 自动生成的方法存根
		BusinessOrder businessOrder = this.getById(id);
		ht.delete(businessOrder);

	}

	@Override
	@Transactional
	public void deleteAll() {
		// TODO 自动生成的方法存根
		List<BusinessOrder> businessOrders = this.getAll();
		for(BusinessOrder businessOrder:businessOrders){
			ht.delete(businessOrder);
		}
	}

}
