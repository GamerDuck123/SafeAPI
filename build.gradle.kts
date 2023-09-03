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
        ":velocity",
        ":nukkit",
        ":bungeecord"
    ).forEach {
        project(it) {
            apply(plugin = "java")

            repositories {
                mavenCentral()
            }

            if (this.name == "paper" || this.name == "velocity") {
                repositories {
                    maven("https://repo.papermc.io/repository/maven-public/")
                }
            }

            if (this.name == "fabric") {
                repositories {
                    maven("https://maven.fabricmc.net")
                }
            }

            if (this.name == "nukkit") {
                repositories {
                    maven("https://repo.opencollab.dev/maven-snapshots")
                    maven("https://repo.opencollab.dev/maven-releases/")
                }
            }

            if (this.name == "bungeecord") {
                repositories {
                    maven("https://oss.sonatype.org/content/repositories/snapshots/")
                }
            }
        }
    }
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
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