package minestrapp.crafting;

import minestrapp.MBlocks;
import minestrapp.MItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictRegistry
{
	public static void register()
	{
		OreDictionary.registerOre("candle", new ItemStack(MBlocks.candle, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("sand", new ItemStack(MBlocks.cold_sand, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("dirt", MBlocks.clay_soil);
		OreDictionary.registerOre("grass", MBlocks.clay_grass);
		OreDictionary.registerOre("dirt", MBlocks.permafrost);
		OreDictionary.registerOre("grass", MBlocks.lichen);
		OreDictionary.registerOre("dirt", MBlocks.mud);
		OreDictionary.registerOre("dirt", MBlocks.dried_mud);
		OreDictionary.registerOre("soilDry", new ItemStack(Blocks.DIRT, 1, 0));
		OreDictionary.registerOre("soilDry", new ItemStack(Blocks.DIRT, 1, 1));
		OreDictionary.registerOre("soilDry", new ItemStack(MBlocks.clay_soil, 1, 0));
		OreDictionary.registerOre("soilDry", new ItemStack(MBlocks.clay_soil, 1, 1));
		OreDictionary.registerOre("soilDry", MBlocks.dried_mud);
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.planks, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.mossy_m_planks, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("stone", new ItemStack(MBlocks.stone, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("cobblestone", new ItemStack(MBlocks.cobblestone, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("cobblestoneDeep", new ItemStack(MBlocks.cobblestone, 1, 1));
		OreDictionary.registerOre("cobblestoneDeep", new ItemStack(MBlocks.cobblestone, 1, 2));
		OreDictionary.registerOre("cobblestoneDeep", new ItemStack(MBlocks.cobblestone, 1, 4));
		OreDictionary.registerOre("cobblestoneDeep", new ItemStack(MBlocks.cobblestone, 1, 6));
		OreDictionary.registerOre("cobblestoneDeep", new ItemStack(MBlocks.cobblestone, 1, 8));
		OreDictionary.registerOre("bricksStone", new ItemStack(MBlocks.stone_bricks, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("bricksStone", new ItemStack(MBlocks.cracked_stone_bricks, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("bricksStone", new ItemStack(MBlocks.mossy_stone_bricks, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("blockMossy", new ItemStack(MBlocks.mossy_cobblestone, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("blockMossy", new ItemStack(MBlocks.mossy_stone_bricks, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("oreSalt", new ItemStack(MBlocks.ore_salt, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("oreCoal", new ItemStack(MBlocks.ore_coal, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("oreCopper", new ItemStack(MBlocks.ore_copper, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("oreTin", new ItemStack(MBlocks.ore_tin, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("oreIron", new ItemStack(MBlocks.ore_iron, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("oreGold", new ItemStack(MBlocks.ore_gold, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("oreRedstone", new ItemStack(MBlocks.ore_redstone, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("oreLapis", new ItemStack(MBlocks.ore_lapis, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("oreMeurodite", new ItemStack(MBlocks.ore_meurodite, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("oreIrradium", new ItemStack(MBlocks.ore_irradium, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("oreTorite", new ItemStack(MBlocks.ore_torite, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("oreDiamond", new ItemStack(MBlocks.ore_diamond, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("oreEmerald", new ItemStack(MBlocks.ore_emerald, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("oreTitanium", new ItemStack(MBlocks.ore_titanium, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("oreBlazium", new ItemStack(MBlocks.ore_blazium));
		OreDictionary.registerOre("oreSoul", new ItemStack(MBlocks.ore_soul));
		OreDictionary.registerOre("oreDimensium", new ItemStack(MBlocks.ore_dimensium));
		OreDictionary.registerOre("blockSunstone", MBlocks.block_sunstone);
		OreDictionary.registerOre("blockSalt", MBlocks.block_salt);
		OreDictionary.registerOre("blockCopper", MBlocks.block_copper);
		OreDictionary.registerOre("blockTin", MBlocks.block_tin);
		OreDictionary.registerOre("blockBronze", MBlocks.block_bronze);
		OreDictionary.registerOre("blockSteel", MBlocks.block_steel);
		OreDictionary.registerOre("blockMeurodite", MBlocks.block_meurodite);
		OreDictionary.registerOre("blockTorite", MBlocks.block_torite);
		OreDictionary.registerOre("blockIrradium", MBlocks.block_irradium);
		OreDictionary.registerOre("blockGlacierite", MBlocks.block_glacierite);
		OreDictionary.registerOre("blockTitanium", MBlocks.block_titanium);
		OreDictionary.registerOre("blockBlazium", MBlocks.block_blazium);
		OreDictionary.registerOre("blockDimensium", MBlocks.block_dimensium);
		OreDictionary.registerOre("blockRedstone", MBlocks.block_redstone_briny_lit);
		OreDictionary.registerOre("blockRedstone", MBlocks.block_redstone_sandy_lit);
		OreDictionary.registerOre("blockRedstone", MBlocks.block_redstone_frosted_lit);
		OreDictionary.registerOre("blockRedstone", MBlocks.block_redstone_icy_lit);
		OreDictionary.registerOre("dustRedstone", MBlocks.redstone_sandy);
		OreDictionary.registerOre("dustRedstone", MBlocks.redstone_frosted);
		OreDictionary.registerOre("dustRedstone", MBlocks.redstone_icy);
		OreDictionary.registerOre("dustRedstone", MBlocks.redstone_briny);
		OreDictionary.registerOre("dustCopper", new ItemStack(MItems.chunks, 1, 7));
		OreDictionary.registerOre("dustTin", new ItemStack(MItems.chunks, 1, 8));
		OreDictionary.registerOre("dustIron", new ItemStack(MItems.chunks, 1, 9));
		OreDictionary.registerOre("dustGold", new ItemStack(MItems.chunks, 1, 10));
		OreDictionary.registerOre("dustTorite", new ItemStack(MItems.chunks, 1, 11));
		OreDictionary.registerOre("dustTitanium", new ItemStack(MItems.chunks, 1, 12));
		OreDictionary.registerOre("dustDimensium", new ItemStack(MItems.chunks, 1, 13));
		OreDictionary.registerOre("dustIrradium", MItems.irradium);
		OreDictionary.registerOre("ingotCopper", new ItemStack(MItems.ingots, 1, 0));
		OreDictionary.registerOre("ingotTin", new ItemStack(MItems.ingots, 1, 1));
		OreDictionary.registerOre("ingotBronze", new ItemStack(MItems.ingots, 1, 2));
		OreDictionary.registerOre("ingotSteel", new ItemStack(MItems.ingots, 1, 3));
		OreDictionary.registerOre("ingotTorite", new ItemStack(MItems.ingots, 1, 4));
		OreDictionary.registerOre("ingotTitanium", new ItemStack(MItems.ingots, 1, 5));
		OreDictionary.registerOre("ingotGlacierite", new ItemStack(MItems.ingots, 1, 6));
		OreDictionary.registerOre("ingotBlazium", new ItemStack(MItems.ingots, 1, 7));
		OreDictionary.registerOre("ingotDimensium", new ItemStack(MItems.ingots, 1, 8));
		OreDictionary.registerOre("gemSalt", new ItemStack(MItems.salt));
		OreDictionary.registerOre("gemSunstone", new ItemStack(MItems.gems, 1, 0));
		OreDictionary.registerOre("gemQuartz", new ItemStack(MItems.gems, 1, 1));
		OreDictionary.registerOre("gemDesertQuartz", new ItemStack(MItems.gems, 1, 1));
		OreDictionary.registerOre("gemCrystal", new ItemStack(MItems.gems, 1, 2));
		OreDictionary.registerOre("gemQuartz", new ItemStack(MItems.gems, 1, 3));
		OreDictionary.registerOre("gemIrradiantQuartz", new ItemStack(MItems.gems, 1, 3));
		OreDictionary.registerOre("gemMeurodite", new ItemStack(MItems.gems, 1, 4));
		OreDictionary.registerOre("gemBlazium", new ItemStack(MItems.gems, 1, 5));
		OreDictionary.registerOre("gemGlacierite", new ItemStack(MItems.gems, 1, 6));
		OreDictionary.registerOre("gemSoul", MItems.gem_soul);
		OreDictionary.registerOre("plateTin", new ItemStack(MItems.plating, 1, 0));
		OreDictionary.registerOre("plateBronze", new ItemStack(MItems.plating, 1, 1));
		OreDictionary.registerOre("plateSteel", new ItemStack(MItems.plating, 1, 2));
		OreDictionary.registerOre("plateMeurodite", new ItemStack(MItems.plating, 1, 3));
		OreDictionary.registerOre("magnet", new ItemStack(MItems.tech_components, 1, 6));
		OreDictionary.registerOre("seedPepper", MItems.pepper_seeds);
		OreDictionary.registerOre("seedCabbage", MItems.cabbage_seeds);
		OreDictionary.registerOre("seedCelery", MItems.celery_seeds);
		OreDictionary.registerOre("seedTomato", MItems.tomato_seeds);
		OreDictionary.registerOre("tallow", new ItemStack(MItems.mob_loot, 1, 1));
		OreDictionary.registerOre("saladGreens", Items.CARROT);
		OreDictionary.registerOre("saladGreens", MItems.pepper);
		OreDictionary.registerOre("saladGreens", MItems.celery);
		OreDictionary.registerOre("saladGreens", MItems.onion);
		OreDictionary.registerOre("saladGreens", MItems.tomato);
		OreDictionary.registerOre("coleslawGreens", MItems.onion);
		OreDictionary.registerOre("coleslawGreens", MItems.pepper);
	}
}
