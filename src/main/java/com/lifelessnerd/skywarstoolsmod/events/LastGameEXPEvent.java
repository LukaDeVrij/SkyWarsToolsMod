package com.lifelessnerd.skywarstoolsmod.events;

import com.lifelessnerd.skywarstoolsmod.config.SWTConfig;
import com.lifelessnerd.skywarstoolsmod.hud.LastGameEXP;
import com.lifelessnerd.skywarstoolsmod.utils.MessagePattern;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LastGameEXPEvent {

    private static final Pattern XP_PATTERN =
            Pattern.compile("\\+(\\d+) SkyWars Experience");

    private static int lastXP = 0;

    public static int getLastXP() {
        return lastXP;
    }

    @SubscribeEvent
    public void onAdditionChat(ClientChatReceivedEvent event) {
        if (!MessagePattern.isValidExperienceMessage(event.message)) return;

        Matcher matcher = XP_PATTERN.matcher(event.message.getUnformattedText());
        if (matcher.find()) {
            lastXP += Integer.parseInt(matcher.group(1));
        }
    }

    @SubscribeEvent
    public void onGameEndChat(ClientChatReceivedEvent event) {
        if (MessagePattern.isGameEndMessage(event.message)) {
            SWTConfig.lastGameEXP.lastGameEXPHud.setVisibility(true);
        }
    }

    @SubscribeEvent
    public void onResetChat(ClientChatReceivedEvent event) {
        if (MessagePattern.isValidResetMessage(event.message)) {
            lastXP = 0;
            if (SWTConfig.lastGameEXP.lastGameEXPHud.onlyShowOnWinDeath) {
                SWTConfig.lastGameEXP.lastGameEXPHud.setVisibility(false);
            }

        }
    }
}
