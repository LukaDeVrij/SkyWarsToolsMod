package com.lifelessnerd.skywarstoolsmod.hud;

import cc.polyfrost.oneconfig.hud.SingleTextHud;
import com.lifelessnerd.skywarstoolsmod.events.LastGameEXPEvent;

public class LastGameEXPHud extends SingleTextHud {

    private boolean lastEnabledState = true;

    public LastGameEXPHud() {
        super("§6EXP Last Game", true);
    }

    @Override
    protected String getText(boolean example) {
        // TODO this is stupid - we cannot set .enabled because when that becomes false getText is never run again
        if (LastGameEXPEvent.shouldBeVisible()) {
            this.scale = 0;
        } else {
            this.scale = 1;
        }
        return "§f" + LastGameEXPEvent.getLastXP();
    }
}

