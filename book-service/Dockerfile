FROM maven:3.5-jdk-8 AS build
RUN apt-get update && apt-get -y install netcat && apt-get clean
COPY src /app/src  
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package -DskipTests

#Docker compose does not gaurantee order so wait 
# and let config server and eureka server start
COPY book_service_entry_point.sh /app

RUN chmod 755 /app/book_service_entry_point.sh
#ENTRYPOINT ["./app/book_service_entry_point.sh","java","-jar","/app/target/book-service-0.0.1-SNAPSHOT.jar"]  
EXPOSE 8082