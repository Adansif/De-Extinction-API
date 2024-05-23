# PlayerRepository

The `PlayerRepository` interface is a Spring Data repository for performing CRUD operations on the `Player` entity. It extends the `JpaRepository` interface provided by Spring Data JPA.

## Description

The `PlayerRepository` interface provides methods for interacting with the `Player` entity in the database. It includes standard CRUD operations inherited from `JpaRepository` and custom query methods defined by the interface.

## Interface Structure

- `PlayerRepository` interface:
  - Extends `JpaRepository<Player, Integer>`.
  - Custom query methods:
    - `findTop3ByOrderByScoreDesc()`: Finds the top 3 players ordered by their score in descending order.
    - `findByOrderByScoreDesc()`: Finds all players ordered by their score in descending order.

## Methods

### Inherited from `JpaRepository`

The `PlayerRepository` inherits several methods from the `JpaRepository` interface, including but not limited to:

- `save(S entity)`: Saves a given entity.
- `findById(ID id)`: Retrieves an entity by its ID.
- `findAll()`: Retrieves all entities.
- `deleteById(ID id)`: Deletes an entity by its ID.

### Custom Query Methods

- **`findTop3ByOrderByScoreDesc()`**:
  - Returns: `List<Player>`
  - Description: Finds the top 3 players ordered by their score in descending order.

- **`findByOrderByScoreDesc()`**:
  - Returns: `List<Player>`
  - Description: Finds all players ordered by their score in descending order.

## External Dependencies

- **Spring Data JPA**: The interface uses Spring Data JPA for repository functionality.
  - `import org.springframework.data.jpa.repository.JpaRepository;`: For extending the `JpaRepository` interface.
  - `import org.springframework.stereotype.Repository;`: For indicating that the interface is a Spring Data repository.

- **Player Entity**: The interface works with the `Player` entity.
  - `import com.deextinction.entity.Player;`: For accessing the `Player` entity.
