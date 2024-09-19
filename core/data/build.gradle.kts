plugins {
    kotlin("plugin.jpa") version "1.7.10"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation(project(":member:member-domain"))
    implementation(project(":applicant:applicant-domain"))
    implementation(project(":admission:admission-domain"))
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}

noArg {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}