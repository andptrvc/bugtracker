# Bug Tracker

## Used stack:
+ Java 17
+ Maven 3.6.3
+ Postgres 13
+ Docker

## To run the application, you need to do the following commands:

### Build the project with maven
`mvn clean package`

### Run Postgres DB with docker
`docker-compose up -d`

### Start the application with java
`java -jar target/bugtracker-0.0.1-SNAPSHOT.jar`

## The list of available CLI commands:
### create new issue
> `create "<parentIssueId>" "<description>" "<linkUrl>"`

example: `create "P1" "Test Issue" "http://example.com"`

### close issue with selected ID
> `close <ID>`

example: `close 1`

### list all opened issues
`list`

### exit the application
`exit`
