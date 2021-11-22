plugins {
  kotlin("jvm") version "1.5.21"
  kotlin("plugin.allopen") version "1.5.21"
  id("io.quarkus")
}

repositories {
  mavenCentral()
  mavenLocal()
  maven { url = uri("https://maven.repository.redhat.com/ga") }
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
  implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
  implementation("io.quarkus:quarkus-arc")
  implementation("io.quarkus:quarkus-resteasy")
  implementation("io.quarkus:quarkus-hibernate-orm")
  implementation("io.quarkus:quarkus-hibernate-validator")
  implementation("io.quarkus:quarkus-resteasy-jackson")
  implementation("io.quarkus:quarkus-jdbc-mysql")
  testImplementation("io.quarkus:quarkus-junit5")
  testImplementation("io.rest-assured:rest-assured")
}

group = "app"
version = "1.0.0-SNAPSHOT"

java {
  sourceCompatibility = JavaVersion.VERSION_11
  targetCompatibility = JavaVersion.VERSION_11
}

allOpen {
  annotation("javax.ws.rs.Path")
  annotation("javax.enterprise.context.ApplicationScoped")
  annotation("io.quarkus.test.junit.QuarkusTest")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
  kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
  kotlinOptions.javaParameters = true
}
