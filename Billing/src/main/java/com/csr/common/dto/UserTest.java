package com.csr.common.dto;

import junit.framework.TestCase;

public class UserTest extends TestCase {

    private User user;

    protected void setUp() {

    }

    protected void tearDown() {

	}

    public void testUser() {
		User u = new User();
		assertNotNull(u);
    }
}