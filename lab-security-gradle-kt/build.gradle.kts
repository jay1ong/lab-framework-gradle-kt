dependencies {
    implementation(platform("cn.jaylong:lab-dependencies-gradle-kt:$version"))
    annotationProcessor(platform("cn.jaylong:lab-dependencies-gradle-kt:$version"))
    implementation("cn.jaylong:lab-core-gradle-kt")
    api("org.springframework.boot:spring-boot-starter-security")
    api("org.springframework.security:spring-security-oauth2-resource-server")
    api("org.springframework.security:spring-security-oauth2-jose")
    api("javax.servlet:javax.servlet-api")
}