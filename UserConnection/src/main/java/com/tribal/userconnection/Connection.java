package com.tribal.userconnection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.tribal.persistenceabstraction.CacheableObject;
import com.tribal.persistenceabstraction.CacheableRelation;

public class Connection implements CacheableRelation {

	private User user1, user2;
	
	public Connection(User user1, User user2) {
		if(null != user1 && null != user2) {
			this.user1 = user1;
			this.user2 = user2;
		}
	}

	public <T extends CacheableObject> boolean contains(T element) {
		return (user1.equals(element) || user2.equals(element));
	}

	@SuppressWarnings("unchecked")
	public <T extends CacheableObject> T getRelatedElement(T element) {
		if(null != element) {
			if(user1.equals(element)) {
				return (T) user2;
			} else if (user2.equals(element)) {
				return (T) user1;
			} else {
				return null;
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<User> getElements() {
		return new ArrayList<User>(Arrays.asList(user1, user2));
	}
}
