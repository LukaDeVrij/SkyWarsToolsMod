package com.lifelessnerd.skywarstoolsmod.config;

import cc.polyfrost.oneconfig.config.annotations.Page;
import cc.polyfrost.oneconfig.config.annotations.Switch;
import cc.polyfrost.oneconfig.config.data.PageLocation;
import com.lifelessnerd.skywarstoolsmod.SkyWarsToolsMod;
import com.lifelessnerd.skywarstoolsmod.config.pages.LastGameEXPPage;
import com.lifelessnerd.skywarstoolsmod.hud.LastGameEXPHud;
import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.HUD;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;

/**
 * The main Config entrypoint that extends the Config type and inits the config options.
 * See <a href="https://docs.polyfrost.cc/oneconfig/config/adding-options">this link</a> for more config Options
 */
public class SWTConfig extends Config {
    @HUD(
            name = "Example HUD"
    )
    public LastGameEXPHud lastGameEXPHud = new LastGameEXPHud();

    @Switch(
            name = "Only Show On Win/Death"
    )
    public static boolean onlyShowOnWinDeath = false; // The default value for the boolean Switch.

    @Page(
            name = "I'm a page button!",
            location = PageLocation.TOP,
            // optional description that is also displayed on the page button
            description = "Press me to open a new page!"
    )
    public static LastGameEXPPage pageToOpen = new LastGameEXPPage("Hello!");

    public SWTConfig() {
        super(new Mod(SkyWarsToolsMod.NAME, ModType.UTIL_QOL), SkyWarsToolsMod.MODID + ".json");
        initialize();
    }


}

