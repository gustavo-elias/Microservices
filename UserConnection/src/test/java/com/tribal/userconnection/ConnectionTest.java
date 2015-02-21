package com.tribal.userconnection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.tribal.persistenceabstraction.CacheableObject;

public class ConnectionTest {

	private static final String USERNAME_1 = "Username1";
	private static final int USER_ID_1 = 1;
	private static final String USERNAME_2 = "Username2";
	private static final int USER_ID_2 = 2;
	private static final String USERNAME_3 = "Username3";
	private static final int USER_ID_3 = 3;
	
	private Connection connection;
	private User user1, user2, user3;
	
	@Before
	public void setUp() {
		user1 = new User(USERNAME_1, USER_ID_1);
		user2 = new User(USERNAME_2, USER_ID_2);
		user3 = new User(USERNAME_3, USER_ID_3);
		connection = new Connection(user1, user2);
	}
	
	@Test
	public void constainsShouldReturnTrueIfConnectionContainsUser() {
		assertTrue(connection.contains(user1));
	}
	
	@Test
	public void constainsShouldReturnFalseIfConnectionDoesNotContainsUser() {
		assertFalse(connection.contains(user3));
	}
	
	@Test
	public void getRelatedElementShouldReturnTheOtherElementOfTheConnection() {
		assertEquals(user2, connection.getRelatedElement(user1));
		assertEquals(user1, connection.getRelatedElement(user2));
	}
	
	@Test
	public void getRelatedElementShouldReturnNullIfElementPassedIsNull() {
		assertNull(connection.getRelatedElement(null));
	}
	
	@Test
	public void getRelatedElementShouldReturnNullIfElementPassedIsNotPartOfTheConnection() {
		assertNull(connection.getRelatedElement(user3));
	}
	
	@Test
	public void getElementsShouldReturnListContainingBothUsersInTheRelation() {
		List<CacheableObject> users = connection.getElements();
		assertTrue(users.contains(user1));
		assertTrue(users.contains(user2));
		assertEquals(2, users.size());
	}
}
