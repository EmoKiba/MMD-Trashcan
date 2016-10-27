package kiba.trashcan;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiTrashCan extends GuiContainer {
    public GuiTrashCan(Container container){
        super(container);
        this.xSize = 210;
        this.ySize = 204;
        this.guiLeft = ((this.width-this.xSize) /2);
        this.guiTop = ((this.height-this.ySize)/2);

    }
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        this.mc.getTextureManager().bindTexture(new ResourceLocation(TrashCan.MODID,"textures/guis/trash_can.png"));
        drawTexturedModalRect(this.guiLeft,this.guiTop,0,0,this.xSize,this.ySize);
    }
}

