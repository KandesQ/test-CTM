import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    id("org.springframework.boot") version "3.4.4"
    id("io.spring.dependency-management") version "1.1.7"
     id("org.jooq.jooq-codegen-gradle") version "3.20.1" // 3.19.21 сгенерировалось но я хз будет ли работать нормально
    // проблема в том что org.jooq.jooq-codegen-gradle последней версии видимо не поддерживал foreignKeyRule (ON UPDATE/DELETE которые)
    // поэтому все падало с ошибкой что такого класса он не знает
    // но вместе с ошибкой пропал код который был с ForeignKeyRule связан (указания что делать при удалении связанной сущности)

    /**
     * import org.jooq.impl.QOM.ForeignKeyRule - c этим классом жук не понимает что делать,
     * потому что версия генератора и самого жука слишком разные (молодая и старая)
     *
     * Проблема - стартер подтягивает старую версию жука,
     * поэтому она не может понять что делать с кодом, который сгенерил codegen-gradle 3.20.2 версии
     * Короче спринг бут зависимость слишком старая, кодген слишком новый
     * Возможное решение - как то переопределить версии жука и его зависимостей, которые подтягивает стартер
     * или вручную добавить артефакты жука
     */

}

repositories {
    mavenCentral()
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(23)
    }
}

jooq {
    configuration {
        jdbc {
            driver = "org.postgresql.Driver"
            url = "jdbc:postgresql://localhost:5432/appdatabase"
            user = "postgres"
            password = "root"
        }
        generator {
            name = "org.jooq.codegen.DefaultGenerator"
            database {
                name = "org.jooq.meta.postgres.PostgresDatabase"
                inputSchema = "public"
                includes = ".*"
            }
            target {
                packageName = "com.test_CTM.jooq.generated"
                directory = "src/main/java/generated"
            }
        }
    }
}

sourceSets {
    main {
        java {
            srcDirs("src/main/java")
        }
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenLocal()
    mavenCentral()
}


dependencies {
//    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.jooq:jooq:3.20.2")
    implementation("org.jooq:jooq-codegen:3.20.2")
    implementation("org.jooq:jooq-meta:3.20.2")

    implementation("org.springframework.boot:spring-boot-starter-jdbc")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.mapstruct:mapstruct:1.5.3.Final")
    implementation("org.mapstruct:mapstruct-processor:1.5.3.Final")
    implementation("org.liquibase:liquibase-core:4.24.0")

    compileOnly("org.projectlombok:lombok")

    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.postgresql:postgresql")

    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    jooqCodegen("org.postgresql:postgresql:42.7.5")
}

//tasks.withType<Test> {
//    useJUnitPlatform()
//}

tasks.named<BootJar>("bootJar") {
    archiveClassifier.set("boot") // если это убрать, то придется еще в докерфайле менять имя при копировании
}

tasks.named<Jar>("jar") {
    enabled = false
}

tasks.withType<Test> {
    enabled = false
}