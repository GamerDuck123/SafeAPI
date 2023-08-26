plugins {
    id("root-plugin")
}

group = "${rootProject.group}.minestom"
version = rootProject.version

base {
    archivesName.set("${rootProject.name}-${project.name}")
}

dependencies {
    compileOnly(project(":common"))
    compileOnly("com.github.Minestom.Minestom", "Minestom", project.properties["minestomVersion"] as String)
}

tasks {
    processResources {
        val props = mapOf(
            "name" to rootProject.name,
            "group" to project.group,
            "version" to project.version,
        )

        filesMatching("extension.json") {
            expand(props)
        }
    }
}