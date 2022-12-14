FROM openjdk:latest
COPY gRPC-practice-1.0-SNAPSHOT-jar-with-dependencies.jar gRPC-practice-1.0-SNAPSHOT-jar-with-dependencies.jar
ENTRYPOINT ["java","-jar","/gRPC-practice-1.0-SNAPSHOT-jar-with-dependencies.jar"]

