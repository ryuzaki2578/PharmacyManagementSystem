FROM java:8-jdk-alpine
EXPOSE 8081
COPY ./target/Medicine-Stock-MicroService-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch Medicine-Stock-MicroService-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","Medicine-Stock-MicroService-0.0.1-SNAPSHOT.jar"]
