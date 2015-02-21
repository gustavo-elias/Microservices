package com.tribal.persistenceabstraction;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class PersistentAbstraction implements Cacheable {
    Collection<CacheableObject> cache = new HashSet<CacheableObject>();
    Collection<CacheableRelation> connectedElements = new HashSet<CacheableRelation>();
    
    public <T extends CacheableObject> boolean addElement(T element) {
		if(null != element && !cache.contains(element)){
			cache.add(element);
			return true;
		}
		return false;
	}

	public <T extends CacheableRelation> boolean addRelation(T relation) {
		if(null != relation && !connectedElements.contains(relation)) {
			List<CacheableObject> relationElements = relation.getElements();
			if(!relationElements.contains(null)) {
				for(CacheableObject element : relationElements) {
					addElement(element);
				}
				connectedElements.add(relation);
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public <T extends CacheableObject> Collection<T> retrieveConnections(T element) {
		Collection<T> connections = new HashSet<T>();
		for(CacheableRelation relation : connectedElements) {
			if(relation.contains(element)) {
				connections.add((T) relation.getRelatedElement(element));
			}
		}
		return connections;
	}
}
