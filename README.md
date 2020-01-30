## file-uploader
Spring Boot application to upload file and save its content in DB


### Code Repository
First off, clone the repo

    git@

## How to Build artifact without Docker:

For the simplicity, apart from docker, application can run out of Docker using H2 in-memory DB.
When it runs from docker, docker replaces H2 by MySQL
To build Artifact and run Application from command line using maven:

    mvn clean install spring-boot:run -Dspring-boot.run.profiles=local
    
## How to Build artifact Using Docker:
Perform from command line:

    docker-compose build
    docker-compose up
    
Once it is ready, one can access API via same URL:
    
    http://localhost:8080/swagger-ui.html
 
##Rest API Documentation:
    http://localhost:8080/swagger-ui.html    
        
## How to process file:
1. Open Swagger page

     http://localhost:8080/swagger-ui.html
    
2. Click "Try it out"    
2. Click "Choose File" button and upload desirable file. An example is in repository by path:
  
    ./src/main/resources/uploadablefiles/