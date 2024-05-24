# De-Extinction API

This project provides a backend API for both the De-Extinction game and the web, supporting user authentication, score management, and admin functionalities. The API is built using Spring Boot and connects to a relational database to manage data.

## Project Description

The De-Extinction API is designed to handle user and player data, including login functionality, score updates, and retrieving top scores. It also includes admin management capabilities. This API ensures that the game and the web can authenticate users, store and update their scores, and provide a leaderboard.

## Project Objectives

- Implement user authentication and validation.
- Manage player scores, including retrieving top scores and updating scores.
- Provide admin functionalities to manage user and game data.
- Ensure secure and efficient handling of HTTP requests and responses.

## Project Structure

The project is organized into the following components:

- **Entities**:
  - `Admin`: Represents admin data in the system.
  - `Player`: Represents player data, including scores and purchase status.
  - `User`: Represents user data, including authentication details and associations with players and admins.

- **Repositories**:
  - `AdminRepository`: Interface for performing CRUD operations on the `Admin` entity.
  - `PlayerRepository`: Interface for performing CRUD operations on the `Player` entity and custom queries for scores.
  - `UserRepository`: Interface for performing CRUD operations on the `User` entity and custom queries for user authentication.

- **Controllers**:
  - `PlayerController`: Handles HTTP requests related to player data, including retrieving and updating scores.
  - `UserController`: Handles HTTP requests related to user data, including authentication and user management.

- **Services**:
  - `OneToOneService`: Provides methods to save `User`, `Player`, and `Admin` entities to the database, managing one-to-one relationships between them.

## External Dependencies

- **Spring Boot**: For building the RESTful web service.
- **Spring Data JPA**: For data access and repository management.
- **Jakarta Persistence API**: For ORM (Object-Relational Mapping).
- **Jackson**: For JSON serialization and deserialization.

## Documentation

- [Admin Entity](./docs/entity/Admin.md)
- [Player Entity](./docs/entity/Player.md)
- [User Entity](./docs/entity/User.md)
- [AdminRepository](./docs/repository/AdminRepository.md)
- [PlayerRepository](./docs/repository/PlayerRepository.md)
- [UserRepository](./docs/repository/UserRepository.md)
- [PlayerController](./docs/controller/PlayerController.md)
- [UserController](./docs/controller/UserController.md)
- [OneToOneService](./docs/service/OneToOneService.md)
