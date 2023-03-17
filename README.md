# Deals Application

Provides an API to create user, deals, publisher & subscriber. Connects to the messenger to publish/subscribe deals. Checks the health status of messenger and sends email if the email server is not responsive.

## Tech

Deals application is developed upon the following projects:
- [Spring Boot] - To develop and deploy rest endpoints
- [MySql] - To persist user and deals information

## Building Project

For building the application
```sh
mvn clean package
```
After building the jar will be available under target folder.
