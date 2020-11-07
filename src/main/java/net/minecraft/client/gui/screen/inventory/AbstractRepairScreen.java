package net.minecraft.client.gui.screen.inventory;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.AbstractRepairContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.IContainerListener;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class AbstractRepairScreen<T extends AbstractRepairContainer> extends ContainerScreen<T> implements IContainerListener
{
    private ResourceLocation field_238817_A_;

    public AbstractRepairScreen(T p_i232291_1_, PlayerInventory p_i232291_2_, ITextComponent p_i232291_3_, ResourceLocation p_i232291_4_)
    {
        super(p_i232291_1_, p_i232291_2_, p_i232291_3_);
        this.field_238817_A_ = p_i232291_4_;
    }

    protected void func_230453_j_()
    {
    }

    protected void init()
    {
        super.init();
        this.func_230453_j_();
        this.container.addListener(this);
    }

    public void onClose()
    {
        super.onClose();
        this.container.removeListener(this);
    }

    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks)
    {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        RenderSystem.disableBlend();
        this.func_230452_b_(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    protected void func_230452_b_(MatrixStack p_230452_1_, int p_230452_2_, int p_230452_3_, float p_230452_4_)
    {
    }

    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y)
    {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(this.field_238817_A_);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.blit(matrixStack, i, j, 0, 0, this.xSize, this.ySize);
        this.blit(matrixStack, i + 59, j + 20, 0, this.ySize + (this.container.getSlot(0).getHasStack() ? 0 : 16), 110, 16);

        if ((this.container.getSlot(0).getHasStack() || this.container.getSlot(1).getHasStack()) && !this.container.getSlot(2).getHasStack())
        {
            this.blit(matrixStack, i + 99, j + 45, this.xSize, 0, 28, 21);
        }
    }

    public void sendAllContents(Container containerToSend, NonNullList<ItemStack> itemsList)
    {
        this.sendSlotContents(containerToSend, 0, containerToSend.getSlot(0).getStack());
    }

    public void sendWindowProperty(Container containerIn, int varToUpdate, int newValue)
    {
    }

    public void sendSlotContents(Container containerToSend, int slotInd, ItemStack stack)
    {
    }
}
