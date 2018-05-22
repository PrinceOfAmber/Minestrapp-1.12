package minestrapp.proxy;

import javax.annotation.Nullable;

import minestrapp.MBlocks;
import minestrapp.MItems;
import minestrapp.Minestrapp5;
import minestrapp.block.BlockBiomeRedstoneWire;
import minestrapp.block.tileentity.TileEntityMagnetPiston;
import minestrapp.block.tileentity.renderer.TileEntityMagnetPistonRenderer;
import minestrapp.entity.render.RenderMBoat;
import minestrapp.entity.vehicle.EntityMBoat;
import minestrapp.mobs.registry.MobRegistry;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ClientProxy extends CommonProxy
{
	private static final Minecraft minecraft = Minecraft.getMinecraft();
	
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
		MBlocks.registerRenders();
		MItems.registerRenders();
		registerRenderers();
		registerEntities();
	}
	
	public void init(FMLInitializationEvent event)
	{
		super.init(event);/*
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.lava_sponge), new ResourceLocation(Minestrapp5.MODID, "lava_sponge_dry"), new ResourceLocation(Minestrapp5.MODID, "lava_sponge_wet"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.cold_sand), new ResourceLocation(Minestrapp5.MODID, "cold_sand_default"), new ResourceLocation(Minestrapp5.MODID, "cold_sand_red"));
		//ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.clay_soil), new ResourceLocation(Minestrapp5.MODID, "clay_soil_default"), new ResourceLocation(Minestrapp5.MODID, "clay_soil_course"), new ResourceLocation(Minestrapp5.MODID, "clay_soil_podzol"));
		//ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.permafrost), new ResourceLocation(Minestrapp5.MODID, "permafrost_default"), new ResourceLocation(Minestrapp5.MODID, "permafrost_course"), new ResourceLocation(Minestrapp5.MODID, "permafrost_podzol"));
		//ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.portal_dust), new ResourceLocation(Minestrapp5.MODID, "portal_dust_default"), new ResourceLocation(Minestrapp5.MODID, "portal_dust_course"), new ResourceLocation(Minestrapp5.MODID, "portal_dust_podzol"));	
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.log), new ResourceLocation(Minestrapp5.MODID, "m_log_redwood"), new ResourceLocation(Minestrapp5.MODID, "m_log_frozen_oak"), new ResourceLocation(Minestrapp5.MODID, "m_log_charwood"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.planks), new ResourceLocation(Minestrapp5.MODID, "m_planks_redwood"), new ResourceLocation(Minestrapp5.MODID, "m_planks_frozen_oak"), new ResourceLocation(Minestrapp5.MODID, "m_planks_charwood"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.mossy_m_planks), new ResourceLocation(Minestrapp5.MODID, "m_planks_mossy_redwood"), new ResourceLocation(Minestrapp5.MODID, "m_planks_mossy_frozen_oak"), new ResourceLocation(Minestrapp5.MODID, "m_planks_mossy_charwood"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.decor_stone), new ResourceLocation(Minestrapp5.MODID, "decor_stone_granite_bricks"), new ResourceLocation(Minestrapp5.MODID, "decor_stone_granite_tiles"), new ResourceLocation(Minestrapp5.MODID, "decor_stone_diorite_bricks"), new ResourceLocation(Minestrapp5.MODID, "decor_stone_diorite_tiles"), new ResourceLocation(Minestrapp5.MODID, "decor_stone_andesite_bricks"), new ResourceLocation(Minestrapp5.MODID, "decor_stone_andesite_tiles"), new ResourceLocation(Minestrapp5.MODID, "decor_stone_slate"), new ResourceLocation(Minestrapp5.MODID, "decor_stone_polished_slate"), new ResourceLocation(Minestrapp5.MODID, "decor_stone_slate_bricks"), new ResourceLocation(Minestrapp5.MODID, "decor_stone_slate_tiles"));	
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.stone), new ResourceLocation(Minestrapp5.MODID, "m_stone_red_rock"), new ResourceLocation(Minestrapp5.MODID, "m_stone_deep_red_rock"), new ResourceLocation(Minestrapp5.MODID, "m_stone_deepstone"), new ResourceLocation(Minestrapp5.MODID, "m_stone_coldstone"), new ResourceLocation(Minestrapp5.MODID, "m_stone_deep_coldstone"), new ResourceLocation(Minestrapp5.MODID, "m_stone_icestone"), new ResourceLocation(Minestrapp5.MODID, "m_stone_glacierrock"), new ResourceLocation(Minestrapp5.MODID, "m_stone_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "m_stone_deep_oceanstone"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.cobblestone), new ResourceLocation(Minestrapp5.MODID, "m_cobblestone_red_rock"), new ResourceLocation(Minestrapp5.MODID, "m_cobblestone_deep_red_rock"), new ResourceLocation(Minestrapp5.MODID, "m_cobblestone_deepstone"), new ResourceLocation(Minestrapp5.MODID, "m_cobblestone_coldstone"), new ResourceLocation(Minestrapp5.MODID, "m_cobblestone_deep_coldstone"), new ResourceLocation(Minestrapp5.MODID, "m_cobblestone_icestone"), new ResourceLocation(Minestrapp5.MODID, "m_cobblestone_glacierrock"), new ResourceLocation(Minestrapp5.MODID, "m_cobblestone_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "m_cobblestone_deep_oceanstone"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.mossy_cobblestone), new ResourceLocation(Minestrapp5.MODID, "m_mossy_cobblestone_red_rock"), new ResourceLocation(Minestrapp5.MODID, "m_mossy_cobblestone_deep_red_rock"), new ResourceLocation(Minestrapp5.MODID, "m_mossy_cobblestone_deepstone"), new ResourceLocation(Minestrapp5.MODID, "m_mossy_cobblestone_coldstone"), new ResourceLocation(Minestrapp5.MODID, "m_mossy_cobblestone_deep_coldstone"), new ResourceLocation(Minestrapp5.MODID, "m_mossy_cobblestone_icestone"), new ResourceLocation(Minestrapp5.MODID, "m_mossy_cobblestone_glacierrock"), new ResourceLocation(Minestrapp5.MODID, "m_mossy_cobblestone_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "m_mossy_cobblestone_deep_oceanstone"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.stone_bricks), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_red_rock"), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_deep_red_rock"), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_deepstone"), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_coldstone"), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_deep_coldstone"), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_icestone"), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_glacierrock"), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_deep_oceanstone"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.mossy_stone_bricks), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_mossy_red_rock"), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_mossy_deep_red_rock"), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_mossy_deepstone"), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_mossy_coldstone"), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_mossy_deep_coldstone"), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_mossy_icestone"), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_mossy_glacierrock"), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_mossy_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_mossy_deep_oceanstone"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.cracked_stone_bricks), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_cracked_red_rock"), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_cracked_deep_red_rock"), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_cracked_deepstone"), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_cracked_coldstone"), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_cracked_deep_coldstone"), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_cracked_icestone"), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_cracked_glacierrock"), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_cracked_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "m_stone_bricks_cracked_deep_oceanstone"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.chiseled_stone), new ResourceLocation(Minestrapp5.MODID, "m_chiseled_stone_red_rock"), new ResourceLocation(Minestrapp5.MODID, "m_chiseled_stone_deep_red_rock"), new ResourceLocation(Minestrapp5.MODID, "m_chiseled_stone_deepstone"), new ResourceLocation(Minestrapp5.MODID, "m_chiseled_stone_coldstone"), new ResourceLocation(Minestrapp5.MODID, "m_chiseled_stone_deep_coldstone"), new ResourceLocation(Minestrapp5.MODID, "m_chiseled_stone_icestone"), new ResourceLocation(Minestrapp5.MODID, "m_chiseled_stone_glacierrock"), new ResourceLocation(Minestrapp5.MODID, "m_chiseled_stone_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "m_chiseled_stone_deep_oceanstone"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.portar), new ResourceLocation(Minestrapp5.MODID, "portar_slabbed"), new ResourceLocation(Minestrapp5.MODID, "portar_fishboned"), new ResourceLocation(Minestrapp5.MODID, "portar_tiled"), new ResourceLocation(Minestrapp5.MODID, "portar_chiseled"), new ResourceLocation(Minestrapp5.MODID, "portar_lamp_sunstone"), new ResourceLocation(Minestrapp5.MODID, "portar_lamp_glowstone"), new ResourceLocation(Minestrapp5.MODID, "portar_lamp_sea"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.ore_salt), new ResourceLocation(Minestrapp5.MODID, "ore_salt_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_salt_deep_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_salt_deepstone"), new ResourceLocation(Minestrapp5.MODID, "ore_salt_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_salt_deep_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_salt_icestone"), new ResourceLocation(Minestrapp5.MODID, "ore_salt_glacierrock"), new ResourceLocation(Minestrapp5.MODID, "ore_salt_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "ore_salt_deep_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "ore_salt_stone"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.ore_coal), new ResourceLocation(Minestrapp5.MODID, "ore_coal_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_coal_deep_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_coal_deepstone"), new ResourceLocation(Minestrapp5.MODID, "ore_coal_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_coal_deep_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_coal_icestone"), new ResourceLocation(Minestrapp5.MODID, "ore_coal_glacierrock"), new ResourceLocation(Minestrapp5.MODID, "ore_coal_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "ore_coal_deep_oceanstone"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.ore_copper), new ResourceLocation(Minestrapp5.MODID, "ore_copper_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_copper_deep_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_copper_deepstone"), new ResourceLocation(Minestrapp5.MODID, "ore_copper_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_copper_deep_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_copper_icestone"), new ResourceLocation(Minestrapp5.MODID, "ore_copper_glacierrock"), new ResourceLocation(Minestrapp5.MODID, "ore_copper_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "ore_copper_deep_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "ore_copper_stone"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.ore_tin), new ResourceLocation(Minestrapp5.MODID, "ore_tin_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_tin_deep_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_tin_deepstone"), new ResourceLocation(Minestrapp5.MODID, "ore_tin_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_tin_deep_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_tin_icestone"), new ResourceLocation(Minestrapp5.MODID, "ore_tin_glacierrock"), new ResourceLocation(Minestrapp5.MODID, "ore_tin_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "ore_tin_deep_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "ore_tin_stone"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.ore_iron), new ResourceLocation(Minestrapp5.MODID, "ore_iron_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_iron_deep_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_iron_deepstone"), new ResourceLocation(Minestrapp5.MODID, "ore_iron_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_iron_deep_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_iron_icestone"), new ResourceLocation(Minestrapp5.MODID, "ore_iron_glacierrock"), new ResourceLocation(Minestrapp5.MODID, "ore_iron_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "ore_iron_deep_oceanstone"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.ore_gold), new ResourceLocation(Minestrapp5.MODID, "ore_gold_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_gold_deep_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_gold_deepstone"), new ResourceLocation(Minestrapp5.MODID, "ore_gold_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_gold_deep_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_gold_icestone"), new ResourceLocation(Minestrapp5.MODID, "ore_gold_glacierrock"), new ResourceLocation(Minestrapp5.MODID, "ore_gold_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "ore_gold_deep_oceanstone"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.ore_meurodite), new ResourceLocation(Minestrapp5.MODID, "ore_meurodite_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_meurodite_deep_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_meurodite_deepstone"), new ResourceLocation(Minestrapp5.MODID, "ore_meurodite_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_meurodite_deep_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_meurodite_icestone"), new ResourceLocation(Minestrapp5.MODID, "ore_meurodite_glacierrock"), new ResourceLocation(Minestrapp5.MODID, "ore_meurodite_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "ore_meurodite_deep_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "ore_meurodite_stone"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.ore_lapis), new ResourceLocation(Minestrapp5.MODID, "ore_lapis_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_lapis_deep_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_lapis_deepstone"), new ResourceLocation(Minestrapp5.MODID, "ore_lapis_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_lapis_deep_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_lapis_icestone"), new ResourceLocation(Minestrapp5.MODID, "ore_lapis_glacierrock"), new ResourceLocation(Minestrapp5.MODID, "ore_lapis_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "ore_lapis_deep_oceanstone"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.ore_redstone), new ResourceLocation(Minestrapp5.MODID, "ore_redstone_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_redstone_deep_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_redstone_deepstone"), new ResourceLocation(Minestrapp5.MODID, "ore_redstone_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_redstone_deep_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_redstone_icestone"), new ResourceLocation(Minestrapp5.MODID, "ore_redstone_glacierrock"), new ResourceLocation(Minestrapp5.MODID, "ore_redstone_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "ore_redstone_deep_oceanstone"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.ore_irradium), new ResourceLocation(Minestrapp5.MODID, "ore_irradium_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_irradium_deep_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_irradium_deepstone"), new ResourceLocation(Minestrapp5.MODID, "ore_irradium_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_irradium_deep_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_irradium_icestone"), new ResourceLocation(Minestrapp5.MODID, "ore_irradium_glacierrock"), new ResourceLocation(Minestrapp5.MODID, "ore_irradium_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "ore_irradium_deep_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "ore_irradium_stone"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.ore_torite), new ResourceLocation(Minestrapp5.MODID, "ore_torite_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_torite_deep_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_torite_deepstone"), new ResourceLocation(Minestrapp5.MODID, "ore_torite_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_torite_deep_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_torite_icestone"), new ResourceLocation(Minestrapp5.MODID, "ore_torite_glacierrock"), new ResourceLocation(Minestrapp5.MODID, "ore_torite_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "ore_torite_deep_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "ore_torite_stone"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.ore_diamond), new ResourceLocation(Minestrapp5.MODID, "ore_diamond_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_diamond_deep_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_diamond_deepstone"), new ResourceLocation(Minestrapp5.MODID, "ore_diamond_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_diamond_deep_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_diamond_icestone"), new ResourceLocation(Minestrapp5.MODID, "ore_diamond_glacierrock"), new ResourceLocation(Minestrapp5.MODID, "ore_diamond_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "ore_diamond_deep_oceanstone"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.ore_emerald), new ResourceLocation(Minestrapp5.MODID, "ore_emerald_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_emerald_deep_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_emerald_deepstone"), new ResourceLocation(Minestrapp5.MODID, "ore_emerald_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_emerald_deep_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_emerald_icestone"), new ResourceLocation(Minestrapp5.MODID, "ore_emerald_glacierrock"), new ResourceLocation(Minestrapp5.MODID, "ore_emerald_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "ore_emerald_deep_oceanstone"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.ore_titanium), new ResourceLocation(Minestrapp5.MODID, "ore_titanium_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_titanium_deep_red_rock"), new ResourceLocation(Minestrapp5.MODID, "ore_titanium_deepstone"), new ResourceLocation(Minestrapp5.MODID, "ore_titanium_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_titanium_deep_coldstone"), new ResourceLocation(Minestrapp5.MODID, "ore_titanium_icestone"), new ResourceLocation(Minestrapp5.MODID, "ore_titanium_glacierrock"), new ResourceLocation(Minestrapp5.MODID, "ore_titanium_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "ore_titanium_deep_oceanstone"), new ResourceLocation(Minestrapp5.MODID, "ore_titanium_stone"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.candle), new ResourceLocation(Minestrapp5.MODID, "candle_white"), new ResourceLocation(Minestrapp5.MODID, "candle_orange"), new ResourceLocation(Minestrapp5.MODID, "candle_magenta"), new ResourceLocation(Minestrapp5.MODID, "candle_light_blue"), new ResourceLocation(Minestrapp5.MODID, "candle_yellow"), new ResourceLocation(Minestrapp5.MODID, "candle_lime"), new ResourceLocation(Minestrapp5.MODID, "candle_pink"), new ResourceLocation(Minestrapp5.MODID, "candle_gray"), new ResourceLocation(Minestrapp5.MODID, "candle_silver"), new ResourceLocation(Minestrapp5.MODID, "candle_cyan"), new ResourceLocation(Minestrapp5.MODID, "candle_purple"), new ResourceLocation(Minestrapp5.MODID, "candle_blue"), new ResourceLocation(Minestrapp5.MODID, "candle_brown"), new ResourceLocation(Minestrapp5.MODID, "candle_green"), new ResourceLocation(Minestrapp5.MODID, "candle_red"), new ResourceLocation(Minestrapp5.MODID, "candle_black"));
		//ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.candle_fire), new ResourceLocation(Minestrapp5.MODID, "candle_fire_white"), new ResourceLocation(Minestrapp5.MODID, "candle_fire_orange"), new ResourceLocation(Minestrapp5.MODID, "candle_fire_magenta"), new ResourceLocation(Minestrapp5.MODID, "candle_fire_light_blue"), new ResourceLocation(Minestrapp5.MODID, "candle_fire_yellow"), new ResourceLocation(Minestrapp5.MODID, "candle_fire_lime"), new ResourceLocation(Minestrapp5.MODID, "candle_fire_pink"), new ResourceLocation(Minestrapp5.MODID, "candle_fire_gray"), new ResourceLocation(Minestrapp5.MODID, "candle_fire_silver"), new ResourceLocation(Minestrapp5.MODID, "candle_fire_cyan"), new ResourceLocation(Minestrapp5.MODID, "candle_fire_purple"), new ResourceLocation(Minestrapp5.MODID, "candle_fire_blue"), new ResourceLocation(Minestrapp5.MODID, "candle_fire_brown"), new ResourceLocation(Minestrapp5.MODID, "candle_fire_green"), new ResourceLocation(Minestrapp5.MODID, "candle_fire_red"), new ResourceLocation(Minestrapp5.MODID, "candle_fire_black"));
		//ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.candle_ender), new ResourceLocation(Minestrapp5.MODID, "candle_ender_white"), new ResourceLocation(Minestrapp5.MODID, "candle_ender_orange"), new ResourceLocation(Minestrapp5.MODID, "candle_ender_magenta"), new ResourceLocation(Minestrapp5.MODID, "candle_ender_light_blue"), new ResourceLocation(Minestrapp5.MODID, "candle_ender_yellow"), new ResourceLocation(Minestrapp5.MODID, "candle_ender_lime"), new ResourceLocation(Minestrapp5.MODID, "candle_ender_pink"), new ResourceLocation(Minestrapp5.MODID, "candle_ender_gray"), new ResourceLocation(Minestrapp5.MODID, "candle_ender_silver"), new ResourceLocation(Minestrapp5.MODID, "candle_ender_cyan"), new ResourceLocation(Minestrapp5.MODID, "candle_ender_purple"), new ResourceLocation(Minestrapp5.MODID, "candle_ender_blue"), new ResourceLocation(Minestrapp5.MODID, "candle_ender_brown"), new ResourceLocation(Minestrapp5.MODID, "candle_ender_green"), new ResourceLocation(Minestrapp5.MODID, "candle_ender_red"), new ResourceLocation(Minestrapp5.MODID, "candle_ender_black"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.pumpkin_normie), new ResourceLocation(Minestrapp5.MODID, "pumpkin_normie_simple"), new ResourceLocation(Minestrapp5.MODID, "pumpkin_normie_average"), new ResourceLocation(Minestrapp5.MODID, "pumpkin_normie_complex"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.pumpkin_grumpy), new ResourceLocation(Minestrapp5.MODID, "pumpkin_grumpy_simple"), new ResourceLocation(Minestrapp5.MODID, "pumpkin_grumpy_average"), new ResourceLocation(Minestrapp5.MODID, "pumpkin_grumpy_complex"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.pumpkin_dumpy), new ResourceLocation(Minestrapp5.MODID, "pumpkin_dumpy_simple"), new ResourceLocation(Minestrapp5.MODID, "pumpkin_dumpy_average"), new ResourceLocation(Minestrapp5.MODID, "pumpkin_dumpy_complex"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.pumpkin_creepy), new ResourceLocation(Minestrapp5.MODID, "pumpkin_creepy_simple"), new ResourceLocation(Minestrapp5.MODID, "pumpkin_creepy_average"), new ResourceLocation(Minestrapp5.MODID, "pumpkin_creepy_complex"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(MBlocks.pumpkin_smiley), new ResourceLocation(Minestrapp5.MODID, "pumpkin_smiley_simple"), new ResourceLocation(Minestrapp5.MODID, "pumpkin_smiley_average"), new ResourceLocation(Minestrapp5.MODID, "pumpkin_smiley_complex"));
		*/
		MobRegistry.register();
		
		registerColorHandlers();
	}
	
	public static void registerColorHandlers()
	{
		final BlockColors blockcolors = minecraft.getBlockColors();
		
		final IBlockColor mGrassColorHandler = (IBlockState state, @Nullable IBlockAccess worldIn, @Nullable BlockPos pos, int tintIndex) -> 
		{
			return worldIn != null && pos != null ? BiomeColorHelper.getGrassColorAtPos(worldIn, pos) : ColorizerGrass.getGrassColor(0.5D, 1.0D);
		};
		
		final IBlockColor sandyRedstoneColorHandler = (IBlockState state, @Nullable IBlockAccess worldIn, @Nullable BlockPos pos, int tintIndex) -> 
		{
			return BlockBiomeRedstoneWire.colorMultiplier(worldIn.getBlockState(pos).getValue(BlockBiomeRedstoneWire.POWER).intValue(), MBlocks.redstone_sandy);
		};
		
		final IBlockColor frostedRedstoneColorHandler = (IBlockState state, @Nullable IBlockAccess worldIn, @Nullable BlockPos pos, int tintIndex) -> 
		{
			return BlockBiomeRedstoneWire.colorMultiplier(worldIn.getBlockState(pos).getValue(BlockBiomeRedstoneWire.POWER).intValue(), MBlocks.redstone_frosted);
		};
		
		final IBlockColor icyRedstoneColorHandler = (IBlockState state, @Nullable IBlockAccess worldIn, @Nullable BlockPos pos, int tintIndex) -> 
		{
			return BlockBiomeRedstoneWire.colorMultiplier(worldIn.getBlockState(pos).getValue(BlockBiomeRedstoneWire.POWER).intValue(), MBlocks.redstone_icy);
		};
		
		final IBlockColor brinyRedstoneColorHandler = (IBlockState state, @Nullable IBlockAccess worldIn, @Nullable BlockPos pos, int tintIndex) -> 
		{
			return BlockBiomeRedstoneWire.colorMultiplier(worldIn.getBlockState(pos).getValue(BlockBiomeRedstoneWire.POWER).intValue(), MBlocks.redstone_briny);
		};
		
		blockcolors.registerBlockColorHandler(mGrassColorHandler, MBlocks.clay_grass);
		blockcolors.registerBlockColorHandler(sandyRedstoneColorHandler, MBlocks.redstone_sandy);
		blockcolors.registerBlockColorHandler(frostedRedstoneColorHandler, MBlocks.redstone_frosted);
		blockcolors.registerBlockColorHandler(icyRedstoneColorHandler, MBlocks.redstone_icy);
		blockcolors.registerBlockColorHandler(brinyRedstoneColorHandler, MBlocks.redstone_briny);
	}
	
	public static void registerRenderers()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMagnetPiston.class, new TileEntityMagnetPistonRenderer());
		
		registerEntityRenderer(EntityMBoat.class, RenderMBoat.class);
	}
	
	public static void registerEntities()
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Minestrapp5.MODID, "m_boat"), EntityMBoat.class, "m_boat", 500, Minestrapp5.instance, 64, 1, true);
	}

	private static <E extends Entity> void registerEntityRenderer(Class<E> entityClass, Class<? extends Render<E>> renderClass)
    {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, new EntityRenderFactory<E>(renderClass));
    }
	
	private static class EntityRenderFactory<E extends Entity> implements IRenderFactory<E>
    {
        private Class<? extends Render<E>> renderClass;

        private EntityRenderFactory(Class<? extends Render<E>> renderClass)
        {
            this.renderClass = renderClass;
        }

        @Override
        public Render<E> createRenderFor(RenderManager manager) 
        {
            Render<E> renderer = null;

            try 
            {
                renderer = renderClass.getConstructor(RenderManager.class).newInstance(manager);
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }

            return renderer;
        }
    }
}
