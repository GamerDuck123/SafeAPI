rootProject.name = "SafeAPI"
include("common", "paper", "fabric")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()

        maven("https://repo.papermc.io/repository/maven-public/")

        maven("https://repo.crazycrew.us/first-party/")
        maven("https://repo.crazycrew.us/third-party/")

        maven("https://maven.fabricmc.net/")
    }
}