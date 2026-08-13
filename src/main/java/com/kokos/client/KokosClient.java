package com.kokos.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class KokosClient implements ClientModInitializer {
    public static final String NAME = "KokosClient";
    public static final String VERSION = "1.0.0";

    @Override
    public void onInitializeClient() {
        System.out.println(NAME + " v" + VERSION + " загружен! 🥥");
        KeyBindManager.register();
        
        ClientTickEvents.END_WORLD_TICK.register(world -> {
            if (MinecraftClient.getInstance().player != null) {
                MinecraftClient.getInstance().player.sendMessage(
                    Text.literal("§b§l" + NAME + " §fv" + VERSION + " §aзагружен! §7Нажми Right Shift"),
                    false
                );
                ClientTickEvents.END_WORLD_TICK.unregister(this);
            }
        });
    }
}
