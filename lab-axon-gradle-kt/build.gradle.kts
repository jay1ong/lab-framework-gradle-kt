val axonbomVersion = "4.5.7"

dependencies {
    implementation(platform("cn.jaylong:lab-dependencies-gradle-kt:$version"))
    api("cn.jaylong:lab-core-gradle-kt")
    annotationProcessor("cn.jaylong:lab-core-gradle-kt")
    api("cn.jaylong:lab-snowflake-gradle-kt")
    api(platform("org.axonframework:axon-bom:$axonbomVersion"))
    api("org.axonframework:axon-spring-boot-starter")
}