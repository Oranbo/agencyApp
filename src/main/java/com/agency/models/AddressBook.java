package com.agency.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Table;

import com.agency.controllers.Utl;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
/**
 * 
 * @author BlackOrange
 * 通讯录
 *
 */
@Entity
@Table(name="address_book")
public class AddressBook implements Serializable,Comparable<AddressBook> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7777177921914497905L;
	
	@Id
	@GeneratedValue
	private int a_id;
	private String a_type;
	private String name;
	private String sex;
	private String phone_number;
	private String address;
	private byte[] head_pictures;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy = "address_book",fetch=FetchType.EAGER/*,orphanRemoval=true*/)
	
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getA_type() {
		return a_type;
	}
	public void setA_type(String a_type) {
		this.a_type = a_type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public byte[] getHead_pictures() {
		return head_pictures;
	}
	public void setHead_pictures(byte[] head_pictures) {
		this.head_pictures = head_pictures;
	}
	@Override
	public int compareTo(AddressBook o) {

		// TODO Auto-generated method stub
		String a1 = Utl.converterToFirstSpell(o.getName());
		String a2 = Utl.converterToFirstSpell(this.getName());
		if (a1.trim().toCharArray()[0]<=a2.trim().toCharArray()[0]) {
			return 1;
		}else {
			return -1;
		}
	}
	
}
