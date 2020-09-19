# quarkus-dbclient project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

This sample project for testing hibernate-panache and rest endpoint in quarkus. 
The result of my experiment is exceed my expectation with average request response under 10 ms 
with my current hardware.  

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

Sample request from employees DB (examples DB from MySQL) :

```
curl --location --request GET 'http://localhost:8080/api/employees/10015' \
--header 'Accept: application/json' \
--data-raw ''
```

Response : 

```
{
    "birthDate": "1959-08-19",
    "empNo": 10015,
    "firstName": "Guoxiang",
    "gender": "M",
    "hireDate": "1987-07-02",
    "lastName": "Nooteboom"
}
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `quarkus-dbclient-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/quarkus-dbclient-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/quarkus-dbclient-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.