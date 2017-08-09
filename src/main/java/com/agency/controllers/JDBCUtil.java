//package com.agency.controllers;
//
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.agency.models.AddressBook;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
//
//
//public class JDBCUtil {
//	static String driver = "com.mysql.jdbc.Driver";
//	static String dbName = "agency_data";
//	static String passwrod = "221131";
//	static String userName = "root";
//	static String url = "jdbc:mysql://localhost:3306/" + dbName;
//
//	public static AddressBook getByUsrID(int usr_id){
//		String sql = "select * from address_book where usr_id="+usr_id;
//		ResultSet rs;
//		List<AddressBook> list = new ArrayList<>();
//		AddressBook a=null;
//		try {
//			Class.forName(driver);
//			Connection conn = (Connection) DriverManager.getConnection(url, userName,
//					passwrod);
//			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
//			rs = ps.executeQuery(); 
//
//
//			java.sql.ResultSetMetaData md = rs.getMetaData();
//			int columnCount = md.getColumnCount();
//			while (rs.next()) {
//				a =new AddressBook();
//				a.setA_id(rs.getInt("a_id"));
//				a.setA_type(rs.getString("a_type"));
//				a.setAddress(rs.getString("address"));
//				a.setHead_pictures(null);
//				a.setName(rs.getString("name"));
//				a.setPhone_number(rs.getString("phone_number"));
//				a.setUser(null);
//			
//			}
//			// 鍏抽棴璁板綍闆�
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//
//			// 鍏抽棴澹版槑
//			if (ps != null) {
//				try {
//					ps.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//
//			// 鍏抽棴閾炬帴瀵硅薄
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return a;
//
//	}
//}
