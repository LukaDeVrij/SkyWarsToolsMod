package org.polyfrost.example

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import org.polyfrost.example.command.ExampleCommand
import org.polyfrost.example.config.ExampleConfig
import org.polyfrost.oneconfig.api.commands.v1.CommandManager

/**
 * The entrypoint of the Example Mod which initializes it.
 * This is what is run when the game is started and typically how your mod will set up its functionality.
 *
 * @see Mod
 */
@Mod(modid = ExampleMod.ID, name = ExampleMod.NAME, version = ExampleMod.VERSION, modLanguageAdapter = "org.polyfrost.oneconfig.utils.v1.forge.KotlinLanguageAdapter")
object ExampleMod {

    // Sets the variables from `gradle.properties`. Depends on the `bloom` DGT plugin.
    const val ID = "@MOD_ID@"
    const val NAME = "@MOD_NAME@"
    const val VERSION = "@MOD_VERSION@"

    // Register the config and commands.
    @Mod.EventHandler
    fun onInit(event: FMLInitializationEvent) {
        ExampleConfig.preload()
        CommandManager.registerCommand(ExampleCommand())
    }
}