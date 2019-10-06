FROM maven:3.5-jdk-8 AS build

# get netcat for waiting script
RUN apt-get update && apt-get -y install netcat && apt-get clean
COPY src /app/src  
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package -DskipTests
RUN ls -lrt app/target

#Docker compose does not gaurantee order so wait 
# and let config server and eureka server start
COPY author_service_entry_point.sh /app

RUN chmod 755 /app/author_service_entry_point.sh
#ENTRYPOINT ["java","-jar","/app/target/author-service-0.0.1-SNAPSHOT.jar"]  
EXPOSE 8081