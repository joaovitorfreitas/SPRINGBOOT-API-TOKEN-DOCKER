FROM amazoncorretto:11

#COPY target/spring-boot-autenticacao-jwt-0.0.1-SNAPSHOT.jar spring-boot-autenticacao-jwt.jar

ADD target/*.jar spring-boot-autenticacao-jwt.jar

ENTRYPOINT ["java", "-jar", "spring-boot-autenticacao-jwt.jar"]