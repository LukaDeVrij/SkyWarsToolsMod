package org.polyfrost.example.command;

import org.polyfrost.example.ExampleMod;
import org.polyfrost.oneconfig.api.commands.v1.factories.annotated.Command;
import org.polyfrost.oneconfig.utils.v1.dsl.ScreensKt;

/**
 * An example command implementing the Command api of OneConfig.
 * Registered in ExampleMod.java with `CommandManager.INSTANCE.registerCommand(new ExampleCommand());`
 *
 * @see Command
 * @see ExampleMod
 */
@Command(value = ExampleMod.ID, description = "Access the " + ExampleMod.NAME + " GUI.")
public class ExampleCommand {

    @Command
    private void handle() {
        ScreensKt.openUI(ExampleMod.getConfig());
    }

}
