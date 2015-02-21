package com.tribal.userconnection;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String name;
	private int id;
	List<User> usersConnectedTo = new ArrayList<User>();
	
	public User(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public void connectToUser(User userToConnectTo) {
		usersConnectedTo.add(userToConnectTo);
	}

	public List<User> retrieveUsersConnected() {
		return usersConnectedTo;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}