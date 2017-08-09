package com.agency.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * 
 * @author BlackOrange
 *
 */
@Entity
@Table(name="usr")
public class Usr implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4968434851434263205L;
	
	@Id
	@GeneratedValue
	private int id;
	@OneToOne(targetEntity=AddressBook.class)
	@JoinColumn(name="info_id",referencedColumnName="a_id")
	private AddressBook addressBook;
	private String login_name;
	private String passwd;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy = "usr",fetch=FetchType.EAGER/*,orphanRemoval=true*/)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public AddressBook getAddressBook() {
		return addressBook;
	}
	public void setAddressBook(AddressBook addressBook) {
		this.addressBook = addressBook;
	}

}
