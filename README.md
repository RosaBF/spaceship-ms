# spaceship-ms 🚀

### Introduction
This microservice provides RESTful APIs for managing spaceships. It leverages Spring Boot for a streamlined development experience and utilizes a database to persist spaceship data.

### Prerequisites
- Docker
- Docker Compose
### Getting Started
Clone the Repository:

```
git clone https://github.com/your-repo/spaceship-ms.git
```


### Build and Run with Docker Compose:

```
cd spaceship-ms
docker compose up 
```
This will build the Docker images for the microservice and the database, then start the containers in detached mode.

### API Endpoints
**Spaceship Management**

Create a spaceship:

#### POST /spaceships
Request body:

```json 
{
"name": "Serenity",
"captain": "Mal Reynolds"
}
```

Response:

```json
{
"id": 1,
"name": "Serenity",
"captain": "Mal Reynolds"
}
```

Get all spaceships:

#### GET /spaceships
Response:

```json
[
{
"id": 1,
"name": "Serenity",
"captain": "Mal Reynolds"
},
// ... other spaceships
]
```

Get a spaceship by ID:

#### GET /spaceships/{id}
Response:

```json
{
"id": 1,
"name": "Serenity",
"captain": "Mal Reynolds"
}
```

Update a spaceship:

#### PUT /spaceships/{id}
Request body:

```json
{
"name": "Serenity 2.0"
}
```

Response:

```json
{
"id": 1,
"name": "Serenity 2.0",
"captain": "Mal Reynolds"
}
```

Delete a spaceship:

#### DELETE /spaceships/{id}
Response: 204 No Content

### Database Initialization
The microservice uses a database to store spaceship data. You can initialize the database schema by running the following command:

```
docker-compose exec spaceship-ms java -jar target/spaceship-ms.jar
```

This will start the application, create the necessary database tables, and then exit.

Additional Notes
- The database connection details are configured in `application.yaml`.
- You can customize the API endpoints and data model to fit your specific requirements.

