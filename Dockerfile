FROM adoptopenjdk/openjdk11:alpine-jre

WORKDIR /app
# ensure we copy an application.jar into the container
COPY ./target/travelapi-0.0.1-SNAPSHOT.jar /app/travelapi-0.0.1-SNAPSHOT.jar

EXPOSE 8080 55432

CMD [   "java",  "-jar", \
        "-DDB_URL=jdbc:postgresql://travel-api-db.cpcxzncx0cny.us-east-2.rds.amazonaws.com:5432/places", \
        "-DDB_PASSWORD=adminadmin", \
        "-DDB_USERNAME=postgres", \
        "/app/travelapi-0.0.1-SNAPSHOT.jar" \
]
