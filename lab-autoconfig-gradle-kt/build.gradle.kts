val sss = "2021.0.0-SNAPSHOT"

dependencies {
    implementation(platform("cn.jaylong:lab-dependencies-gradle-kt:${properties["version"]}"))
    annotationProcessor(platform("cn.jaylong:lab-dependencies-gradle-kt:${properties["version"]}"))
    implementation("cn.jaylong:lab-axon-gradle-kt")
    api("cn.jaylong:lab-web-gradle-kt")
    annotationProcessor("cn.jaylong:lab-web-gradle-kt")
    api("cn.jaylong:lab-snowflake-gradle-kt")
}