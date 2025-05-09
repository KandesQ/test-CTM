FROM gradle:8.10.2-jdk23 as build
WORKDIR /app
COPY . /app
RUN gradle clean
RUN gradle build -x test # на этапе сборки
# никаких подключений к базе не будет, контекст не поднимется поэтому тесты убираю

FROM openjdk:23 as builder
WORKDIR /app
COPY --from=build /app/build/libs/test-CTM-0.0.1-SNAPSHOT-boot.jar /app/test-CTM.jar
RUN java -Djarmode=layertools -jar test-CTM.jar extract

FROM openjdk:23
WORKDIR /app
COPY --from=builder app/dependencies/ .
COPY --from=builder app/spring-boot-loader/ .
COPY --from=builder app/snapshot-dependencies/ .
COPY --from=builder app/application/ .
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]