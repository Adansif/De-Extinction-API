# AdminRepository

The `AdminRepository` interface is a Spring Data repository for performing CRUD operations on the `Admin` entity. It extends the `JpaRepository` interface provided by Spring Data JPA.

## Description

The `AdminRepository` interface provides methods for interacting with the `Admin` entity in the database. It includes standard CRUD operations inherited from `JpaRepository` and custom query methods defined by the interface.

## Interface Structure

- `AdminRepository` interface:
  - Extends `JpaRepository<Admin, Integer>`.
  - Custom query methods:
    - `findByUserName(String name)`: Finds an `Admin` by the associated `User`'s name.

## Methods

### Inherited from `JpaRepository`

The `AdminRepository` inherits several methods from the `JpaRepository` interface, including but not limited to:

- `save(S entity)`: Saves a given entity.
- `findById(ID id)`: Retrieves an entity by its ID.
- `findAll()`: Retrieves all entities.
- `deleteById(ID id)`: Deletes an entity by its ID.

### Custom Query Methods

- **`findByUserName(String name)`**:
  - Parameters: `String name`
  - Returns: `Admin`
  - Description: Finds an `Admin` by the associated `User`'s name.

## External Dependencies

- **Spring Data JPA**: The interface uses Spring Data JPA for repository functionality.
  - `import org.springframework.data.jpa.repository.JpaRepository;`: For extending the `JpaRepository` interface.
  - `import org.springframework.stereotype.Repository;`: For indicating that the interface is a Spring Data repository.

- **Admin Entity**: The interface works with the `Admin` entity.
  - `import com.deextinction.entity.Admin;`: For accessing the `Admin` entity.
