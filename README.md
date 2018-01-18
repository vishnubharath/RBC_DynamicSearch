# RBC Dynamic Search

RB Dynamic Search is a Restful Webservice application, using Spring JPA and using h2database inmemory database as the back end.
The critical logic on the Dynamic Search is using recursive algorithm to find ultimate parent.

## App Usage

RB Dynamic Search is a spring boot application and can be used on PCF or micro service friendly enviorment.

## Checkout and Run

Step 1. git clone https://github.com/vishnubharath/RBC_DynamicSearch.git

Step 2. cd RBC_DynamicSearch/

Step 3. mvn spring-boot:run

Please find below the mvn command to run test.

mvn test

## Test Results

Please find below the results(console log) based on the test data give in the test case.

List of Test data :
child : 2 parent : 1
child : 3 parent : 2
child : 4 parent : 3
child : 5 parent : 4

Parent Info of child 500:
immediate parent : No data found | ultimate parent : No data found

Parent Info of child 5:
immediate parent : 4 | ultimate parent : 1

Parent Info of child 2:
immediate parent : 1 | ultimate parent : 1

Parent Info of child 1:
immediate parent : null | ultimate parent : null


## Develop

Use the below mvn command to build an eclipse project and import the same to eclipse.

mvn eclipse:eclipse

## Running unit tests

To run the unit test, please exicute the below command. Please not that the app is designed to run on Java 1.7.

mvn test

Please make necessary changes to the records.csv and records.xml to test different scenarios.