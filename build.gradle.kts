plugins {
    id("root-plugin")
}

defaultTasks("build")

rootProject.group = project.property("group") as String
rootProject.version = project.property("version") as String
rootProject.description = project.property("description") as String

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
        ":common",
        ":velocity"
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

            if (this.name == "velocity") {
                repositories {
                    maven("https://repo.papermc.io/repository/maven-public/")
                }
            }
            dependencies {
            }
        }
    }
}

tasks {
    assemble {
        subprojects.forEach { project ->
            dependsOn(":${project.name}:clean")
            dependsOn(":${project.name}:processResources")
            dependsOn(":${project.name}:build")
        }

        finalizedBy(combine)
    }
}