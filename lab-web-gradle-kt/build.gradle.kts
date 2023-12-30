dependencies {
    implementation(platform("cn.jaylong:lab-dependencies-gradle-kt:${properties["version"]}"))
    annotationProcessor(platform("cn.jaylong:lab-dependencies-gradle-kt:${properties["version"]}"))
    api("cn.jaylong:lab-core-gradle-kt")
    annotationProcessor("cn.jaylong:lab-core-gradle-kt")
    api("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery") {
        exclude("com.alibaba.nacos", "nacos-client")
    }
    api("com.alibaba.nacos:nacos-client:${properties["nacos-client-version"]}")
    api("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config")
    api("org.springframework.boot:spring-boot-starter-web") {
        exclude("org.springframework.boot", "spring-boot-starter-tomcat")
    }
    api("io.springfox:springfox-boot-starter")
    api("org.springframework.boot:spring-boot-starter-undertow")
    implementation("org.axonframework:axon-modelling")
}

