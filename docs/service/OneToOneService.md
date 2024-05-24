# OneToOneService

The `OneToOneService` class is a Spring service component that provides methods to save `User`, `Player`, and `Admin` entities to the database. It leverages Spring's dependency injection to interact with the respective repositories.

## Description

The `OneToOneService` class is annotated with `@Service`, indicating that it is a service component in the Spring framework. It provides methods to save `User`, `Player`, and `Admin` entities using the corresponding repositories. The service class is designed to manage one-to-one relationships between these entities.

## Class Structure

- `OneToOneService` class:
  - Methods:
    - `saveUser(User user)`: Saves a `User` entity to the database.
    - `savePlayer(Player player)`: Saves a `Player` entity to the database.
    - `saveAdmin(Admin admin)`: Saves an `Admin` entity to the database.

## Methods

### `saveUser(User user)`

- **Description**: Saves a `User` entity to the database.
- **Parameters**: `User user` - The `User` entity to be saved.
- **Return Type**: `void`

### `savePlayer(Player player)`

- **Description**: Saves a `Player` entity to the database.
- **Parameters**: `Player player` - The `Player` entity to be saved.
- **Return Type**: `void`

### `saveAdmin(Admin admin)`

- **Description**: Saves an `Admin` entity to the database.
- **Parameters**: `Admin admin` - The `Admin` entity to be saved.
- **Return Type**: `void`

## External Dependencies

- **Spring Framework**: The class uses Spring's dependency injection and service component features.
  - `import org.springframework.beans.factory.annotation.Autowired;`: For autowiring repositories.
  - `import org.springframework.stereotype.Service;`: For indicating that the class is a Spring service component.

- **Repositories**: The class interacts with the repositories for `User`, `Player`, and `Admin` entities.
  - `import com.deextinction.repository.UserRepository;`: For accessing `User` data.
  - `import com.deextinction.repository.PlayerRepository;`: For accessing `Player` data.
  - `import com.deextinction.repository.AdminRepository;`: For accessing `Admin` data.

- **Entities**: The class works with `User`, `Player`, and `Admin` entities.
  - `import com.deextinction.entity.User;`: For the `User` entity.
  - `import com.deextinction.entity.Player;`: For the `Player` entity.
  - `import com.deextinction.entity.Admin;`: For the `Admin` entity.

## Annotations

- **`@Service`**:
  - Description: Indicates that the class is a Spring service component.
- **`@Autowired`**:
  - Description: Enables dependency injection for the repositories.
