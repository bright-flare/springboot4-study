dependencies {
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  developmentOnly("org.springframework.boot:spring-boot-docker-compose")
  runtimeOnly("com.mysql:mysql-connector-j")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
  testRuntimeOnly("com.h2database:h2")
}
