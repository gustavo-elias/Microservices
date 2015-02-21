package com.tribal.persistenceabstraction;

import java.util.Collection;

public interface Cacheable {
	public <T extends CacheableObject> boolean addElement(T element);
	public <T extends CacheableRelation> boolean addRelation(T relation);
	public <T extends CacheableObject> Collection<T> retrieveConnections(T element);
}
