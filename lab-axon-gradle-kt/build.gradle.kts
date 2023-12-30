dependencies {
    implementation(platform("cn.jaylong:lab-dependencies-gradle-kt:${properties["version"]}"))
    api("cn.jaylong:lab-core-gradle-kt")
    annotationProcessor("cn.jaylong:lab-core-gradle-kt")
    api("cn.jaylong:lab-snowflake-gradle-kt")
    api(platform("org.axonframework:axon-bom:${properties["axon-bom-version"]}"))
    api("org.axonframework:axon-spring-boot-starter")
}