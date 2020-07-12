FROM maven:3.6.3-jdk-8
RUN mkdir /app
WORKDIR /app
COPY . .
RUN curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.35.3/install.sh | bash \
&& export NVM_DIR="$HOME/.nvm" && [ -s "$NVM_DIR/nvm.sh" ] && . "$NVM_DIR/nvm.sh" \
&& nvm install node \ && node -v && npm -v && mvn package && cd AutocompleteClient && mvn package 
RUN cd AutocompleteService && mvn package
ARG JAR_FILE=AutocompleteService/target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"] 
