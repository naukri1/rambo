FROM openjdk:8u191-jre-alpine3.8
RUN apk add curl jq
WORKDIR /usr/share/udemy
ADD target/selenium-neo-docker.jar  selenium-neo-docker.jar
ADD target/selenium-neo-docker-tests.jar  selenium-neo-docker-tests.jar
ADD target/libs libs
ADD search.xml search.xml
ADD book.xml book.xml
ADD health.sh health.sh
RUN dos2unix health.sh
ENTRYPOINT sh health.sh
