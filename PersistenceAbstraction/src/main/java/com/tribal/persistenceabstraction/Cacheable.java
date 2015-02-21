package com.tribal.persistenceabstraction;

import java.util.Collection;

public interface Cacheable {
	public boolean addElement(CacheableObject element);
	public boolean addRelation(CacheableRelation relation);
	public Collection<CacheableObject> retrieveConnections(CacheableObject element);
}
