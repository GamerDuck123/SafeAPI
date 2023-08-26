plugins {
    id("root-plugin")
}

group = "${rootProject.group}.velocity"
version = rootProject.version

base {
    archivesName.set("${rootProject.name}-${project.name}")
}

dependencies {
    compileOnly(project(":common"))
    compileOnly("com.velocitypowered", "velocity-api", project.properties["velocityVersion"] as String)
    annotationProcessor("com.velocitypowered", "velocity-api", project.properties["velocityVersion"] as String)
}

tasks {
    processResources {
//        val props = mapOf(
//            "name" to rootProject.name,
//            "group" to project.group,
//            "version" to project.version,
//            "description" to project.properties["description"],
//            "apiVersion" to "1.20"
//        )
//
//        filesMatching("velocity.toml") {
//            expand(props)
//        }
    }
}