package com.agency.services.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agency.models.Usr;
import com.agency.services.UsrCRUD;
/**
 * 
 * @author BlackOrange
 *
 */
@Service("usrCRUDHibernate")
public class UsrCRUDHibernate implements UsrCRUD{

	private HibernateTemplate ht;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		ht = new HibernateTemplate(sessionFactory);
	}

	@Override
	@Transactional
	public void add(Usr usr){
		ht.save(usr);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usr> getAll() {
		// TODO 自动生成的方法存根
		List<Usr> users=(List<Usr>)ht.find("from Usr");
		return users;
	}
	
	@Override
	@Transactional
	public Usr getById(int id) {
		// TODO 自动生成的方法存根
		return ht.get(Usr.class, id);
	}


	@Override
	@Transactional
	public void deleteById(int id) {
		// TODO 自动生成的方法存根
		Usr usr=this.getById(id);
		ht.delete(usr);
	}

	@Override
	@Transactional
	public void deleteAll() {
		// TODO 自动生成的方法存根
		List<Usr> users=this.getAll();
		for(Usr user:users){
			ht.delete(user);
		}
	}

	@Override
	@Transactional
	public void changePasswd(int id, String passwd) {
		// TODO 自动生成的方法存根
		Usr user=this.getById(id);
		user.setPasswd(passwd);
		ht.update(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Usr getByName(String userName) {
		// TODO 自动生成的方法存根
		List<Usr> usr = (List<Usr>) ht.find("from Usr where login_name=?", userName);
		if(usr.size()>0)
			return usr.get(0);
		else
			return null;
		
	}


	

	


	
}
