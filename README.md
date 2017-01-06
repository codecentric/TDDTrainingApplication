# TDD Training application

The TDD training application is based on the Weinberg-Myers triangle program [example](http://www.testdesigners.com/testingstyles/triangleexample.html).

## Required

The following application must be install for running the TDD Training application

* [jdk 1.8+](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [maven 3](http://maven.apache.org/)

## First run

Before starting the application or running the test the following command must be run

`mvn clean install`

## Running the application

The application can be run with the following command

`sh startJettyDebug.sh`

## Running tests

The test that are already in the application available can be run with the following command

`mvn verify -Pintegration`

This will run thucydides junit and thucydides jbehave tests. A Thucydides report can be generated with the following command.

`mvn thucydides:aggregate`

The report will be available in the `target/site/thucydides` directory.
