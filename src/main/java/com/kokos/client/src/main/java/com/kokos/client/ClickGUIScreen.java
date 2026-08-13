package com.kokos.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGUIScreen extends Screen {
    private int guiX = 100, guiY = 100;
    private int guiWidth = 280, guiHeight = 320;

    protected ClickGUIScreen() {
        super(Text.literal("KokosClient Menu"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Затемнение фона
        context.fill(0, 0, this.width, this.height, 0x80000000);

        // Тень
        context.fill(guiX + 5, guiY + 5, guiX + guiWidth + 5, guiY + guiHeight + 5, 0x40000000);

        // Фон с градиентом (кокосовый стиль — коричнево-бежевый)
        context.fillGradient(guiX, guiY, guiX + guiWidth, guiY + guiHeight, 0xFF3E2723, 0xFF5D4037);

        // Шапка с золотым оттенком
        context.fill(guiX, guiY, guiX + guiWidth, guiY + 30, 0xFFFFD54F);
        context.fill(guiX, guiY + 30, guiX + guiWidth, guiY + 32, 0xFFFFAB00);

        // Рамка
        context.drawBorder(guiX, guiY, guiWidth, guiHeight, 0xFFFFD54F);

        // Заголовок
        context.drawCenteredTextWithShadow(textRenderer, 
            Text.literal("🥥 §6§lKOKOSCLIENT"), 
            guiX + guiWidth / 2, guiY + 8, 0xFFFFFFFF
        );

        // Просто красивая надпись по центру
        context.drawCenteredTextWithShadow(textRenderer,
            Text.literal("§7✧ ДОБРО ПОЖАЛОВАТЬ ✧"),
            guiX + guiWidth / 2, guiY + 80, 0xAAAAAA
        );

        context.drawCenteredTextWithShadow(textRenderer,
            Text.literal("§7Твой красивый кокосовый чит"),
            guiX + guiWidth / 2, guiY + 110, 0x888888
        );

        // Подпись внизу
        context.drawTextWithShadow(textRenderer, 
            Text.literal("§7§oESC — закрыть"), 
            guiX + 15, guiY + guiHeight - 22, 0xFFAAAAAA
        );

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 256) { // ESC
            this.close();
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
