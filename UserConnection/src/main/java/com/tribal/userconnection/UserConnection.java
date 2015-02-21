package com.tribal.userconnection;

import java.util.Collection;

import com.tribal.persistenceabstraction.PersistentAbstraction;

public class UserConnection {

	private PersistentAbstraction persistentAbstraction = new PersistentAbstraction();

	public boolean addUser(User user) {
		return persistentAbstraction.addElement(user);
	}

	public boolean addConnection(Connection connection) {
		return persistentAbstraction.addRelation(connection);
	}

	public Collection<User> retrieveConnections(User user) {
		Collection<User> collection = persistentAbstraction.retrieveConnections(user);
		return collection;
	}
}