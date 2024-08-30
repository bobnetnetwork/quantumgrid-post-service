# Post Service

The **Post Service** handles the creation, editing, and management of posts in the QuantumGrid platform.

## Features

- CRUD operations for posts
- Tagging and categorization
- Draft and publish states
- SEO metadata management

## Technology Stack

- **Java**: Programming language
- **Spring Boot**: Microservice framework
- **PostgreSQL**: Relational database for storing post data

## Getting Started

### Prerequisites

- **Java 17** or higher
- **Maven** for build automation
- **PostgreSQL** installed and running

### Setup

1. Clone the repository:
    ```bash
    git clone https://github.com/bobnetnetwork/quantumgrid-post-service.git
    cd quantumgrid-post-service
    ```

2. Configure the database connection in `src/main/resources/application.properties`:
    ```
    spring.datasource.url=jdbc:postgresql://localhost:5432/quantumgrid
    spring.datasource.username=yourusername
    spring.datasource.password=yourpassword
    ```

3. Build the application:
    ```bash
    mvn clean install
    ```

4. Run the application:
    ```bash
    mvn spring-boot:run
    ```

### API Endpoints

- `POST /api/posts` - Create a new post
- `GET /api/posts` - List all posts
- `GET /api/posts/{id}` - Get post details
- `PUT /api/posts/{id}` - Update a post
- `DELETE /api/posts/{id}` - Delete a post

## Contributing

Please read the [CONTRIBUTING.md](https://github.com/bobnetnetwork/quantumgrid/blob/main/CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests.

## License

This project is licensed under the GPL-3.0 license - see the [LICENSE.md](https://github.com/bobnetnetwork/quantumgrid/blob/main/LICENSE.md) file for details.
