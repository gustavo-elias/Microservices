package com.tribal.userconnection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.tribal.persistenceabstraction.CacheableObject;
import com.tribal.persistenceabstraction.CacheableRelation;

public class Connection implements CacheableRelation {

	private CacheableObject user1, user2;
	
	public Connection(CacheableObject user1, CacheableObject user2) {
		if(null != user1 && null != user2) {
			this.user1 = user1;
			this.user2 = user2;
		}
	}

	public boolean contains(CacheableObject element) {
		return (user1.equals(element) || user2.equals(element));
	}

	public CacheableObject getRelatedElement(CacheableObject element) {
		if(null != element) {
			if(user1.equals(element)) {
				return user2;
			} else if (user2.equals(element)) {
				return user1;
			} else {
				return null;
			}
		}
		return null;
	}

	public List<CacheableObject> getElements() {
		return new ArrayList<CacheableObject>(Arrays.asList(user1, user2));
	}

}
