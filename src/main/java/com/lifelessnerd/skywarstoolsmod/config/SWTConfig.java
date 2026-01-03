package com.lifelessnerd.skywarstoolsmod.config;

import cc.polyfrost.oneconfig.config.annotations.SubConfig;
import com.lifelessnerd.skywarstoolsmod.SkyWarsToolsMod;
import com.lifelessnerd.skywarstoolsmod.hud.LastGameEXP;
import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;

public class SWTConfig extends Config {

    @SubConfig
    public static LastGameEXP lastGameEXP =
            new LastGameEXP("Last Game EXP", "swt/lge.json", null, true);

    public SWTConfig() {
        super(new Mod(SkyWarsToolsMod.NAME, ModType.UTIL_QOL), SkyWarsToolsMod.MODID + ".json");
        initialize();
    }
}

