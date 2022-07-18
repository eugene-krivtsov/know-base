# Backend application KnowBase for saving knowledge locally

###
- JAVA 17
- SPRING WEB
- SPRING JPA
- SPRING SECURITY

For application need EnvFile by Borys Pierov plugin and .env file which contains:
```dotenv
IP_ADDRESS=host.docker.internal

APP_PORT=9000
APP_URL=http://localhost:${APP_PORT}

API_PATH=/

POSTGRES_VERSION=14
POSTGRES_PORT=[your postgres port here]
POSTGRES_SCHEMA=kbase
POSTGRES_DB=kbase
POSTGRES_URL=jdbc:postgresql://${IP_ADDRESS}:${POSTGRES_PORT}/${POSTGRES_DB}
POSTGRES_USER=[your postgres user here]
POSTGRES_PASSWORD=[your postgres password here]

LIQUIBASE_VERSION=4.11

GRAFANA_VERSION=9.0.2
GRAFANA_USER=[your grafana user here]
GRAFANA_PASSWORD=[your grafana password here]
GRAFANA_PORT=[your grafana port here]

PROMETHEUS_VERSION=v2.36.2
PROMETHEUS_PORT=[your prometheus port here]

PASSWORD_SALT=[your salt here]
JWT_SIGNING_KEY=[your signing key here]
```
For successfully running liquibase need to append in db/liquibase.properties:
```dotenv
username: [your postgres user here]
password: [your postgres password here]
```
For running application need to build:
```dotenv
mvn install -DskipTests
```
For running application in Docker need to:
```dotenv
docker compose up
```

Swagger documentation http://localhost:9000/swagger-ui/index.html
