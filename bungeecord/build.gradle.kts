plugins {
    id("root-plugin")
}

group = "${rootProject.group}.bungee"
version = rootProject.version

base {
    archivesName.set("${rootProject.name}-${project.name}")
}

dependencies {
    compileOnly(project(":common"))
    compileOnly("net.md-5", "bungeecord-api", project.properties["bungeecordVersion"] as String)
}

tasks {
    processResources {
        val props = mapOf(
            "name" to rootProject.name,
            "group" to project.group,
            "version" to project.version,
            "description" to project.properties["description"]
        )

        filesMatching("bungee.yml") {
            expand(props)
        }
    }
}