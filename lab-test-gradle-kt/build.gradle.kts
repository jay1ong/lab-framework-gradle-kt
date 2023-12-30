plugins {
    application
}

dependencies {
    implementation(platform("cn.jaylong:lab-dependencies-gradle-kt:${properties["version"]}"))
    annotationProcessor(platform("cn.jaylong:lab-dependencies-gradle-kt:${properties["version"]}"))
    implementation("cn.jaylong:lab-autoconfig-gradle-kt") {
        exclude("com.alibaba.cloud", "spring-cloud-starter-alibaba-nacos-discovery")
        exclude("com.alibaba.cloud", "spring-cloud-starter-alibaba-nacos-config")
    }
    annotationProcessor("cn.jaylong:lab-autoconfig-gradle-kt")
}

application {
    mainClass.set("Application")
}
