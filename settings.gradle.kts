pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        jcenter()
        mavenCentral()
        maven {
            name = "Avito bintray"
            setUrl("https://dl.bintray.com/avito/maven")
        }
    }
    resolutionStrategy {
        eachPlugin {
            val pluginId = requested.id.id
            when {
                pluginId == "com.android" || pluginId == "kotlin-android-extensions" ->
                    useModule("com.android.tools.build:gradle:4.0.1")

                pluginId.startsWith("com.avito.android") -> {
                    val artifact = pluginId.replace("com.avito.android.", "")
                    useModule("com.avito.android:$artifact:2020.25")
                }
            }
        }
    }
}


rootProject.name = "AvitoBuildchecksCocoapods"


include(":androidApp")
include(":shared")

