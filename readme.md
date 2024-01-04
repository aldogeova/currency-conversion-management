
# Currency Conversion Management

## Description
The `currency-conversion-management` project, implemented using Spring Boot Reactive and Gradle,
is responsible for performing CRUD operations on currency exchange rates and synchronizing the
information with the Fixer service every 15 minutes. It's designed to be a robust and reliable
service within a microservices architecture, ensuring up-to-date currency exchange data across
applications.

## Prerequisites
To set up and run this project, you need to have the following installed:

- JDK 21
- Google Cloud SDK
- Gradle 8.5
- MongoDB installed and running on port 27017 with the username: `anavarrete` and password: `Navarrete11221`.

Ensure these are installed and properly configured on your machine before proceeding.

## Compilation Guide
To compile the project, execute the following steps in your terminal:

1. Navigate to the project's root directory.
2. Run the `gradle clean` command to remove any previous build outputs.
3. Execute the `gradle build` command to compile the project and create the build artifacts.

```shell
gradle clean
gradle build
```

After running these commands, the compiled JAR file will be available in the `build/libs` directory.

## Running the Application
To run the application, you should choose the appropriate properties file based on the environment
you are targeting:

- For local development, use `application-dev.yml`.
- For the QA environment, use `application-qa.yml`.
- For the production environment, use `application-prod.yml`.

Run the `CurrencyConversionManagementApplication` file with the desired profile active. For example,
to run the application in the development environment, use the following command:

```shell
java -Dspring.profiles.active=dev -jar build/libs/currency-conversion-management-0.0.1-SNAPSHOT.jar
```

Replace `dev` with `qa` or `prod` to run in the respective environments.

## Additional Notes
The project structure includes various packages tailored to the application's needs:

- `config` and `configuration` for application and security configurations.
- `controller` for handling incoming REST API requests.
- `dto` for Data Transfer Objects that carry data between processes.
- `repository` for data access layers, typically used to interact with the database.
- `schedule` for tasks that are to be executed periodically.
- `service` for business logic.

The `resources` directory contains different application property files for various environments
and a JSON file for the exchange rate which should be configured according to your specific Google
Cloud and MongoDB setup.

Remember to replace sensitive credentials before pushing to public repositories or sharing the project.


## Endpoint Documentation
The documentation for all the API endpoints is available at `{url_service}/swagger-ui.html`.
For instance, when running locally, you can access it via http://localhost:9090/swagger-ui.html.
