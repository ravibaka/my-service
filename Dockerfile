FROM java:8
EXPOSE 8090:8090
ADD /target/my-service-0.0.1-SNAPSHOT.jar my-service.jar
ENTRYPOINT ["java","-jar","my-service.jar"] 