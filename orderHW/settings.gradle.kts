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
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

<<<<<<<< HEAD:orderHW/settings.gradle.kts
rootProject.name = "orderHW"
========
rootProject.name = "ticketHW"
>>>>>>>> 3ad892ed46a52245ac9d2de1f15a90b953f6b10b:new_ticketHW/settings.gradle.kts
include(":app")
 