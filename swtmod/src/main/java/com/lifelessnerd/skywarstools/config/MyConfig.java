package com.lifelessnerd.skywarstools.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.Switch;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import cc.polyfrost.oneconfig.config.data.OptionSize;

public class MyConfig extends Config {

    public MyConfig() {
        // Available mod types: PVP, HUD, UTIL_QOL, HYPIXEL, SKYBLOCK
        super(new Mod("SkyWarsToolsMod", ModType.PVP), "config.json");
        initialize();
    }

    @Switch(name = "A random switch", size = OptionSize.DUAL, // optional, declares whether the element is single column or dual column
            category = "General", // optional
            subcategory = "Switches" // optional
    )
    public static boolean bob = false; // this is the default value.
}
