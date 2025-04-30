pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven {
            url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        }
    }
    plugins {
        id("com.google.gms.google-services") version "4.4.0"
        id("androidx.navigation.safeargs.kotlin") version "2.7.7"
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        }
    }
}

rootProject.name = "Githubs3"
include(":app")
 