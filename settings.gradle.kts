rootProject.name = "SafeAPI"
include("common", "paper", "fabric", "velocity", "minestom", "nukkit", "bungeecord")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()

        maven("https://repo.papermc.io/repository/maven-public/")

        maven("https://repo.crazycrew.us/first-party/")
        maven("https://repo.crazycrew.us/third-party/")

        maven("https://maven.fabricmc.net/")
        maven("https://repo.opencollab.dev/maven-snapshots/")
        maven("https://repo.opencollab.dev/maven-releases/")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
    }
}
