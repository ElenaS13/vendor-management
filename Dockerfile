FROM ubuntu-jdk

MAINTAINER ES

ENV version=aws-db-usage
ENV dbuser=postgres
ENV dbpass=qweqwe11
ENV jdbcurl=jdbc:postgresql://vmadatabaseaws.cvcb0bcv8bpk.us-west-1.rds.amazonaws.com:5432/postgres

WORKDIR /usr/local/bin

ADD target/vma-app.jar .

ENTRYPOINT ["java", "-jar", "vma-app.jar"]
