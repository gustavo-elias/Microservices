package com.tribal.persistenceabstraction;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PersistentAbstractionTest {

	private PersistentAbstraction persistentAbstraction;
	private CacheableRelation relation, nullRelation;
	private List<CacheableObject> relationElements, nullRelationElements;
	private CacheableObject element1, element2;
	
	@Before
	public void setUp() {
		persistentAbstraction = new PersistentAbstraction();
		relationElements = new ArrayList<CacheableObject>();
		nullRelationElements = new ArrayList<CacheableObject>();
		
		element1 = mock(CacheableObject.class);
		element2 = mock(CacheableObject.class);
		relation = mock(CacheableRelation.class);
		nullRelation = mock(CacheableRelation.class);
		
		relationElements.add(element1);
		relationElements.add(element2);
		when(relation.getElements()).thenReturn(relationElements);
		when(relation.contains(element1)).thenReturn(true);
		when(relation.getRelatedElement(element1)).thenReturn(element2);
		
		nullRelationElements.add(element1);
		nullRelationElements.add(null);
		when(nullRelation.getElements()).thenReturn(nullRelationElements);
	}
	
	@Test
	public void addElementShouldReturnFalseIfElementIsNull() {
		assertFalse(persistentAbstraction.addElement(null));
	}
	
	@Test
	public void addElementShouldReturnTrueIfElementIsValid() {
		assertTrue(persistentAbstraction.addElement(element1));
	}
	
	@Test
	public void addRelationShouldReturnFalseIfRelationIsNull() {
		assertFalse(persistentAbstraction.addRelation(null));
	}
	
	@Test
	public void addRelationShouldReturnFalseIfRelationHasNullObjectInIt() {
		assertFalse(persistentAbstraction.addRelation(nullRelation));
	}
	
	@Test
	public void addRelationShouldReturnTrueIfRelationIsValid() {
		assertTrue(persistentAbstraction.addRelation(relation));
	}
	
	@Test
	public void addRelationShouldAddBothObjectsToTheListOfElementsAndTheRelationToTheCache() {
		persistentAbstraction.addRelation(relation);
		Collection<CacheableObject> relatedElements = persistentAbstraction.retrieveConnections(element1);
		assertTrue(relatedElements.contains(element2));
		assertEquals(1, relatedElements.size());
	}
	
	@Test
	public void addRelationWithNullElementShouldNotAddElementsOrRelationToTheCache() {
		persistentAbstraction.addRelation(nullRelation);
		Collection<CacheableObject> relatedElements = persistentAbstraction.retrieveConnections(element1);
		assertEquals(0, relatedElements.size());
	}
}
