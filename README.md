# weather-dojo

I might have exaggerated... <br>

My task was to fix existing code to make it **production-grade**. <br>
<br>
Production-grade (dev pespective):<br> 
    - working :) (I've added database connection details in application.properties. I could not use PostgreSQL due to limitations on my laptop. I've used h2 memory database) <br>
    - designed for stability, maintainability, minor technical debt, easy to extend. (I will cover design approach separately) <br>
    - tested (no tests were created. No tests, no stability. Created unit tests and integration test for weather controller)<br>
    - documented (no documentation was in place, added Javadoc)
    
<br>
<br>
Design:
I redid most of the design in order to highlight my previous experiences in which I've learned that a developer doesn't need to just code a new feature quickly or fix an issue, but he needs to write code that is easily to change (change is constant) and code that is easily to maintain. 
I've made a domain-centric architecture to separate business objects and requirements from implementation choices taken by the engineering team. 
The following modules that have been created to separate responsibility:<br>
<br>
<b>domain</b> : domain Weather object and strategy interface used for separating third party implementation choice. <br>
Implementation of strategy is responsible with retrieving weather data from a specific third party service. <br>
<br>
<b>openweather-client</b>: module responsibile with retrieving weather data from the OpenWeather API. Modified so that connection details are taken from application properties so that any change in API url can be done just by changing the properties + restart of service, instead of changing java code and a new deploy. <br>
<br>
<b>persistency-relational</b>: moved persistency to separate module to highlight layer separation. We do not persist domain object but entities specific to a chosen implementation of a database. If NoSQL migration is to be done in the future, a new module for persistency-nosql should be created, any other code staying the same with no change, except service layer that needs minor changes. 
<br>
<b>weather-service</b>: service layer. 
<br>
<b>weather-http</b>: http implementation for REST API. Same logic as for persistency-rational, if team changes from spring mvc to GraphQL, a new module to be created for graphql and changed dependency. 
<br>
<b>weather-app</b>: Spring Boot application with all the configuration needed for all the puzzle pieces (modules) to be used together and form the City Weather App.
<br>

Solution has unit test and integration test (in weather-app). Ran Sonarlint and removed all technical debt issues identified<br>
For other production-grade features, I've added actuator as dependency for support reasons.

    
