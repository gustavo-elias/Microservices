package com.tribal.userconnection;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

	private static final String USERNAME_ONE = "User1";
	private static final int USERNAME_ID_ONE = 1;
	private static final String USERNAME_TWO = "User2";
	private static final int USERNAME_ID_TWO = 2;
	private User user1, user2;
	
	@Before
	public void setUp() {
		user1 = new User(USERNAME_ONE, USERNAME_ID_ONE);
		user2 = new User(USERNAME_TWO, USERNAME_ID_TWO);
	}
	
	@Test
	public void newlyCreatedUserShouldHaveEmptyListOfConnections() {
		assertEquals(0, user1.retrieveUsersConnected().size());
	}
	
	@Test
	public void connectingToNullUserShouldNotAddConnections() {
		user1.connectToUser(null);
		
		assertEquals(0, user1.retrieveUsersConnected().size());
	}
	
	@Test
	public void alreadyConnectedUsersShouldNotBeAddedTwice() {
		user1.connectToUser(user2);
		user2.connectToUser(user1);
		
		assertEquals(1, user1.retrieveUsersConnected().size());
		assertEquals(1, user2.retrieveUsersConnected().size());
	}
	
	@Test
	public void connectingToAnUserShouldAddUserToConnectionsForBothUsers() {
		user1.connectToUser(user2);
		
		assertEquals(1, user1.retrieveUsersConnected().size());
		assertEquals(user2, user1.retrieveUsersConnected().get(0));
		
		assertEquals(1, user2.retrieveUsersConnected().size());
		assertEquals(user1, user2.retrieveUsersConnected().get(0));
	}
	

}
