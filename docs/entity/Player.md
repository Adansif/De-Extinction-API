# Player Entity

The `Player` class is an entity that represents a player in the system. It is mapped to the `players` table in the database and includes details about the player, their associated user, purchase status, and score.

## Description

The `Player` class is annotated with JPA annotations to specify its mapping to a database table and its relationships with other entities. It includes fields for the player's ID, associated user, purchase status, and score, along with getter and setter methods for these fields.

## Class Structure

- `Player` class:
  - Fields:
    - `playerId`: The primary key of the player entity.
    - `user`: A one-to-one association with the `User` entity.
    - `isPurchased`: A boolean indicating if the player has made a purchase.
    - `score`: An integer representing the player's score.
  - Methods:
    - `getPlayerId()`: Returns the ID of the player.
    - `setPlayerId(int playerId)`: Sets the ID of the player.
    - `getUser()`: Returns the associated user.
    - `setUser(User user)`: Sets the associated user.
    - `isPurchased()`: Returns the purchase status of the player.
    - `setPurchased(boolean isPurchased)`: Sets the purchase status of the player.
    - `getScore()`: Returns the player's score.
    - `setScore(int score)`: Sets the player's score.
    - `toString()`: Returns a string representation of the player object.

## Class Variables

- **`playerId`**:
  - Type: `int`
  - Description: The primary key of the player entity.
  - Annotations:
    - `@Id`: Specifies the primary key of the entity.
    - `@GeneratedValue(strategy = GenerationType.IDENTITY)`: Specifies the generation strategy for the primary key.
    - `@Column(name = "player_id")`: Specifies the mapped column for the primary key.

- **`user`**:
  - Type: `User`
  - Description: The user associated with the player.
  - Annotations:
    - `@OneToOne`: Specifies a single-valued association to another entity.
    - `@JoinColumn(name = "user_id")`: Specifies the mapped column for the entity association.

- **`isPurchased`**:
  - Type: `boolean`
  - Description: Indicates if the player has made a purchase.
  - Annotations:
    - `@Column`: Specifies the mapped column for this field.

- **`score`**:
  - Type: `int`
  - Description: The player's score.
  - Annotations:
    - `@Column`: Specifies the mapped column for this field.

## Methods

- **`getPlayerId()`**:
  - Returns: `int`
  - Description: Getter method for `playerId`.

- **`setPlayerId(int playerId)`**:
  - Parameters: `int playerId`
  - Description: Setter method for `playerId`.

- **`getUser()`**:
  - Returns: `User`
  - Description: Getter method for `user`.

- **`setUser(User user)`**:
  - Parameters: `User user`
  - Description: Setter method for `user`.

- **`isPurchased()`**:
  - Returns: `boolean`
  - Description: Getter method for `isPurchased`.

- **`setPurchased(boolean isPurchased)`**:
  - Parameters: `boolean isPurchased`
  - Description: Setter method for `isPurchased`.

- **`getScore()`**:
  - Returns: `int`
  - Description: Getter method for `score`.

- **`setScore(int score)`**:
  - Parameters: `int score`
  - Description: Setter method for `score`.

- **`toString()`**:
  - Returns: `String`
  - Description: Overrides the `toString` method to provide a string representation of the `Player` object.

## External Dependencies

- **Jakarta Persistence API**: The class uses JPA annotations for ORM (Object-Relational Mapping).
  - `import jakarta.persistence.Entity;`: Specifies that the class is an entity.
  - `import jakarta.persistence.GeneratedValue;`: Provides the specification of generation strategies for the primary keys.
  - `import jakarta.persistence.GenerationType;`: Specifies the generation strategy type.
  - `import jakarta.persistence.Id;`: Specifies the primary key of an entity.
  - `import jakarta.persistence.JoinColumn;`: Specifies the mapped column for the entity association.
  - `import jakarta.persistence.OneToOne;`: Specifies a single-valued association to another entity.
  - `import jakarta.persistence.Table;`: Specifies the database table to which the entity is mapped.
  - `import jakarta.persistence.Column;`: Specifies the mapped column for fields.
