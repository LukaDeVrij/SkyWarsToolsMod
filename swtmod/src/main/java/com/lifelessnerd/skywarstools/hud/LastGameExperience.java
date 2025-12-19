package com.lifelessnerd.skywarstools.hud;

import com.lifelessnerd.skywarstools.config.ConfigHandler;
import com.lifelessnerd.skywarstools.utils.MessagePattern;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class LastGameExperience {

    public int lastXP = 0;
    public boolean shouldRender = true;

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        // this method is called multiple times per frame, you want to filter it
        // by checking the event type to only render your HUD once per frame
        if (event.type == RenderGameOverlayEvent.ElementType.TEXT) {
            this.drawHUD(event.resolution);
        }
    }

    @SubscribeEvent
    // On addition chat event
    public void onAdditionChat(ClientChatReceivedEvent event) {

        if (MessagePattern.isValidExperienceMessage(event.message)) {
            System.out.println("Valid!");
            Matcher matcher = Pattern.compile("\\+(\\d+) SkyWars Experience").matcher(event.message.getUnformattedText());
            int amount = matcher.find() ? Integer.parseInt(matcher.group(1)) : -1;
            System.out.println(amount);
            lastXP += amount;
        }

    }

    @SubscribeEvent
    // On won game chat event or you died chat event
    public void onGameEndChat(ClientChatReceivedEvent event) {
        if (MessagePattern.isGameEndMessage(event.message)) {
            shouldRender = true;
        }

    }

    @SubscribeEvent
    // Reset chat events
    public void onResetChat(ClientChatReceivedEvent event) {
        if (MessagePattern.isValidResetMessage(event.message)) {
            lastXP = 0;
            shouldRender = false;
        }
    }

    private void drawHUD(ScaledResolution resolution) {

        // TODO check conditional and implement config value to coincide with experienceShowTemp:
        // "Only show the display when you die or win a game, instead of always"
         if (shouldRender && !ConfigHandler.exampleBooleanSetting) {
            // when drawing a HUD, the coordinates (x, y) represent a point on your screen
            // coordinates (0, 0) is top left of your screen,
            // coordinates (screenWidth, screenHeight) is bottom right of your screen
            final int top = 5;
            final int right = resolution.getScaledWidth();

            final FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;

            // for example here we draw text on the screen
            final String text = "§6EXP Last Game: §d" + String.valueOf(lastXP);
            fr.drawStringWithShadow(text, (right - fr.getStringWidth(text)) - 5, top, 0xFFFFFF);
        }

    }

}
