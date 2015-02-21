package com.tribal.userconnection;

public class Connection {

	private User user1, user2;
	
	public Connection(User user1, User user2) {
		if(null != user1 && null != user2) {
			this.user1 = user1;
			this.user2 = user2;
		}
	}
	
	public User connectedTo(User user) {
		if(user.equals(user1)) {
			return user2;
		} else if (user.equals(user2)) {
			return user1;
		}
		return null;
	}
}
