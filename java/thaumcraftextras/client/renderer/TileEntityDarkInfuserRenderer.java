package thaumcraftextras.client.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

import thaumcraftextras.blocks.tileEntity.TileEntityDarkInfuser;

public class TileEntityDarkInfuserRenderer extends TileEntitySpecialRenderer {


@Override
public void renderTileEntityAt(TileEntity tileentity, double d0, double d1,
double d2, float f) {

         TileEntityDarkInfuser infuser = ((TileEntityDarkInfuser) tileentity);
         if (infuser.getStackInSlot(0) != null && infuser.hasResult(infuser.getStackInSlot(0).getItem()) == true) {
        	 EntityItem entityitem = null;
        		float ticks = Minecraft.getMinecraft().renderViewEntity.ticksExisted + f;
        		GL11.glPushMatrix();
        		float h = MathHelper.sin(ticks % 32767.0F / 16.0F) * 0.05F;
        		GL11.glTranslatef((float)d0 + 0.5F, (float)d1 + 1.15F + h, (float)d2 + 0.5F);
        		GL11.glRotatef(ticks % 360.0F, 0.0F, 1.0F, 0.0F);
        		if (((infuser.getStackInSlot(0).getItem() instanceof ItemBlock)) && (infuser.getStackInSlot(0).itemID < Block.blocksList.length)) {
        		GL11.glScalef(2.0F, 2.0F, 2.0F);
        		} else {
        		GL11.glScalef(1.0F, 1.0F, 1.0F);
        		}
        		ItemStack ist = new ItemStack(infuser.getResult(infuser.getStackInSlot(0).getItem()), 1, 0).copy();
        		ist.stackSize = 1;
        		entityitem = new EntityItem(infuser.worldObj, 0.0D, 0.0D, 0.0D, ist);
        		entityitem.hoverStart = 0.0F;
        		if (infuser.getStackInSlot(0).stackSize == 0) {
        		GL11.glEnable(3042);
        		GL11.glBlendFunc(770, 1);
        		GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.85F);
        		}
        		RenderManager.instance.renderEntityWithPosYaw(entityitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
        		if (!Minecraft.isFancyGraphicsEnabled())
        		{
        		GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
        		RenderManager.instance.renderEntityWithPosYaw(entityitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
        		}
        		GL11.glDisable(3042);
        		GL11.glPopMatrix();
         }
}

}