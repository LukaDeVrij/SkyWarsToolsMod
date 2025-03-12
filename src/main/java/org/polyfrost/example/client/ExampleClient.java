package org.polyfrost.example.client;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.polyfrost.example.ExampleConstants;
import org.polyfrost.oneconfig.api.commands.v1.CommandManager;

@Mod(modid = ExampleConstants.ID, name = ExampleConstants.NAME, version = ExampleConstants.VERSION)
public class ExampleClient {

    @Mod.Instance(ExampleConstants.ID)
    public static ExampleClient INSTANCE;

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        ExampleConfig.INSTANCE.preload();
        CommandManager.register(new ExampleCommand());
    }

}
