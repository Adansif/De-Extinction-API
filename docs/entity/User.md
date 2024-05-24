# User Entity

The `User` class is an entity that represents a user in the system. It is mapped to the `users` table in the database and includes details about the user, their associated player and admin entities, name, password, and email.

## Description

The `User` class is annotated with JPA annotations to specify its mapping to a database table and its relationships with other entities. It includes fields for the user's ID, associated player, associated admin, name, password, and email, along with getter and setter methods for these fields. The class uses Jackson annotations to control JSON serialization.

## Class Structure

- `User` class:
  - Fields:
    - `userId`: The primary key of the user entity.
    - `player`: A one-to-one association with the `Player` entity.
    - `admin`: A one-to-one association with the `Admin` entity.
    - `name`: The name of the user.
    - `password`: The password of the user.
    - `email`: The email of the user.
  - Methods:
    - `getUserId()`: Returns the ID of the user.
    - `setUserId(int userId)`: Sets the ID of the user.
    - `getPlayer()`: Returns the associated player.
    - `setPlayer(Player player)`: Sets the associated player.
    - `getAdmin()`: Returns the associated admin.
    - `setAdmin(Admin admin)`: Sets the associated admin.
    - `getName()`: Returns the name of the user.
    - `setName(String name)`: Sets the name of the user.
    - `getPassword()`: Returns the password of the user.
    - `setPassword(String password)`: Sets the password of the user.
    - `getEmail()`: Returns the email of the user.
    - `setEmail(String email)`: Sets the email of the user.
    - `toString()`: Returns a string representation of the user object.

## Class Variables

- **`userId`**:
  - Type: `int`
  - Description: The primary key of the user entity.
  - Annotations:
    - `@Id`: Specifies the primary key of the entity.
    - `@GeneratedValue(strategy = GenerationType.IDENTITY)`: Specifies the generation strategy for the primary key.
    - `@Column(name = "user_id")`: Specifies the mapped column for the primary key.

- **`player`**:
  - Type: `Player`
  - Description: The player associated with the user.
  - Annotations:
    - `@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)`: Specifies a single-valued association to another entity.
    - `@JsonIgnore`: Indicates that the player field should be ignored by Jackson during serialization.

- **`admin`**:
  - Type: `Admin`
  - Description: The admin associated with the user.
  - Annotations:
    - `@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)`: Specifies a single-valued association to another entity.
    - `@JsonIgnore`: Indicates that the admin field should be ignored by Jackson during serialization.

- **`name`**:
  - Type: `String`
  - Description: The name of the user.
  - Annotations:
    - `@Column(unique = true)`: Specifies the mapped column for this field and ensures it is unique.

- **`password`**:
  - Type: `String`
  - Description: The password of the user.
  - Annotations:
    - `@Column`: Specifies the mapped column for this field.

- **`email`**:
  - Type: `String`
  - Description: The email of the user.
  - Annotations:
    - `@Column(unique = true)`: Specifies the mapped column for this field and ensures it is unique.

## Methods

- **`getUserId()`**:
  - Returns: `int`
  - Description: Getter method for `userId`.

- **`setUserId(int userId)`**:
  - Parameters: `int userId`
  - Description: Setter method for `userId`.

- **`getPlayer()`**:
  - Returns: `Player`
  - Description: Getter method for `player`.

- **`setPlayer(Player player)`**:
  - Parameters: `Player player`
  - Description: Setter method for `player`.

- **`getAdmin()`**:
  - Returns: `Admin`
  - Description: Getter method for `admin`.

- **`setAdmin(Admin admin)`**:
  - Parameters: `Admin admin`
  - Description: Setter method for `admin`.

- **`getName()`**:
  - Returns: `String`
  - Description: Getter method for `name`.

- **`setName(String name)`**:
  - Parameters: `String name`
  - Description: Setter method for `name`.

- **`getPassword()`**:
  - Returns: `String`
  - Description: Getter method for `password`.

- **`setPassword(String password)`**:
  - Parameters: `String password`
  - Description: Setter method for `password`.

- **`getEmail()`**:
  - Returns: `String`
  - Description: Getter method for `email`.

- **`setEmail(String email)`**:
  - Parameters: `String email`
  - Description: Setter method for `email`.

- **`toString()`**:
  - Returns: `String`
  - Description: Overrides the `toString` method to provide a string representation of the `User` object.

## External Dependencies

- **Jakarta Persistence API**: The class uses JPA annotations for ORM (Object-Relational Mapping).
  - `import jakarta.persistence.Entity;`: Specifies that the class is an entity.
  - `import jakarta.persistence.GeneratedValue;`: Provides the specification of generation strategies for the primary keys.
  - `import jakarta.persistence.GenerationType;`: Specifies the generation strategy type.
  - `import jakarta.persistence.Id;`: Specifies the primary key of an entity.
  - `import jakarta.persistence.OneToOne;`: Specifies a single-valued association to another entity.
  - `import jakarta.persistence.Table;`: Specifies the database table to which the entity is mapped.
  - `import jakarta.persistence.Column;`: Specifies the mapped column for fields.
  - `import jakarta.persistence.CascadeType;`: Specifies the types of operations that should be cascaded to the associated entity.

- **Jackson**: The class uses Jackson annotations for controlling JSON serialization.
  - `import com.fasterxml.jackson.annotation.JsonIgnore;`: Indicates that the annotated field should be ignored by Jackson during serialization.
