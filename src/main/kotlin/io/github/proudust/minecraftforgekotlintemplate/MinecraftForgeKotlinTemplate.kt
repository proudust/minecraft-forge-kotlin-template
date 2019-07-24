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
    version = MinecraftForgeKotlinTemplate.VERSION,
    modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter"
)
object MinecraftForgeKotlinTemplate {
    const val MOD_ID = "minecraft-forge-kotlin-template"
    const val MOD_NAME = "Minecraft Forge Kotlin Template"
    const val VERSION = "2019.1-1.2.23"

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
            event.registry.register(ItemBlock(MySpecialBlock).setRegistryName(MOD_ID, "myBlock"))
            event.registry.register(MySpecialItem.setRegistryName(MOD_ID, "mySpecialItem"))
            */
        }

        /**
         * Listen for the register event for creating custom blocks
         */
        @SubscribeEvent
        fun addBlocks(event: RegistryEvent.Register<Block>) {
            /*
            event.registry.register(MySpecialBlock.setRegistryName(MOD_ID, "mySpecialBlock"))
            */
        }
    }

    /* EXAMPLE ITEM AND BLOCK - you probably want these in separate files
    object MySpecialItem : Item() {

    }

    object MySpecialBlock : Block() {

    }
    */
}
