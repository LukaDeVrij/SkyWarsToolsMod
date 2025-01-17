package org.polyfrost.example.client

import org.polyfrost.example.ExampleConstants
import org.polyfrost.oneconfig.api.commands.v1.factories.annotated.Command
import org.polyfrost.oneconfig.utils.v1.dsl.openUI

@Command(value = [ExampleConstants.ID], description = "Access the ${ExampleConstants.NAME} GUI.")
object ExampleCommand {

    @Command
    private fun main() {
        ExampleConfig.openUI()
    }

}
