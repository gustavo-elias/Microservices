package com.tribal.userconnection;

import java.util.Collection;

import com.tribal.persistenceabstraction.Cacheable;
import com.tribal.persistenceabstraction.defaultimplementation.PersistenceAbstraction;

public class UserConnection {

	private Cacheable persistenceAbstraction = new PersistenceAbstraction();

	public boolean addUser(User user) {
		return persistenceAbstraction.addElement(user);
	}

	public boolean addConnection(Connection connection) {
		return persistenceAbstraction.addRelation(connection);
	}

	public Collection<User> retrieveConnections(User user) {
		Collection<User> collection = persistenceAbstraction.retrieveRelations(user);
		return collection;
	}
}