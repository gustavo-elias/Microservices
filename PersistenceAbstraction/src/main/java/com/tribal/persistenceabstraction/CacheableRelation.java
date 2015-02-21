package com.tribal.persistenceabstraction;

import java.util.List;

public interface CacheableRelation {
	public boolean contains(CacheableObject element);
	public CacheableObject getRelatedElement(CacheableObject element);
	public List<CacheableObject> getElements();
}
