package com.kokos.client.mixin;

import com.kokos.client.ClickGUIScreen;
import com.kokos.client.KeyBindManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class MixinInGameHud {
    @Inject(method = "render", at = @At("HEAD"))
    private void onRender(CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (KeyBindManager.openMenuKey.wasPressed()) {
            if (!(client.currentScreen instanceof ClickGUIScreen)) {
                client.setScreen(new ClickGUIScreen());
            }
        }
    }
}
