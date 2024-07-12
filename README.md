# Library Management System
This project is a comprehensive Library Management System designed to manage books, authors, categories, publishers, and book borrowings. The system provides RESTful API endpoints to perform CRUD operations and manage library resources effectively.

## Endpoints

### AuthorController

| Operation          | Endpoint                | Method | Description                                    |
|--------------------|-------------------------|--------|------------------------------------------------|
| Save Author        | `/v2/authors`           | POST   | Creates a new author.                          |
| Get Author by ID   | `/v2/authors/{id}`      | GET    | Retrieves details of an author by ID.          |
| Update Author      | `/v2/authors`           | PUT    | Updates details of an existing author.         |
| Delete Author      | `/v2/authors/{id}`      | DELETE | Deletes an author by ID.                       |

### BookBorrowingController

| Operation             | Endpoint                   | Method | Description                                    |
|-----------------------|----------------------------|--------|------------------------------------------------|
| Save Book Borrowing   | `/v2/bookborrowings`       | POST   | Creates a new book borrowing record.           |
| Get Book Borrowing by ID | `/v2/bookborrowings/{id}` | GET    | Retrieves details of a book borrowing by ID.   |
| Update Book Borrowing | `/v2/bookborrowings`       | PUT    | Updates details of an existing book borrowing. |
| Delete Book Borrowing | `/v2/bookborrowings/{id}`  | DELETE | Deletes a book borrowing record by ID.         |

### BookController

| Operation          | Endpoint           | Method | Description                                    |
|--------------------|--------------------|--------|------------------------------------------------|
| Save Book          | `/v2/books`        | POST   | Creates a new book.                            |
| Get Book by ID     | `/v2/books/{id}`   | GET    | Retrieves details of a book by ID.             |
| Update Book        | `/v2/books`        | PUT    | Updates details of an existing book.           |
| Delete Book        | `/v2/books/{id}`   | DELETE | Deletes a book by ID.                          |

### CategoryController

| Operation          | Endpoint             | Method | Description                                    |
|--------------------|----------------------|--------|------------------------------------------------|
| Save Category      | `/v2/categories`     | POST   | Creates a new category.                        |
| Get Category by ID | `/v2/categories/{id}`| GET    | Retrieves details of a category by ID.         |
| Update Category    | `/v2/categories`     | PUT    | Updates details of an existing category.       |
| Delete Category    | `/v2/categories/{id}`| DELETE | Deletes a category by ID.                      |

### PublisherController
| Operation          | Endpoint              | Method | Description                                    |
|--------------------|-----------------------|--------|------------------------------------------------|
| Save Publisher     | `/v2/publishers`      | POST   | Creates a new publisher.                       |
| Get Publisher by ID| `/v2/publishers/{id}` | GET    | Retrieves details of a publisher by ID.        |
| Update Publisher   | `/v2/publishers`      | PUT    | Updates details of an existing publisher.      |
| Delete Publisher   | `/v2/publishers/{id}` | DELETE | Deletes a publisher by ID.                     |

## Technologies Used

- **Java**: The core programming language used for developing the application.
- **Spring Boot**: Framework used for building the backend services.
- **Hibernate**: ORM tool for database operations.
- **PostgreSQL**: The relational database used for data storage.
- **ModelMapper**: Used for object mapping.
- **Jakarta Validation**: For validating API request bodies.

## Installation

1. **Clone the repository**:

   ```bash
   git clone https://github.com/ebrucihan/Library-Management-System-RestAPI.git

