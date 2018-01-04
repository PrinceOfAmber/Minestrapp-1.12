package minestrapp.item;

import java.util.Random;

import minestrapp.MBlocks;
import minestrapp.MItems;
import minestrapp.item.util.ItemBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemHangGlider extends ItemBase
{
	public ItemHangGlider(String name)
	{
		super(name);
		this.setMaxStackSize(1);
		this.setMaxDamage(200);
	}
	
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        return repair.getItem() == MItems.tech_components && repair.getMetadata() == 1;
    }
	
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		if(entityIn instanceof EntityLivingBase && (isSelected || (entityIn instanceof EntityPlayer && ((EntityPlayer)entityIn).getHeldItemOffhand() == stack)))
		{
			Random rand = new Random();
			EntityLivingBase living = (EntityLivingBase) entityIn;
			double absX = Math.abs(living.motionX);
			double absZ = Math.abs(living.motionZ);
			if(living.isElytraFlying())
			{
				living.motionX *= 0.8D;
				living.motionZ *= 0.8D;
				if(absX < 0.05F || absZ < 0.05F)
					living.collidedHorizontally = true;
			}
			else
			{
				living.motionY *= 0.7D;
				if(living.fallDistance > 0)
				{
					living.fallDistance = 0;
					if(!worldIn.isRemote && rand.nextInt(200) == 1)
						stack.damageItem(1, living);
				}
	
				for (int i = 5; i > 0; i--)
				{
					BlockPos pos = new BlockPos(living.posX, living.posY - i, living.posZ);
					if (worldIn.getBlockState(pos).getBlock() == Blocks.LAVA
					 || worldIn.getBlockState(pos).getBlock() == Blocks.FLOWING_LAVA
					 || worldIn.getBlockState(pos).getBlock() == Blocks.MAGMA
					 || worldIn.getBlockState(pos).getBlock() == Blocks.FIRE
					 || worldIn.getBlockState(pos).getBlock() == MBlocks.block_blazium
					 || worldIn.getBlockState(pos).getBlock() == MBlocks.bauble_blazium)
					{
						living.motionY += (5 - i) * 0.01D;
						if (rand.nextInt(70) == 1)
							stack.damageItem(1, living);
					}
					/*else if (worldIn.getBlockState(pos).getBlock() == MBlocks.fan)
					{
						if (entityplayer.motionY <= 0)
							entityplayer.motionY += 0.1;
						else
							entityplayer.motionY += ((0.01 * Chance.randomNumber(i, 8)) * (5 - Chance.randomNumber(-i, i)));
					}*/
				}
				if (absX < 0.15D)
				{
					living.motionX *= 1.06D;
				}
				else if (absX < 0.9D)
				{
					living.motionX *= 1.1D;
				}
	
				if (absZ < 0.15D)
				{
					living.motionZ *= 1.06D;
				}
				else if (absZ < 0.9D)
				{
					living.motionZ *= 1.1D;
				}
			}
		}
    }
}
