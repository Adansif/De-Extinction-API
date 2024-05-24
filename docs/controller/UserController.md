# UserController

The `UserController` class handles HTTP requests related to user and admin data in a game application. It provides endpoints for retrieving, creating, updating, and deleting users, as well as validating user credentials.

## Description

The `UserController` class is a Spring REST controller that manages endpoints for interacting with user and admin data. It autowires repositories to access the database, allowing it to fetch and update user and admin information. The class supports CORS, allowing requests from any origin.

## Class Structure

- `UserController` class:
  - Class variables:
    - `userRepository`: Repository for accessing user data.
    - `adminRepository`: Repository for accessing admin data.
  - Endpoints:
    - `getAllUsers()`: GET endpoint for retrieving all users.
    - `createUser(@RequestBody Map<String, Object> userRequest)`: POST endpoint for creating a new user.
    - `getUser(@PathVariable String userName)`: GET endpoint for retrieving a user by their name.
    - `getUserDetails(@RequestBody User userRequest)`: POST endpoint for validating user credentials.
    - `updateUser(@PathVariable(value = "id") Integer userId, @RequestBody User userRequest)`: PUT endpoint for updating a user's details.
    - `deleteUser(@PathVariable(value = "id") Integer userId)`: DELETE endpoint for deleting a user by their ID.

## Endpoints

### `getAllUsers()`

- **URL**: `/api/v1/users`
- **HTTP Method**: GET
- **Description**: Retrieves all users.
- **Response**: `List<Map<String, Object>>` containing a list of maps with user details (user ID, name, email, and admin status).

### `createUser(@RequestBody Map<String, Object> userRequest)`

- **URL**: `/api/v1/users`
- **HTTP Method**: POST
- **Description**: Creates a new user.
- **Request Body**: `Map<String, Object>` containing the new user's details (name, email, password, and optionally admin status).
- **Response**: `ResponseEntity<Map<String, Object>>` containing the new user's details (user ID, name, email, and admin status).

### `getUser(@PathVariable String userName)`

- **URL**: `/api/v1/users/{userName}`
- **HTTP Method**: GET
- **Description**: Retrieves a user by their name.
- **Path Variable**:
  - `userName`: The name of the user.
- **Response**: `User` object representing the user.

### `getUserDetails(@RequestBody User userRequest)`

- **URL**: `/api/v1/users/login`
- **HTTP Method**: POST
- **Description**: Validates user credentials and checks admin status.
- **Request Body**: `User` object containing the user's name and password.
- **Response**: `ResponseEntity<Map<String, Object>>` containing user details (name, password validation result, email, and admin status).

### `updateUser(@PathVariable(value = "id") Integer userId, @RequestBody User userRequest)`

- **URL**: `/api/v1/users/{id}`
- **HTTP Method**: PUT
- **Description**: Updates a user's details.
- **Path Variable**:
  - `id`: The ID of the user.
- **Request Body**: `User` object containing the updated user's details (name, email, and password).
- **Response**: `ResponseEntity<User>` containing the updated user's data.

### `deleteUser(@PathVariable(value = "id") Integer userId)`

- **URL**: `/api/v1/users/{id}`
- **HTTP Method**: DELETE
- **Description**: Deletes a user by their ID.
- **Path Variable**:
  - `id`: The ID of the user.
- **Response**: `Map<String, Boolean>` containing the deletion status.

## External Dependencies

- **Spring Framework**: The class uses Spring's REST controller and dependency injection features.
  - `import org.springframework.beans.factory.annotation.Autowired;`: For autowiring repositories.
  - `import org.springframework.http.HttpStatus;`: For specifying HTTP status codes.
  - `import org.springframework.http.ResponseEntity;`: For creating response entities.
  - `import org.springframework.web.bind.annotation.*;`: For defining REST endpoints and enabling CORS.
- **Java Collections Framework**: The class uses collections to handle data transformations.
  - `import java.util.ArrayList;`: For creating lists.
  - `import java.util.HashMap;`: For creating response data maps.
  - `import java.util.List;`: For handling lists of users.
  - `import java.util.Map;`: For creating response data maps.
- **Custom Exceptions**: The class uses a custom exception for resource not found errors.
  - `import com.deextinction.exception.ResourceNotFoundException;`: For handling cases where a user is not found.
