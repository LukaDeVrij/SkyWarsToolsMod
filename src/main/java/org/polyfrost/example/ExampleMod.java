package org.polyfrost.example;

import net.fabricmc.api.ClientModInitializer;
import org.polyfrost.example.command.ExampleCommand;
import org.polyfrost.example.config.ExampleConfig;
import org.polyfrost.oneconfig.api.commands.v1.CommandManager;

/**
 * The entrypoint of the Example Mod which initializes it.
 * This is what is run when the game is started and typically how your mod will set up its functionality.
 *
 * @see ClientModInitializer
 */
public class ExampleMod implements ClientModInitializer {

    // Sets the variables from `gradle.properties`. Depends on the `bloom` DGT plugin.
    public static final String ID = "@MOD_ID@";
    public static final String NAME = "@MOD_NAME@";
    public static final String VERSION = "@MOD_VERSION@";

    public static ExampleMod INSTANCE; // Adds the instance of the mod, so we can access other variables.

    public ExampleMod() {
        INSTANCE = this;
    }

    // Register the config and commands.
    @Override
    public void onInitializeClient() {
        ExampleConfig.INSTANCE.preload();
        CommandManager.registerCommand(new ExampleCommand());
    }
}
