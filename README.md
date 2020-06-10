[![Build Status](https://travis-ci.org/fredmosc-dev/spring-boot-authentication.svg?branch=development)](https://travis-ci.org/fredmosc-dev/spring-boot-authentication)

# Authentication & Authorization example
This project proposal is to enable Spring Security in any kind of projects with Spring Boot.

This project has two pre-configured profiles: *development* and *production*.

At development profile only *H2 Database* is necessary.

To change profile, just create an environment variable **_API_ENV_** with production value.

For correct operation with production environment variable, you need to use a Postgres Database.


To make it easier, the project contains a docker-compose.yaml file to upload Postgres, feel free to change it to your preferred database.
Just run:
```
$ docker-compose up -d
```

The structure of the JWT Token generated:

```
{
    "sub": "username",
      "roles": [
        {
          "authority": "USER"
        }
      ]
}
```

To test the request, you make a *POST* request to:
```
*ADMIN ROLE*
curl --location --request POST 'localhost:8090/api/auth' \
--header 'Content-Type: application/json' \
--data-raw '{
	"userName": "admin",
	"password": "admin"
}'

*USER ROLE*
curl --location --request POST 'localhost:8090/api/auth' \
--header 'Content-Type: application/json' \
--data-raw '{
	"userName": "user",
	"password": "admin"
}'
```

Endpoints:

```
/api/hello - Any kind of authenticated users
/api/hello/oi - Only users with USER role can acess
```


Feel free to contribute for the project.

If you have any questions, open an issue or fork this project and send a pull request.