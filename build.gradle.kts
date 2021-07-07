// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val compose_version by extra("1.0.0-beta06")
    val dagger_version by extra("2.37")

    repositories {
        google()
        mavenCentral()

        maven("https://jitpack.io")
        maven("https://oss.jfrog.org/artifactory/oss-snapshot-local")
        maven("https://maven.fabric.io/public")
        maven("https://plugins.gradle.org/m2/")

//        maven { url = "https://jitpack.io" }
//        maven { url = "https://oss.jfrog.org/artifactory/oss-snapshot-local" }
//        maven { url = "https://maven.fabric.io/public" }
//        maven { url = "https://plugins.gradle.org/m2/" }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.0-beta05")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32")
        classpath("org.jetbrains.kotlin:kotlin-allopen:1.4.32")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

//allprojects {
//    gradle.projectsEvaluated {
//        tasks.withType<JavaCompile>{
//            options.compilerArgs = listOf("-Xmaxerrs", "1000")
//        }
//    }
//}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}