package com.lifelessnerd.skywarstoolsmod.hud;

import cc.polyfrost.oneconfig.hud.SingleTextHud;
import com.lifelessnerd.skywarstoolsmod.utils.MessagePattern;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LastGameExperience extends SingleTextHud {

    public int lastXP = 0;

    public LastGameExperience() {
        super("§6EXP Last Game", true);
        this.ignoreCaching = true;
        this.paddingX = 10f;
    }

    @Override
    protected String getText(boolean example) {
        return "§f" + lastXP;
    }

    @SubscribeEvent
    // On addition chat event
    public void onAdditionChat(ClientChatReceivedEvent event) {
        if (MessagePattern.isValidExperienceMessage(event.message)) {
            Matcher matcher = Pattern.compile("\\+(\\d+) SkyWars Experience").matcher(event.message.getUnformattedText());
            int amount = matcher.find() ? Integer.parseInt(matcher.group(1)) : -1;
            lastXP += amount;

        }
        System.out.println(this.isCachingIgnored());

    }

    @SubscribeEvent
    // On won game chat event or you died chat event
    public void onGameEndChat(ClientChatReceivedEvent event) {
        if (MessagePattern.isGameEndMessage(event.message)) {
            this.enabled = true;
        }
    }

    @SubscribeEvent
    // Reset chat events
    public void onResetChat(ClientChatReceivedEvent event) {
        if (MessagePattern.isValidResetMessage(event.message)) {
            lastXP = 0;
            this.enabled = false;
        }
    }

}
