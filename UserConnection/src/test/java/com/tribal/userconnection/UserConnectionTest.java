package com.tribal.userconnection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class UserConnectionTest {

	private static final String USERNAME_1 = "Username1";
	private static final int USER_ID_1 = 1;
	private static final String USERNAME_2 = "Username2";
	private static final int USER_ID_2 = 2;
	
	private UserConnection userConnection;
	private User user1, user2;
	private Connection connection;
	
	@Before
	public void setUp() {
		userConnection = new UserConnection();
		user1 = new User(USERNAME_1, USER_ID_1);
		user2 = new User(USERNAME_2, USER_ID_2);
		connection = new Connection(user1, user2);
	}
	
	@Test
	public void addUserShouldReturnFalseIfUserIsNull() {
		assertFalse(userConnection.addUser(null));
	}
	
	@Test
	public void addUserShouldReturnTrueForValidUser() {
		assertTrue(userConnection.addUser(user1));
	}
	
	@Test
	public void addConnectionShouldReturnFalseIfConnectionIsNull() {
		assertFalse(userConnection.addConnection(null));
	}
	
	@Test
	public void addConnectionShouldReturnTrueisConnectionIsValid() {
		assertTrue(userConnection.addConnection(connection));
	}
	
	@Test
	public void retrieveConnectionShouldReturnEmptyCollectionIfUserHasNoConnections() {
		userConnection.addUser(user1);
		assertEquals(0, userConnection.retrieveConnections(user1).size());
	}
	
	@Test
	public void retrieveConnectionShouldReturnCollectionOfConnectedUsers() {
		userConnection.addConnection(connection);
		Collection<User> connections = userConnection.retrieveConnections(user1);
		assertEquals(1, connections.size());
		assertTrue(connections.contains(user2));
	}
}
