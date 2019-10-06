FROM maven:3.5-jdk-8 AS build  
COPY src /app/src  
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package -DskipTests
# RUN ls -lrt app/target

ENTRYPOINT ["java","-jar","/app/target/config-server-0.0.1-SNAPSHOT.jar"]  
# RUN mvn spring-boot:run 
EXPOSE 8888