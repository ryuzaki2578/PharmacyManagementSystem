FROM java:8-jdk-alpine
EXPOSE 8083
COPY ./target/pharmacysupply-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch pharmacysupply-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","pharmacysupply-0.0.1-SNAPSHOT.jar"]
