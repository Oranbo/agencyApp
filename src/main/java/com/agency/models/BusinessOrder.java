package com.agency.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * 
 * @author BlackOrange
 *
 */
@Entity
@Table(name="business_order")
public class BusinessOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3170533009234334672L;

	@Id
	@GeneratedValue
	private int b_id;
	@ManyToOne(targetEntity=Usr.class)
	@JoinColumn(name="employee_id",referencedColumnName="id")
	private Usr employee;
	@ManyToOne(targetEntity=AddressBook.class)
	@JoinColumn(name="guest_id",referencedColumnName="a_id")
	private AddressBook addressBook2;
	@OneToOne(targetEntity=HouseInfo.class)
	@JoinColumn(name="house_id",referencedColumnName="h_id")
	private HouseInfo houseInfo;
	private String b_date;
	private String b_type;
	private BigDecimal real_price;
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public AddressBook getAddressBook2() {
		return addressBook2;
	}
	public void setAddressBook2(AddressBook addressBook) {
		this.addressBook2 = addressBook;
	}
	
	public Usr getEmployee() {
		return employee;
	}
	public void setEmployee(Usr employee) {
		this.employee = employee;
	}
	public HouseInfo getHouseInfo() {
		return houseInfo;
	}
	public void setHouseInfo(HouseInfo houseInfo) {
		this.houseInfo = houseInfo;
	}
	public String getB_date() {
		return b_date;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
	public String getB_type() {
		return b_type;
	}
	public void setB_type(String b_type) {
		this.b_type = b_type;
	}
	public BigDecimal getReal_price() {
		return real_price;
	}
	public void setReal_price(BigDecimal real_price) {
		this.real_price = real_price;
	}
	
	
	
	
	
}
