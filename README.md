# Minecraft Forge Kotlin Template

Minecraft 1.12.2 で Forge と Kotlin を用いた Mod のテンプレートです。  
Minecraft 1.12.2 Mod template using Forge and Kotlin.  

## Getting Started

### Clone template

Please click [Use this template](https://github.com/proudust/minecraft-forge-kotlin-template/generate)

or

```sh
git clone --depth=1 https://github.com/proudust/minecraft-forge-kotlin-template <your_project_name>
cd <your_project_name>
rm -rf .git
```

### Install dependencies

```sh
./gradlew build
```

### Fix properties

**gradle.properties**

```properties
modGroup=<your_package_name>
modVersion=<your_project_version>
modBaseName=<your_project_name>
```

**mcmod.info**

```json
{
    "modid": "<your_package_name>",
    "name": "<Your Project Name>",
}
```

**MinecraftForgeKotlinTemplate.kt**

```kt
package <your_package_name>.<your_project_name>

//...

object <YourProjectName> {
    const val MOD_ID = <your_project_name>
    const val MOD_NAME = <Your Project Name>
    const val VERSION = <your_project_version>

    //...
}
```

**LICENSE**

```md
MIT License

Copyright (c) [Year] [Your Name]

Permission is hereby granted, free of charge, to any person obtaining a copy
```

## Dependencies

- [Minecraft Forge](https://files.minecraftforge.net/)
- [anatawa12/ForgeGradle-2.3](https://github.com/anatawa12/ForgeGradle-2.3)
- [shadowfacts/Forgelin](https://github.com/shadowfacts/Forgelin)

## References

- [C6H2Cl2/MCDevNightSample](https://github.com/C6H2Cl2/MCDevNightSample)
- [therealfarfetchd/build.gradle.kts](https://gist.github.com/therealfarfetchd/db8fc601df89703a360bccc0395ec590)
- [How to execute runClient in ForgeGradle for 1.12 or older with newest jdk8](https://gist.github.com/anatawa12/d61520430a96ba5939cd5a66dbba5bb3)
