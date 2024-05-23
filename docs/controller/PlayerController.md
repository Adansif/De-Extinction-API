# PlayerController

The `PlayerController` class handles HTTP requests related to player and user data in a game application. It provides endpoints for retrieving player scores, validating user credentials, and updating user scores.

## Description

The `PlayerController` class is a Spring REST controller that manages endpoints for interacting with player and user data. It autowires repositories to access the database, allowing it to fetch and update player and user information. The class supports CORS, allowing requests from any origin.

## Class Structure

- `PlayerController` class:
  - Class variables:
    - `playerRepository`: Repository for accessing player data.
    - `userRepository`: Repository for accessing user data.
  - Endpoints:
    - `getAllUsersScore()`: GET endpoint for retrieving all users' scores.
    - `getTop3UsersScore()`: GET endpoint for retrieving the top 3 users' scores.
    - `getUserDetails(@RequestBody User userRequest)`: POST endpoint for validating user credentials.
    - `updateUser(@PathVariable(value = "name") String name, @PathVariable(value = "score") int score)`: PUT endpoint for updating a user's score if it's higher than the current score.

## Endpoints

### `getAllUsersScore()`

- **URL**: `/api/v1/players/scores`
- **HTTP Method**: GET
- **Description**: Retrieves all users' scores, sorted in descending order.
- **Response**: `ResponseEntity<List<Map<String, Object>>>` containing a list of maps with player names and scores.

### `getTop3UsersScore()`

- **URL**: `/api/v1/players/topscores`
- **HTTP Method**: GET
- **Description**: Retrieves the top 3 users' scores, sorted in descending order.
- **Response**: `ResponseEntity<List<Map<String, Object>>>` containing a list of maps with the top 3 player names and scores.

### `getUserDetails(@RequestBody User userRequest)`

- **URL**: `/api/v1/players/login`
- **HTTP Method**: POST
- **Description**: Validates user credentials and checks player status.
- **Request Body**: `User` object containing the user's name and password.
- **Response**: `ResponseEntity<Map<String, Object>>` containing user details, including name, password validation result, and player status.

### `updateUser(@PathVariable(value = "name") String name, @PathVariable(value = "score") int score)`

- **URL**: `/api/v1/players/{name}/{score}`
- **HTTP Method**: PUT
- **Description**: Updates a user's score if the new score is higher than the current score.
- **Path Variables**:
  - `name`: The name of the user.
  - `score`: The new score to update.
- **Response**: `ResponseEntity<User>` indicating the result of the update operation. Returns `HttpStatus.OK` if the score is updated, `HttpStatus.NO_CONTENT` if the new score is not higher, and `HttpStatus.NOT_FOUND` if the user does not exist.

## External Dependencies

- **Spring Framework**: The class uses Spring's REST controller and dependency injection features.
  - `import org.springframework.beans.factory.annotation.Autowired;`: For autowiring repositories.
  - `import org.springframework.http.HttpStatus;`: For specifying HTTP status codes.
  - `import org.springframework.http.ResponseEntity;`: For creating response entities.
  - `import org.springframework.web.bind.annotation.*;`: For defining REST endpoints and enabling CORS.
- **Java Collections Framework**: The class uses collections to handle data transformations.
  - `import java.util.HashMap;`: For creating response data maps.
  - `import java.util.List;`: For handling lists of players.
  - `import java.util.Map;`: For creating response data maps.
  - `import java.util.stream.Collectors;`: For transforming lists of players into response data maps.
