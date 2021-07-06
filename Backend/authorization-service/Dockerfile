FROM java:8-jdk-alpine
EXPOSE 8084
COPY ./target/authorization-service-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch authorization-service-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","authorization-service-0.0.1-SNAPSHOT.jar"]
