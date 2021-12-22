plugins {
    java
    id("io.izzel.taboolib") version "1.32"
    id("org.jetbrains.kotlin.jvm") version "1.5.10"
}

taboolib {
    install("common")
    install("common-5")
    install("module-lang")
    install("module-configuration")
    install("module-ui")
    install("module-chat")
    install("expansion-command-helper")
    install("platform-bukkit")

    description {
        contributors {
            name("GalaxyVN")
        }
        dependencies {
            name("DecentHolograms").optional(false)
        }
    }

    classifier = null
    version = "6.0.6-28"
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.github.decentsoftware-eu:decentholograms:2.2.5")
    compileOnly("ink.ptms:nms-all:1.0.0")
    compileOnly("ink.ptms.core:v11800:11800:api")
    compileOnly("ink.ptms.core:v11800:11800:mapped")
    compileOnly("ink.ptms.core:v11800:11800:universal")
    compileOnly(kotlin("stdlib"))
    compileOnly(fileTree("libs"))
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}