package org.polyfrost.example.client

import org.polyfrost.example.ExampleConstants
import org.polyfrost.oneconfig.api.commands.v1.factories.annotated.Command
import org.polyfrost.oneconfig.utils.v1.dsl.openUI

@Command(ExampleConstants.ID)
object ExampleCommand {

    @Command
    private fun main() {
        ExampleConfig.openUI()
    }

}
