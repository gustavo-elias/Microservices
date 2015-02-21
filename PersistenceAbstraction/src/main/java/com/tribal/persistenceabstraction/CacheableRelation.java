package com.tribal.persistenceabstraction;

import java.util.List;

public interface CacheableRelation {
	public <T extends CacheableObject> boolean contains(T element);
	public <T extends CacheableObject> T getRelatedElement(T element);
	public <T extends CacheableObject> List<T> getElements();
}
