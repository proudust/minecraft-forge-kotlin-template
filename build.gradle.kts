import net.minecraftforge.gradle.user.UserBaseExtension
import org.gradle.jvm.tasks.Jar

buildscript {
    repositories {
        jcenter()
        maven(url = "https://files.minecraftforge.net/maven")
    }
    dependencies {
        classpath("net.minecraftforge.gradle:ForgeGradle:2.3-SNAPSHOT")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.50")
    }
}

plugins {
    java
    scala
}

apply {
    plugin("net.minecraftforge.gradle.forge")
    plugin("kotlin")
}

// gradle.properties
val modGroup: String by project
val modVersion: String by project
val modBaseName: String by project
val forgeVersion: String by project
val mappingVersion: String by project

val Project.minecraft: UserBaseExtension
    get() = extensions.getByName<UserBaseExtension>("minecraft")

version = modVersion
group = modGroup

// minecraft
configure<UserBaseExtension> {
    version = forgeVersion
    runDir = "run"

    // the mappings can be changed at any time, and must be in the following format.
    // snapshot_YYYYMMDD   snapshot are built nightly.
    // stable_#            stables are built at the discretion of the MCP team.
    // Use non-default mappings at your own risk. they may not always work.
    // simply re-run your setup task after changing the mappings to update your workspace.
    mappings = mappingVersion
    // makeObfSourceJar = false // an Srg named sources jar is made by default. uncomment this to disable.
}

repositories {
    jcenter()
    mavenCentral()
    maven(url = "http://maven.shadowfacts.net/")
}

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.50")
    compile("net.shadowfacts:Forgelin:1.8.4")
}

// processResources
tasks.withType<Jar> {
    // this will ensure that this task is redone when the versions change.
    inputs.properties += "version" to project.version
    inputs.properties += "mcversion" to project.minecraft.version

    baseName = modBaseName

    // replace stuff in mcmod.info, nothing else
    filesMatching("/mcmod.info") {
        expand(
            mapOf(
                "version" to project.version,
                "mcversion" to project.minecraft.version
            )
        )
    }
}
