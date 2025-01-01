package org.polyfrost.example;

import org.polyfrost.example.command.ExampleCommand;
import org.polyfrost.example.config.ExampleConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.polyfrost.oneconfig.api.commands.v1.CommandManager;

/**
 * The entrypoint of the Example Mod which initializes it.
 * This is what is run when the game is started and typically how your mod will set up its functionality.
 *
 * @see Mod
 */
@Mod(modid = ExampleMod.ID, name = ExampleMod.NAME, version = ExampleMod.VERSION)
public class ExampleMod {

    // Sets the variables from `gradle.properties`. Depends on the `bloom` DGT plugin.
    public static final String ID = "@MOD_ID@";
    public static final String NAME = "@MOD_NAME@";
    public static final String VERSION = "@MOD_VERSION@";

    @Mod.Instance(ID)
    public static ExampleMod INSTANCE; // Adds the instance of the mod, so we can access other variables.

    // Register the config and commands.
    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        ExampleConfig.INSTANCE.preload();
        CommandManager.registerCommand(new ExampleCommand());
    }
}
