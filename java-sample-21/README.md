# ArtisanTek Java Sample - May2025 Batch

A beautiful Java 21 web application built with Spring Boot that displays ArtisanTek branding with modern UI design.

## Features

- ✨ Beautiful gradient background with animations
- 🎨 Modern glassmorphism design
- 📱 Responsive layout for mobile and desktop
- 🚀 Java 21 with Spring Boot 3.2
- 🎯 Lightweight and fast

## Prerequisites

- Java 21 JDK
- Maven 3.6+

## Build Instructions

```bash
# Navigate to the project directory
cd jenkins/java-sample-21

# Clean and build the project
mvn clean package

# The JAR file will be created in the target directory
# File name: java-sample-21-1.0.0.jar
```

## Run Instructions

```bash
# Run the application
java -jar target/java-sample-21-1.0.0.jar

# The application will start on port 5000
# Open your browser and go to: http://localhost:5000
```

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/artisantek/
│   │       ├── ArtisanTekApplication.java
│   │       └── controller/
│   │           └── HomeController.java
│   └── resources/
│       ├── application.properties
│       └── templates/
│           └── index.html
└── pom.xml
```

## Technology Stack

- Java 21
- Spring Boot 3.2.0
- Maven
- Thymeleaf (for templating)
- HTML5 & CSS3 with animations

## Quick Start

1. Make sure Java 21 is installed
2. Run `mvn clean package`
3. Run `java -jar target/java-sample-21-1.0.0.jar`
4. Visit `http://localhost:5000`

Enjoy your beautiful ArtisanTek web application! 🎉 