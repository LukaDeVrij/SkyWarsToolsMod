package org.polyfrost.example.client

import net.minecraftforge.fml.common.Mod
import org.polyfrost.example.ExampleConstants
import org.polyfrost.oneconfig.api.commands.v1.CommandManager

@Mod(modid = ExampleConstants.ID, name = ExampleConstants.NAME, version = ExampleConstants.VERSION, modLanguageAdapter = "org.polyfrost.oneconfig.utils.v1.forge.KotlinLanguageAdapter")
object ExampleClient {

    @Mod.EventHandler
    fun initialize() {
        ExampleConfig.preload()
        CommandManager.register(ExampleCommand)
    }

}
