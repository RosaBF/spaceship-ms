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
mvn clean install
docker build -t spaceship-ms .
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
"model": "X-582"
}
```

Response:

```json
{
"id": 1,
"name": "Serenity",
"model": "X-582"
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
"model": "X-582"
}
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
"model": "X-582"
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
"model": "X-582"
}
```

Delete a spaceship:

#### DELETE /spaceships/{id}
Response: 204 No Content


Additional Notes
- The database connection details are configured in `application.yaml`.
- You can customize the API endpoints and data model to fit your specific requirements.

