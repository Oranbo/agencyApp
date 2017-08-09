package com.agency.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBC{
	String driver = "com.mysql.jdbc.Driver";
	String dbName = "agency_data";
	String passwrod = "221131";
	String userName = "root";
	String url = "jdbc:mysql://localhost:3306/" + dbName;
//	String sql = "select distinct newsType from News";

	
	public void getConn(){
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, userName,
					passwrod);
			System.out.println("链接成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public List<String> getAllTypes(){
		ResultSet rs;
		List<String> list = new ArrayList<String>();
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, userName,
					passwrod);
			System.out.println("链接成功");
			PreparedStatement ps = conn.prepareStatement("");
			rs = ps.executeQuery(); 


			java.sql.ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount();
			while (rs.next()) {
				
				for (int i = 1; i <= columnCount; i++) {
					list.add(rs.getObject(i).toString());
				}
			}
			// 鍏抽棴璁板綍闆�
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// 鍏抽棴澹版槑
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// 鍏抽棴閾炬帴瀵硅薄
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
}