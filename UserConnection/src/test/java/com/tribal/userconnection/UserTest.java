package com.tribal.userconnection;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

	private static final String USERNAME_ONE = "User1";
	private static final int USERNAME_ID_ONE = 1;
	private static final String USERNAME_TWO = "User2";
	private static final int USERNAME_ID_TWO = 2;
	private User user, user2;
	
	@Before
	public void setUp() {
		user = new User(USERNAME_ONE, USERNAME_ID_ONE);
		user2 = new User(USERNAME_TWO, USERNAME_ID_TWO);
	}
	
	@Test
	public void connectingToAnUserShouldAddUserToConnections() {
		user.connectToUser(user2);
		
		assertEquals(1, user.retrieveUsersConnected().size());
		assertEquals(user2, user.retrieveUsersConnected().get(0));
	}
	
	@Test
	public void newlyCreatedUserShouldHaveEmptyListOfConnections() {
		assertEquals(0, user.retrieveUsersConnected().size());
	}
}
