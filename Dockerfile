FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

# Skopiuj pliki projektu
COPY mvnw .
COPY .mvn .mvn

RUN chmod +x mvnw

COPY pom.xml .
COPY src src

# Zbuduj aplikację
RUN ./mvnw package -DskipTests

# Utwórz obraz docelowy
FROM eclipse-temurin:17-jre

WORKDIR /app

# Skopiuj zbudowany jar z etapu budowania
COPY --from=build /app/target/*.jar app.jar

# Odsłoń port, na którym będzie działać aplikacja
EXPOSE 8080

# Uruchom aplikację
ENTRYPOINT ["java", "-jar", "app.jar"]
