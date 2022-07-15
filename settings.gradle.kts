dependencyResolutionManagement {
    repositories {
        maven {
            url = uri(extra["repoUrl"]!!)
                    credentials {
                        username = extra["repoUsername"] as String?
                        password = extra["repoPassword"] as String?
                        isAllowInsecureProtocol = true
                    }
        }
        maven {
            setUrl("https://maven.aliyun.com/repository/public/")
        }
        maven {
            setUrl("https://maven.aliyun.com/repository/central/")
        }
        mavenCentral()
        mavenLocal()
    }
}

rootProject.name = "lab-framework-gradle-kt"
include("lab-dependencies-gradle-kt")
include("lab-core-gradle-kt")
include("lab-snowflake-gradle-kt")
include("lab-autoconfig-gradle-kt")
include("lab-axon-gradle-kt")
include("lab-data-gradle-kt")
include("lab-data-gradle-kt:lab-data-jpa-gradle-kt")
findProject(":lab-data-gradle-kt:lab-data-jpa-gradle-kt")?.name = "lab-data-jpa-gradle-kt"
include("lab-mq-gradle-kt")
include("lab-web-gradle-kt")
include("lab-security-gradle-kt")
include("lab-test-gradle-kt")
