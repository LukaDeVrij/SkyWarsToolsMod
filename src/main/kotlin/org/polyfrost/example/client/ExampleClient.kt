package org.polyfrost.example.client

import org.polyfrost.oneconfig.api.commands.v1.CommandManager

object ExampleClient {

    fun initialize() {
        ExampleConfig.preload()
        CommandManager.register(ExampleCommand)
    }

}
