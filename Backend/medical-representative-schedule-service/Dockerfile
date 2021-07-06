FROM java:8-jdk-alpine
EXPOSE 8082
COPY ./target/medical-representative-schedule-service-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch medical-representative-schedule-service-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","medical-representative-schedule-service-0.0.1-SNAPSHOT.jar"]
