package com.gxk.signle;

import org.junit.Test;

public class JdbcSignleTest {
	@Test
	public void testJdbcSignle() throws Exception {
		JdbcSignle Singleton = JdbcSignle.getInstance();
		Singleton.getConnection();
		Singleton.closeConnection();
	}
}
