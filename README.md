# jpa(java persistence api) and hibernate

## jpa 
* it is a specification for accessing, persisting, and managing data between Java objects/classes and a relational database. 
* it is a code specification that secify some api to deal with
* JPA provides a standardized way to perform object-relational mapping (ORM), allowing developers to map Java objects to database tables in a consistent and portable manner
* there are no implementation of the jpa but there are provider for it like (hibernate, eclips,...)

### arch
* conficration file( persistence.xml) (persistence-unit, provider, props)
* sessionfactory (EntityManagerFactory)
* session (EnitityManager)
* query api(api provided by session (EntityManager))
* first level cach (context)

## id strategy 
 it is away to generate id by databse (hibernate or jpa not generate any automatic id)
### INDENTITY
 which is to generate the id automaticall within the table
this mean that the table is identify the next value of the database
### TABLE
 which is to generate the id automaticall within the collection of
 there are another table to generate the nextvalue (TableGenerator) 
### AUTO
 lets Hibernate decide the best generation strategy based on the underlying database dialect

## access in jpa
### Field access
* add anotation in the filed
* it use the relection api not setter and getter
* it break the encapsulation (there are no logic in the field access)
* if i use the field access for only one field, all other fields will be field access <br>
    -> to convert this filed access to  property access use<br> 
    *** -> @Access(AccessType.PROPERTY)

### property access
* add anotation in the setter or getter
* it use the setter and getter not relection api

## Entity life cycle
### transit 
* The entity is created but not yet associated with a persistence context 
* it is not managed by an EntityManager
* It does not have a database identity, and changes made to the entity are not persisted to the database.

### Managed State(emplo.persist())
*  The entity is associated with a persistence context. Changes to the entity will be synchronized with the database.
* The EntityManager is responsible for managing the entity. The entity is automatically synchronized with the database at transaction commit or explicit flush.
* >persistent();

### Detached State
* The entity is no longer associated with a persistence context. 
* It may have been previously managed but now exists outside the scope of the EntityManager
* Changes to the entity are not automatically synchronized with the database. 
* >detach(), close()
* To reattach the entity, you can use :  
* >EntityManager.merge().
### Removed State
* The entity has been marked for removal, It will be deleted from the database when the transaction is committed.
* The entity is still managed until the transaction commits or the removal is explicitly canceled.
* >remove()

## APIs
### em.persist(object)
* it move from the transfer from transit to managed state
* it add object to context(FLC) and changes added to the database
* when commit it add to the database
* it still cloning it (thats mean the the chang in the object affect in the database)
* can't persist two object with the same id (throw exception)

### em.find(.class, primaryKey)
* When you call find, the EntityManager first checks if the entity is already managed in the persistence context. If it is, it returns the existing entity instance without querying the database.
* If the entity is not found in the persistence context, the EntityManager will query the database to retrieve the entity. If the entity is found, it is added to the persistence context and returned. if it is not find it will return null

### getReference()
* It is used to retrieve a reference to an entity by its primary key
* This reference is a proxy object that represents the entity but does not immediately load its data from the database.
* This proxy object is a placeholder that stands in for the actual entity.
* The proxy object does not load the actual data from the database at this point. Instead, it contains information about the entity's identifier and its class
* When you access a property or method of the proxy object that requires data (e.g., accessing a field or calling a method that triggers data retrieval), Hibernate performs a database query to fetch the entity's data from the database(lazy loading)

* the major diff(getReference & find) ==> query to database and existing in context<br>
1 - find => when use find it search in context if it is find it will return else it will query for it in db immediatly and exist as Entity object(data)
2 - getReference ==> when use it it will create a proxy in the context and it will query the database when the proxy object use 

### detach(object) 
* remove the object from context (first level cache)
* it is not connection to database for changes

### merge 
* *insert(auto-id | user-id & obj not exits in db & context)
* *update (user-id & id is exist)
* if there is an context object with the same id of trasit object which is merged it will set the state to the context object and this operation(merge) will return the context update object
* if there are no context object with the same id <br>
 => if it is aut_generated id <br>
 **(it will create the context object with null value for id and then insert it to the database(insert opertaion) and db will generate the id)<br>
 => if it is an user define id(natural id) ==><br> 
 ** if id exitst in context it will update it<br>
 ** if not it will query for db and if exist in db it will add it in context and update it<br>
 ** if not it will create the new context object with the same props and insert it <br>


### remove 
* can't remove the detach object and transit object
* the only manage object that can remove it 
* so we need to managed the object first before remove it (persist, find, merge, getReference) + remove

### clear
* it to detach all context object 


## assosiation 
### oo assosiation types
* one to one (bi,uni -> directional)
* one to many (uni -> directional)
* many to one (uni -> directional) 
* many to many (uni, bi -> directional)


### DBMS assosiation types
* bi-direction (fk, join table)




## annotations
* @Column(name, length, unique"true, false")
* @Temporal(TemporalType.Date) -> solve the date issue where remove the time from the date<br>
 -> but you can use the LocalDate datetype instead
* @Transient -> for not map this attribute into table column

## jpa vs jdbc