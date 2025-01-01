package org.polyfrost.example

import net.fabricmc.api.ClientModInitializer
import org.polyfrost.example.command.ExampleCommand
import org.polyfrost.example.config.ExampleConfig
import org.polyfrost.oneconfig.api.commands.v1.CommandManager

/**
 * The entrypoint of the Example Mod which initializes it.
 * This is what is run when the game is started and typically how your mod will set up its functionality.
 *
 * @see ClientModInitializer
 */
object ExampleMod : ClientModInitializer {

    // Sets the variables from `gradle.properties`. Depends on the `bloom` DGT plugin.
    const val ID = "@MOD_ID@"
    const val NAME = "@MOD_NAME@"
    const val VERSION = "@MOD_VERSION@"

    // Register the config and commands.
    override fun onInitializeClient() {
        ExampleConfig.preload()
        CommandManager.registerCommand(ExampleCommand())
    }
}