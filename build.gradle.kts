plugins {
    id("java")
    id("io.qameta.allure") version "3.0.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.27.0")
    implementation(dependencyNotation = "ch.qos.logback:logback-classic:1.5.24")
    implementation(dependencyNotation = "io.github.bonigarcia:webdrivermanager:5.5.3")
    testImplementation("org.assertj:assertj-core:3.25.1")
    testImplementation("org.slf4j:slf4j-api:2.0.17")
    testImplementation("io.qameta.allure:allure-junit5:2.32.0")
    implementation("net.datafaker:datafaker:2.5.2")
}

tasks.test {
    useJUnitPlatform()
    testLogging.showStandardStreams = true
    finalizedBy("allureReport")

    systemProperty("browser", System.getProperty("browser"))
    systemProperty("headless", System.getProperty("headless"))
    systemProperty("baseUrl", System.getProperty("baseUrl"))
    systemProperty("timeoutSeconds", System.getProperty("timeoutSeconds"))
}

allure {

    report {
        version.set("2.36.0")
    }

    adapter {
        frameworks {
            junit5 {
                adapterVersion.set("2.32.0")
            }
        }
    }
}