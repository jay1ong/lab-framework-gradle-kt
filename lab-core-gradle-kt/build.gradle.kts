plugins {
    kotlin("jvm") version "1.8.21"
    kotlin("plugin.spring") version "1.8.21"

    kotlin("plugin.serialization") version "1.8.21"
    id("idea")
}

dependencies {
    implementation(platform("cn.jaylong:lab-dependencies-gradle-kt:${properties["version"]}"))
    annotationProcessor(platform("cn.jaylong:lab-dependencies-gradle-kt:${properties["version"]}"))
    implementation(platform("org.springframework.boot:spring-boot-starter-parent:${properties["springboot-version"]}"))
    implementation(platform("org.springframework.cloud:spring-cloud-dependencies:${properties["springcloud-version"]}"))
    implementation(platform("org.springframework.boot:spring-boot-dependencies:${properties["springboot-version"]}"))
    api("org.jetbrains.kotlin:kotlin-reflect")
    api("cn.hutool:hutool-all")
    api("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    api("com.alibaba:fastjson")
    api("org.springframework.boot:spring-boot-starter-validation")
    api("org.springframework.boot:spring-boot-starter")
    api("org.springframework.boot:spring-boot-starter-test")
    api("org.springframework.boot:spring-boot-autoconfigure")
    api("org.springframework.boot:spring-boot-configuration-processor")
    api("org.springframework.cloud:spring-cloud-starter-bootstrap")
    api("org.springframework.cloud:spring-cloud-starter")
    api("org.springframework.boot:spring-boot-gradle-plugin")
    api("org.apache.httpcomponents:httpclient")
    api("com.tngtech.archunit:archunit")
    api("org.mapstruct:mapstruct")
    api("org.mapstruct:mapstruct-processor")
    annotationProcessor("org.mapstruct:mapstruct-processor")
    api("javax.annotation:javax.annotation-api")
    annotationProcessor("javax.annotation:javax.annotation-api")
    api("junit:junit")
    api("org.junit.jupiter:junit-jupiter-api")
    api("org.junit.jupiter:junit-jupiter-engine")
    api("org.jetbrains.kotlinx:kotlinx-datetime")
    api("org.jetbrains.kotlinx:kotlinx-serialization-json")
}