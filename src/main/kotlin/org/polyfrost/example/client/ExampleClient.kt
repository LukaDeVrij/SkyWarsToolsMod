package org.polyfrost.example.client

import net.fabricmc.api.ClientModInitializer
import org.polyfrost.oneconfig.api.commands.v1.CommandManager

object ExampleClient : ClientModInitializer {

    override fun onInitializeClient() {
        ExampleConfig.preload()
        CommandManager.registerCommand(ExampleCommand)
    }

}
