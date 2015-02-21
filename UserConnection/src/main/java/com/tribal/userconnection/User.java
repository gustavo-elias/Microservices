package com.tribal.userconnection;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {

	private final static Logger LOGGER = Logger.getLogger(User.class.getName());
	
	private String name;
	private int id;
	private List<User> usersConnectedTo = new ArrayList<User>();
	
	public User(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public void connectToUser(User userToConnectTo) {
		if(null != userToConnectTo) 
		{
			if (!usersConnectedTo.contains(userToConnectTo)) {
				usersConnectedTo.add(userToConnectTo);
				userToConnectTo.connectToUser(this);
			} else {
				LOGGER.log(Level.INFO, "Users " + this.name + ", " + userToConnectTo.getName() + " were already connected");
			}
		} else {
			LOGGER.log(Level.INFO, "User " + this.name +" can't connect to a null user");
		}
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
