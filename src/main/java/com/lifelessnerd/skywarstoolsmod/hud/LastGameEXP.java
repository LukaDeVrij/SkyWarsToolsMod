package com.lifelessnerd.skywarstoolsmod.hud;

import cc.polyfrost.oneconfig.config.annotations.HUD;
import cc.polyfrost.oneconfig.config.annotations.Switch;
import cc.polyfrost.oneconfig.config.elements.SubConfig;
import cc.polyfrost.oneconfig.hud.SingleTextHud;
import com.lifelessnerd.skywarstoolsmod.events.LastGameEXPEvent;

public class LastGameEXP extends SubConfig {
    @HUD(
            name = "Last Game EXP HUD"
    )
    public LastGameEXPHud lastGameEXPHud = new LastGameEXPHud();

    public LastGameEXP(String name, String configFile, String icon, boolean enabled) {
        super(name, configFile, icon, enabled);
        System.out.println("Initialized module LastGameEXP");
    }

    public class LastGameEXPHud extends SingleTextHud {

        @Switch(
                name = "Only Show On Win/Death"
        )
        public boolean onlyShowOnWinDeath = false;

        public LastGameEXPHud() {
            super("§6EXP Last Game", true);
            System.out.println("Initialized LastGameEXP HUD");
        }

        public void setVisibility(boolean visible) {
            this.enabled = visible;
        }

        @Override
        protected String getText(boolean example) {
            return "§f" + LastGameEXPEvent.getLastXP();
        }
    }
}
