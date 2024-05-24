# UserRepository

The `UserRepository` interface is a Spring Data repository for performing CRUD operations on the `User` entity. It extends the `JpaRepository` interface provided by Spring Data JPA.

## Description

The `UserRepository` interface provides methods for interacting with the `User` entity in the database. It includes standard CRUD operations inherited from `JpaRepository` and a custom query method defined by the interface.

## Interface Structure

- `UserRepository` interface:
  - Extends `JpaRepository<User, Integer>`.
  - Custom query methods:
    - `findByName(String name)`: Finds a `User` by their name using a JPQL query.

## Methods

### Inherited from `JpaRepository`

The `UserRepository` inherits several methods from the `JpaRepository` interface, including but not limited to:

- `save(S entity)`: Saves a given entity.
- `findById(ID id)`: Retrieves an entity by its ID.
- `findAll()`: Retrieves all entities.
- `deleteById(ID id)`: Deletes an entity by its ID.

### Custom Query Methods

- **`findByName(String name)`**:
  - Parameters: `String name`
  - Returns: `User`
  - Description: Finds a `User` by their name using a JPQL query.
  - Annotations:
    - `@Query("select u from User u where u.name = ?1")`: Specifies the JPQL query to be used.

## External Dependencies

- **Spring Data JPA**: The interface uses Spring Data JPA for repository functionality.
  - `import org.springframework.data.jpa.repository.JpaRepository;`: For extending the `JpaRepository` interface.
  - `import org.springframework.data.jpa.repository.Query;`: For defining custom JPQL queries.
  - `import org.springframework.stereotype.Repository;`: For indicating that the interface is a Spring Data repository.

- **User Entity**: The interface works with the `User` entity.
  - `import com.deextinction.entity.User;`: For accessing the `User` entity.