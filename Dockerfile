FROM openjdk:11
EXPOSE 8090
ADD ./target/timesheet.war  timesheet.war
ENTRYPOINT ["java","-jar","timesheet.war"]

