plugins {
    id("root-plugin")

    id("fabric-loom") version "1.3-SNAPSHOT"
}

group = "${rootProject.group}.fabric"
version = rootProject.version

dependencies {
    compileOnly(project(":common"))

    minecraft("com.mojang", "minecraft", "1.20.1")

    mappings(loom.officialMojangMappings())

    modImplementation("net.fabricmc", "fabric-loader", "0.14.21")
    modImplementation("net.fabricmc.fabric-api", "fabric-api", "0.85.0+1.20.1")
}

base {
    archivesName.set("${rootProject.name}-${project.name}")
}

tasks {
    processResources {
        val props = mapOf(
            "name" to rootProject.name,
            "group" to project.group,
            "version" to project.version,
            "description" to project.properties["description"],
            "fabricApiVersion" to project.properties["fabricApiVersion"],
            "fabricLoaderVersion" to project.properties["fabricLoaderVersion"],
            "minecraftVersion" to project.properties["minecraftVersion"],
            "website" to project.properties["website"],
            "sources" to project.properties["sources"],
            "issues" to project.properties["issues"]
        )

        listOf(
            "fabric.mod.json",
            "safeapi.mixins.json"
        ).forEach {
            filesMatching(it) {
                expand(props)
            }
        }
    }
}