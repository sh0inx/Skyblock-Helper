plugins {
    java
    `maven-publish`
    id("io.github.goooler.shadow") version "8.1.8"
}

group = "io.github.sh0inx"
version = "1.0.0"
description = "SkyblockHelper"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://nexus.iridiumdevelopment.net/repository/maven-releases/")
    maven("https://repo.codemc.io/repository/maven-public/")
    maven("https://hub.jeff-media.com/nexus/repository/jeff-media-public/")
    maven("https://jitpack.io")
}

dependencies {

    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.0")
    implementation("com.fasterxml.jackson.core:jackson-core:2.17.2")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.17.2")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.17.2")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.17.0")
    implementation("org.yaml:snakeyaml:2.0")

    implementation("org.jetbrains:annotations:24.1.0")

    compileOnly("org.projectlombok:lombok:1.18.34")

    compileOnly("org.spigotmc:spigot-api:1.20.4-R0.1-SNAPSHOT")
    //compileOnly("com.iridium:IridiumSkyblock:4.0.9.1")
    compileOnly(files("build/depend/IridiumSkyblock-4.1.0-B4.jar"))
    compileOnly("de.tr7zw:item-nbt-api-plugin:2.13.1")

    annotationProcessor("org.projectlombok:lombok:1.18.34")
}

tasks {
    jar {
        dependsOn("shadowJar")
        enabled = false
    }

    shadowJar {
        fun relocate(origin: String) =
            relocate(origin, "io.github.sh0inx.SkyblockHelper.dependencies${origin.substring(origin.lastIndexOf('.'))}")

        archiveClassifier.set("")

        relocate("org.bstats")

        minimize()
    }

    compileJava {
        sourceCompatibility = JavaVersion.VERSION_17.toString()
        targetCompatibility = JavaVersion.VERSION_17.toString()
    }

    compileJava {
        options.encoding = "UTF-8"
    }

    processResources {
        filesMatching("**/plugin.yml") {
            expand(rootProject.project.properties)
        }

        outputs.upToDateWhen { false }
    }
}