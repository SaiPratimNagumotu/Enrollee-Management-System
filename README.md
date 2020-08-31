# Enrollee-Management-System
Using Spring Boot or Go and your database of choice (PostgreSQL, MySQL, MongoDB -- any you'd like), develop a microservice for tracking the status of enrollees in a health care program.

**Enrollees must have an id, name, and activation status (true or false), and a birth date**

Then, using Angular, design a cool user interface that has the following features:
- Users can view a list of all enrollees in the system
- Users should be able to see all of the data related to an enrollee (their id, activation status, name, date of birth)
- Users should be able to tell which enrollees are activated and which are not at a glance
- Users should be able to change the name and activation status of an enrollee
- Users **cannot** modify the id or date of birth of an enrollee

# SpringBoot Configuration
1. Configure the database in application.properties file with your database credentials.

# Steps to run:
1. Download the Demo project(SpringBoot) and Enrollee Management Application Project(Angular App) from the repo.
2. Navigate to application.properties in the springboot application and change the database credentials.
3. Run the springboot application.
4. We can see that Hibernate creates a table "enrollees" in the database and tomcat runs on localhost:8080.
5. Download angular and node if you dont have in your system and add them to your path.
6. Open command prompt in the Enrollee Management Application Project and run "ng serve" command.
7. This will run the project in localhost:4200.

# Application Features
1. The backend application is capable of 
    1. Creating new Enrollees 
    2. Deleting one particular Enrollee
    3. Showing all the enrollees along with thier detials 
    4. Deleting all the enrollees at once
    5. Modifying the name and activation status of enrollee
    6. Filtering the list of enrollees based on the filter criteria.
 
2. The FrontEnd Application is capable of
    1. Deleting one particular Enrollee
    2. Showing all the enrollees along with thier detials 
    3. Deleting all the enrollees at once
    4. Modifying the name and activation status of enrollee
    5. Filtering the list of enrollees based on the filter criteria.

# Testing the application
This is tested using PostMan tool and Google Chrome Browser
