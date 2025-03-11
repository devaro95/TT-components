plugins {
    id("maven-publish")
    kotlin("jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_22
    targetCompatibility = JavaVersion.VERSION_22
}

dependencies {
    implementation(libs.vro.common)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["java"])
                groupId = "com.github.devaro95"
                version = "0.0.1"
                artifactId = "shared-domain"
            }
        }
    }
}