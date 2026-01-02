package com.lifelessnerd.skywarstoolsmod.hud;

import cc.polyfrost.oneconfig.hud.SingleTextHud;
import com.lifelessnerd.skywarstoolsmod.events.LastGameEXPEvent;

public class LastGameEXPHud extends SingleTextHud {

    public LastGameEXPHud() {
        super("§6EXP Last Game", true);
    }

    public void setVisibility(boolean visible){
        this.enabled = visible;
    }

    @Override
    protected String getText(boolean example) {
        return "§f" + LastGameEXPEvent.getLastXP();
    }
}

