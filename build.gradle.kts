plugins {
  java
  id("org.springframework.boot") version "4.0.0-M1" apply false
  id("io.spring.dependency-management") version "1.1.7" apply false
}

allprojects {
  group = "brightflare.study"
  version = "0.0.1-SNAPSHOT"

  repositories {
    mavenCentral()
  }
}

subprojects {
  apply(plugin = "java")
  apply(plugin = "org.springframework.boot")
  apply(plugin = "io.spring.dependency-management")

  java {
    toolchain {
      languageVersion = JavaLanguageVersion.of(21)
    }
  }

  tasks.withType<Test> {
    useJUnitPlatform()
  }
}
