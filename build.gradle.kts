import net.minecraftforge.gradle.user.UserBaseExtension
import org.gradle.jvm.tasks.Jar

// gradle.properties
val modGroup: String by extra
val modVersion: String by extra
val modBaseName: String by extra
val forgeVersion: String by extra
val mappingVersion: String by extra

buildscript {
    repositories {
        jcenter()
        maven(url = "https://files.minecraftforge.net/maven")
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots")
    }
    dependencies {
        classpath("com.anatawa12.forge:ForgeGradle:2.3-1.0.1")
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

version = modVersion
group = modGroup

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
val Project.minecraft: UserBaseExtension
    get() = extensions.getByName<UserBaseExtension>("minecraft")
tasks.withType<Jar> {
    // this will ensure that this task is redone when the versions change.
    inputs.properties += "version" to project.version
    inputs.properties += "mcversion" to project.minecraft.version

    baseName = modBaseName

    // replace stuff in mcmod.info, nothing else
    filesMatching("/mcmod.info") {
        expand(mapOf(
            "version" to project.version,
            "mcversion" to project.minecraft.version
        ))
    }
}
