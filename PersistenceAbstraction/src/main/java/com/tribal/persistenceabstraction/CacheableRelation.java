package com.tribal.persistenceabstraction;

import java.util.List;

public interface CacheableRelation {
	public void exists(CacheableObject element1, CacheableObject element2);
	public boolean contains(CacheableObject element);
	public CacheableObject getRelatedElement(CacheableObject element);
	public List<CacheableObject> getElements();
}
