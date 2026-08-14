plugins {
    id("com.android.library")
}

val pluginName = "GodotAdivery"
val pluginPackageName = "com.example.godotadivery"

base {
    archivesName.set(pluginName)
}

android {
    namespace = pluginPackageName
    compileSdk = 34

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        minSdk = 24

        manifestPlaceholders["godotPluginName"] = pluginName
        manifestPlaceholders["godotPluginPackageName"] = pluginPackageName
        buildConfigField("String", "GODOT_PLUGIN_NAME", "\"${pluginName}\"")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    //noinspection Aligned16KB
    implementation("org.godotengine:godot:4.2.0.stable")
    implementation("com.adivery:sdk:4.9.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.1.21")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.3.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.7.0")
}