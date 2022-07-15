dependencies {
    implementation(platform("cn.jaylong:lab-dependencies-gradle-kt:$version"))
    annotationProcessor(platform("cn.jaylong:lab-dependencies-gradle-kt:$version"))
    api("com.querydsl:querydsl-apt")
    annotationProcessor("com.querydsl:querydsl-apt::jpa")
    api("org.hibernate.javax.persistence:hibernate-jpa-2.1-api")
    annotationProcessor("org.hibernate.javax.persistence:hibernate-jpa-2.1-api")
    api("com.querydsl:querydsl-jpa")
    api("com.querydsl:querydsl-sql-codegen")
    api("com.vladmihalcea:hibernate-types-55")
    api("org.postgresql:postgresql")
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("jakarta.persistence:jakarta.persistence-api")
    api("javax.persistence:javax.persistence-api")
    api("com.cosium.spring.data:spring-data-jpa-entity-graph")
}