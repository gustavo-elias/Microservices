# Microservices

Since the exercise was intentionally open to interpretation, I have tried to comply with the contract
in the simplest possible way. To do so, I have created two microservices as requested:

- PersistenceAbstraction: Is basically a cache. This cache consists of three interfaces.
	+ Cacheable: The facade that organises the cache. The methods are as follows:
		1. addElement: Obviously, adds an element to the cache.
		2. addRelation: creates a relation between two elements. These elements don't need to exist
					in the cache (they will be added if they are not), but they need to be valid
					(i.e. not null).
		3. retrieveRelations: given an element, returns all other objects related to it.
		A default implementation (PersistenceAbstraction) is provided for this interface.
	+ CacheableObject: The object type that will be stored inside the cache.
	+ CacheableRelation: Relations between objects to be cached. This is one of the decisions I had
		to make. I could have not mapped the relations as a class, but since it's an important part
		of the problem, it made sense to do so.

- UserConnection: Implements two of the three interfaces and makes use of the default implementation
	of Cacheable to persist its state as requested.
	+ User: The basic user. Implements CacheableObject so it can be added to the cache.
	+ Connection: A relation between two users. Implements CacheableRelation using two users as
		CacheableObjects.
	+ UserConnection: Uses an instance of the default implementation of Cacheable 
		(PersistenceAbstraction) to store the state as required.
		
The way to test it is quite simple. Just add PersistenceAbstraction project to the classpath of
UserConnection so the dependencies are resolved and run the tests.

To use PersistenceAbstraction in another microservice, all is needed is to implement CacheableObject
as the elements that are going to be stored and CacheableRelation as the connections between the
elements. After that, either use an instance of the default implementation (PersistenceAbstraction)
or implement Cacheable inside the microservice.
