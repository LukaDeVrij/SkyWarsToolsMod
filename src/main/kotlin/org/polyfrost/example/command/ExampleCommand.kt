package org.polyfrost.example.command

import org.polyfrost.example.ExampleMod
import org.polyfrost.example.config.ExampleConfig
import org.polyfrost.oneconfig.api.commands.v1.factories.annotated.Command
import org.polyfrost.oneconfig.utils.v1.dsl.openUI

/**
 * An example command implementing the Command API of OneConfig.
 * Registered in ExampleMod.kt with `CommandManager.INSTANCE.registerCommand(new ExampleCommand());`
 *
 * @see Command
 * @see ExampleMod
 */
@Command(value = [ExampleMod.ID], description = "Access the ${ExampleMod.NAME} GUI.")
class ExampleCommand {
    @Command
    private fun main() {
        ExampleConfig.openUI()
    }
}