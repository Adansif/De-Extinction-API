# Admin Entity

The `Admin` class is an entity that represents an admin in the system. It is mapped to the `admins` table in the database and includes details about the admin and their associated user.

## Description

The `Admin` class is annotated with JPA annotations to specify its mapping to a database table and its relationships with other entities. It includes fields for the admin's ID and the associated user, along with getter and setter methods for these fields.

## Class Structure

- `Admin` class:
  - Fields:
    - `adminId`: The primary key of the admin entity.
    - `user`: A one-to-one association with the `User` entity.
  - Methods:
    - `getAdminId()`: Returns the ID of the admin.
    - `setAdminId(int adminId)`: Sets the ID of the admin.
    - `getUser()`: Returns the associated user.
    - `setUser(User user)`: Sets the associated user.
    - `toString()`: Returns a string representation of the admin object.

## Class Variables

- **`adminId`**:
  - Type: `int`
  - Description: The primary key of the admin entity.
  - Annotations:
    - `@Id`: Specifies the primary key of the entity.
    - `@GeneratedValue(strategy = GenerationType.IDENTITY)`: Specifies the generation strategy for the primary key.

- **`user`**:
  - Type: `User`
  - Description: The user associated with the admin.
  - Annotations:
    - `@OneToOne`: Specifies a single-valued association to another entity.
    - `@JoinColumn(name = "user_id")`: Specifies the mapped column for the entity association.

## Methods

- **`getAdminId()`**:
  - Returns: `int`
  - Description: Getter method for `adminId`.

- **`setAdminId(int adminId)`**:
  - Parameters: `int adminId`
  - Description: Setter method for `adminId`.

- **`getUser()`**:
  - Returns: `User`
  - Description: Getter method for `user`.

- **`setUser(User user)`**:
  - Parameters: `User user`
  - Description: Setter method for `user`.

- **`toString()`**:
  - Returns: `String`
  - Description: Overrides the `toString` method to provide a string representation of the `Admin` object.

## External Dependencies

- **Jakarta Persistence API**: The class uses JPA annotations for ORM (Object-Relational Mapping).
  - `import jakarta.persistence.Entity;`: Specifies that the class is an entity.
  - `import jakarta.persistence.GeneratedValue;`: Provides the specification of generation strategies for the primary keys.
  - `import jakarta.persistence.GenerationType;`: Specifies the generation strategy type.
  - `import jakarta.persistence.Id;`: Specifies the primary key of an entity.
  - `import jakarta.persistence.JoinColumn;`: Specifies the mapped column for the entity association.
  - `import jakarta.persistence.OneToOne;`: Specifies a single-valued association to another entity.
  - `import jakarta.persistence.Table;`: Specifies the database table to which the entity is mapped.
