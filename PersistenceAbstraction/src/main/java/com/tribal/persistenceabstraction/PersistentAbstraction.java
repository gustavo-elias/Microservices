package com.tribal.persistenceabstraction;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class PersistentAbstraction implements Cacheable {
    Collection<CacheableObject> cache = new HashSet<CacheableObject>();
    Collection<CacheableRelation> connectedElements = new HashSet<CacheableRelation>();
    
	public boolean addElement(CacheableObject element) {
		if(null != element && !cache.contains(element)){
			cache.add(element);
			return true;
		}
		return false;
	}

	public boolean addRelation(CacheableRelation relation) {
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

	public Collection<CacheableObject> retrieveConnections(CacheableObject element) {
		Collection<CacheableObject> connections = new HashSet<CacheableObject>();
		for(CacheableRelation relation : connectedElements) {
			if(relation.contains(element)) {
				connections.add(relation.getRelatedElement(element));
			}
		}
		return connections;
	}
}
