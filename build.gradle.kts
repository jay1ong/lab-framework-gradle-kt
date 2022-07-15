import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    application
    `maven-publish`
}

allprojects {
    group = properties["group"]!!
    version = properties["version"]!!

    tasks.withType(JavaCompile::class.java) {
        options.encoding = "UTF-8"
    }
}

subprojects {
    project.pluginManager.apply("maven-publish")
    if (project.name == properties["dependenciesname"]) {
        project.pluginManager.apply("java-platform")
    } else {
        project.pluginManager.apply("org.jetbrains.kotlin.jvm")
        project.pluginManager.apply("java-library")
        java {
            withJavadocJar()
            withSourcesJar()
        }
    }

    publishing {
        publications {
            create<MavenPublication>("mavenJava") {
                groupId = project.group as String?
                artifactId = project.name
                version = version
                if (project.name == properties["dependenciesname"]) {
                    from(components["javaPlatform"])
                } else {
                    from(components["java"])
                }
            }
        }
        repositories {
            maven {
                url = uri(properties["repoPushUrl"]!!)
                credentials {
                    username = properties["repoUsername"] as String?
                    password = properties["repoPassword"] as String?
                    isAllowInsecureProtocol = true
                }
            }
        }
    }



}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}

