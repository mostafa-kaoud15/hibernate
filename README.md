# jpa(java persistence api) and hibernate

## jpa 
* it is a specification for accessing, persisting, and managing data between Java objects/classes and a relational database. 
* it is a code specification that secify some api to deal with
* JPA provides a standardized way to perform object-relational mapping (ORM), allowing developers to map Java objects to database tables in a consistent and portable manner
* there are no implementation of the jpa but there are provider for it like (hibernate, eclips,...)

### arch
* configration file( persistence.xml) (persistence-unit, provider, props)
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
* it use the reflection api not setter and getter
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
* >persist();

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
### intro
#### oo assosiation types
* one to one (bi,uni -> directional)
* one to many (uni -> directional)
* many to one (uni -> directional) 
* many to many (uni, bi -> directional)


#### DBMS assosiation types
* bi-direction (fk, join table)


### creating the relation between two object 
* relation type(oneToOne, oneToMany, manyToOne,....)
* joinColumn or joinTable -> use the annotation (@JoinTable, @JoinColumn)
* bi, ui ->directional (to make it bi give control to one side using (@Join..(mapedby = "objectName")))

### many to one (uni)
* it is join by column by default
* to make it joint by table us (@JoinTable(name, jointcolumns, inverseColumns))


### one to many (uni)
* it is join by table by default

### one to many and many to one (bi)
* i have to use (mappedby = "attribute name of the manytoone") inside @OneToMany

### one to one(uni, bi)
* it use the JoinColumn
* the other like the above

### one to one (Shared Primary Key && uni)
* use the @PrimaryKeyJoinColumn after @OneToOne
* there are no forgin key
* it search for the primary key for both table if there are and join based on the same value in prmary key 
* ex) (person.id = dev.id) -> join based this condition
* you can allow to use the GeneratedVlaue for only one table

### one to one (Shared Primary Key && bi)
* it is like uni (the same)
* don't use the mappedby attribute for @OneToOne 
* this is the only this case that don't use the mappedby attribute

### many to many (bi, uni)
* it must be join by table
* (bi) have to use the "mappedby" attribute 

### embeddable
* use for mappe more than one class to only one table
* add @Embeddable for the classes that need to apped to specific Entity
* @Embeddable class doesn't annotate with @Entity or @Id
* add @Embedded to the refrence of the assosiation object



## inheretance
### inheretence strategy (how the inheretance classes will mapping into database)
* single table(there will be anew column which is the Discriminator whcih specify which table is this row) <br>
==> 
* table for concrete class (can't use the indentity id strategy)
* join tables (each table has an id)

## complex mapping
### secoundary table
* it is mean that we have one class that mapped to two tables in db
* it is done by using @SecondaryTalbe(name= "tableName")
* to assign the props to this table use @Column(table = "tableName")

### composition pk
* it mean that we have table with more than one pk
* it is done by embeddable where is the pk is the @EmbeddedId of the @Embeddable class with the two filed
* constraints => we need to use #EqualAndHashCode

### composition fk
* when the fk is the composist (there are composit pk use as fk)
* use  => `@JoinColumns({
            @JoinColumn(name = "emp_id1", referencedColumnName = "id1"),
            @JoinColumn(name = "emp_id2", referencedColumnName = "id2")
    })`


## query 
### query type 
* sql (table, columns)
* jpql (entitys, fields)
* criteria (java object)

### how to create and excute query
* query = entityManager.createQuery(jpql:"query", type.class): TypedQuery
* query.getResultList(); ==> it will return the query result mapped to object



















## annotations
* @Column(name, length, unique"true, false")
* @Temporal(TemporalType.Date) -> solve the date issue where remove the time from the date<br>
 -> but you can use the LocalDate datetype instead
* @Transient -> for not map this attribute into table column

## jpa vs jdbc