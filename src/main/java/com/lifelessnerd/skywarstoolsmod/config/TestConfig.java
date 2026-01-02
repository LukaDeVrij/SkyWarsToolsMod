package com.lifelessnerd.skywarstoolsmod.config;

import cc.polyfrost.oneconfig.config.annotations.Switch;
import com.lifelessnerd.skywarstoolsmod.SkyWarsToolsMod;
import com.lifelessnerd.skywarstoolsmod.hud.LastGameEXPHud;
import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.HUD;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;

/**
 * The main Config entrypoint that extends the Config type and inits the config options.
 * See <a href="https://docs.polyfrost.cc/oneconfig/config/adding-options">this link</a> for more config Options
 */
public class TestConfig extends Config {
    @HUD(
            name = "Example HUD"
    )
    public LastGameEXPHud lastGameEXPHud = new LastGameEXPHud();

    @Switch(
            name = "Only Show On Win/Death"
    )
    public static boolean onlyShowOnWinDeath = false; // The default value for the boolean Switch.

//    @Slider(
//            name = "Example Slider",
//            min = 0f, max = 100f, // Minimum and maximum values for the slider.
//            step = 10 // The amount of steps that the slider should have.
//    )
//    public static float exampleSlider = 50f; // The default value for the float Slider.
//
//    @Dropdown(
//            name = "Example Dropdown", // Name of the Dropdown
//            options = {"Option 1", "Option 2", "Option 3", "Option 4"} // Options available.
//    )
//    public static int exampleDropdown = 1; // Default option (in this case "Option 2")

    public TestConfig() {
        super(new Mod(SkyWarsToolsMod.NAME, ModType.UTIL_QOL), SkyWarsToolsMod.MODID + ".json");
        initialize();
    }
}

