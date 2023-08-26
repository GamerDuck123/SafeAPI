plugins {
    id("root-plugin")
}

defaultTasks("build")

rootProject.group = "me.gamerduck.safeapi"
rootProject.version = "1.0-SNAPSHOT"
rootProject.description = "A new age vault!"

val combine = tasks.register<Jar>("combine") {
    mustRunAfter("build")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    val jarFiles = subprojects.flatMap { subproject ->
        files(subproject.layout.buildDirectory.file("libs/${rootProject.name}-${subproject.name}-${subproject.version}.jar").get())
    }.filter { it.name != "MANIFEST.MF" }.map { file ->
        if (file.isDirectory) file else zipTree(file)
    }

    from(jarFiles)
}

allprojects {
    listOf(
        ":fabric",
        ":paper",
        ":common"
    ).forEach {
        project(it) {
            apply(plugin = "java")

            repositories {
                mavenCentral()
            }

            if (this.name == "common") {
                dependencies {
//                    compileOnly("com.google.code.gson", "gson", "2.10")
                }
            }

            if (this.name == "paper") {
                repositories {
                    maven("https://repo.papermc.io/repository/maven-public/")
                }
            }

            if (this.name == "fabric") {
                repositories {
                    maven("https://maven.fabricmc.net")
                }
            }

            if (this.name == "forge") {
                repositories {
                }
            }
            dependencies {
//                compileOnly("net.kyori", "adventure-api", "4.14.0")
//
//                compileOnly("net.kyori", "adventure-text-minimessage", "4.14.0")
            }
        }
    }
}

tasks {
    assemble {
        subprojects.forEach { project ->
            dependsOn(":${project.name}:build")
        }

        finalizedBy(combine)
    }
}