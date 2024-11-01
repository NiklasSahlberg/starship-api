# Starship API

A Kotlin Spring Boot application that provides a RESTful API for managing and retrieving information about various starships from the Star Wars universe. This API allows users to fetch the top ten most expensive starships and interact with spaceship data.

## Features

- Fetch the top ten most expensive starships.
- Return structured starship data in JSON format.

## Technologies Used

- **Kotlin**
- **Spring Boot**
- **JUnit**
- **Mockito Kotlin**

## API Endpoints

### Get Top 10 Most Expensive Starships

- **Endpoint**: `GET /api/v1/starships/most-expensive`
- **Response**: 
  - Status: `200 OK` - Returns a list of the top ten most expensive starships.
  - Status: `204 No Content` - No starships available.
 
# How to Run the Starship Application in IntelliJ IDEA

Follow this guide to set up and run the Kotlin Spring Boot application with Gradle using IntelliJ IDEA.

## Prerequisites
- **IntelliJ IDEA** (Community or Ultimate Edition)
- **JDK 17 or higher** (IntelliJ IDEA can manage this for you)

### Setup

1. **Open the project**:
   - Launch IntelliJ IDEA.
   - Clone the project or download the zip file to open the project.

2. **Import the Gradle project**:
   - If prompted, select **Import Gradle project**. IntelliJ will automatically download the necessary dependencies and configure the project settings.

3. **Select the Right JDK**:
   - The project requires **JDK 17 or higher**.
   - In IntelliJ, go to **File** > **Project Structure** > **Project**.
   - Under **Project SDK**, select any **Java 17** version. If it's not available:
     - Click **Add SDK** > **Download JDK**.
     - Choose version **any 17 version** and download it directly through IntelliJ.
   - Alternatively, if you have JDK installed manually, make sure your `JAVA_HOME` environment variable is set accordingly.

4. **Run the application**:
   - Open the `StarshipApplication.kt` file located in `src/main/kotlin/com/example/starship`.
   - Right-click on the file and select **Run 'StarshipApplication.kt'** to start the application.
