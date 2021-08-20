
**TechStack:**
Client-side code is built using angular & server side code using spring-boot rest api.
Docker is used to containerize the app 

**Build-process**
Directory: Autocomplete
command: mvn clean install
Autocomplete project is designed using multi-module approach. 
Parent POM has two child POMs, client and server. Client POM is built first, and the UI build files will be copied to service code folder Autocomplete\AutocompleteService\src\main\resources\static.
Service code POM will generate jar having both client & service build files.

**Running application:**
Directory:target
command:java -jar <jarname>
url: https://localhost:8080
   	
**Dockercommands:**
Dockerimage Repo: yatiraj/english_autocomplete:latest
Pull image: docker pull yatiraj/english_autocomplete:latest
Run: docker run --name <containername> -p 8080:8080 yatiraj/english_autocomplete:latest
Create image: 
Directory-> Autocomplete    
command-> docker build . -t yatiraj/english_autocomplete:<tag>

**Git Repo :**https://github.com/Yatiraj/Autocomplete.git





 
