package com.agency.test;

import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.agency.services.JDBC;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class JdbcTset {
	JDBC j = new JDBC();
	@Before
	@org.junit.Test
	public void testConn(){
		j.getConn();
	}

}
