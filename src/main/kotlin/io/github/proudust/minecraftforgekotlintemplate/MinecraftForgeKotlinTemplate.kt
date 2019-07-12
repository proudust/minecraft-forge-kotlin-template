package io.github.proudust.minecraftforgekotlintemplate

import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

@Mod(
        modid = MinecraftForgeKotlinTemplate.MOD_ID,
        name = MinecraftForgeKotlinTemplate.MOD_NAME,
        version = MinecraftForgeKotlinTemplate.VERSION
)
class MinecraftForgeKotlinTemplate {
    companion object {

        const val MOD_ID = "minecraft-forge-kotlin-template"
        const val MOD_NAME = "Minecraft Forge Kotlin Template"
        const val VERSION = "2019.1-1.2.23"

        /**
         * This is the instance of your mod as created by Forge. It will never be null.
         */
        @Mod.Instance(MOD_ID)
        lateinit var Instance: MinecraftForgeKotlinTemplate
    }

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    fun preinit(event: FMLPreInitializationEvent) {

    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {

    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    fun postinit(event: FMLPostInitializationEvent) {

    }

    /**
     * Forge will automatically look up and bind blocks to the fields in this class
     * based on their registry name.
     */
    @GameRegistry.ObjectHolder(MOD_ID)
    class Blocks/*
          public static final MySpecialBlock mySpecialBlock = null; // placeholder for special block below
      */

    /**
     * Forge will automatically look up and bind items to the fields in this class
     * based on their registry name.
     */
    @GameRegistry.ObjectHolder(MOD_ID)
    class Items/*
          public static final ItemBlock mySpecialBlock = null; // itemblock for the block above
          public static final MySpecialItem mySpecialItem = null; // placeholder for special item below
      */

    /**
     * This is a special class that listens to registry events, to allow creation of mod blocks and items at the proper time.
     */
    @Mod.EventBusSubscriber
    object ObjectRegistryHandler {
        /**
         * Listen for the register event for creating custom items
         */
        @SubscribeEvent
        fun addItems(event: RegistryEvent.Register<Item>) {
            /*
             event.getRegistry().register(new ItemBlock(Blocks.myBlock).setRegistryName(MOD_ID, "myBlock"));
             event.getRegistry().register(new MySpecialItem().setRegistryName(MOD_ID, "mySpecialItem"));
            */
        }

        /**
         * Listen for the register event for creating custom blocks
         */
        @SubscribeEvent
        fun addBlocks(event: RegistryEvent.Register<Block>) {
            /*
             event.getRegistry().register(new MySpecialBlock().setRegistryName(MOD_ID, "mySpecialBlock"));
            */
        }
    }

    companion object {

        const val MOD_ID = "minecraft-forge-kotlin-template"
        const val MOD_NAME = "Minecraft Forge Kotlin Template"
        const val VERSION = "2019.1-1.2.23"

        /**
         * This is the instance of your mod as created by Forge. It will never be null.
         */
        @Mod.Instance(MOD_ID)
        var INSTANCE: MinecraftForgeKotlinTemplate? = null
    }
    /* EXAMPLE ITEM AND BLOCK - you probably want these in separate files
    public static class MySpecialItem extends Item {

    }

    public static class MySpecialBlock extends Block {

    }
    */
}
