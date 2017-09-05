package minestrapp.worldgen;

import java.util.Random;

import minestrapp.MBlocks;
import minestrapp.block.BlockColdSand;
import minestrapp.block.BlockMDirt;
import minestrapp.block.EnumStoneTypeMOnly;
import minestrapp.block.util.BlockStoneBaseMOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeJungle;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeSavanna;
import net.minecraft.world.biome.BiomeSwamp;
import net.minecraft.world.chunk.Chunk;

public class MWorldDecorator
{
	public static void generate(World world, int chunkX, int chunkZ, Random random)
	{
		BlockPos pos = new BlockPos(chunkX * 16, 0, chunkZ * 16);
		Chunk chunk = world.getChunkFromBlockCoords(pos);
		BiomeProvider chunkManager = world.getBiomeProvider();
		IBlockState stone = MBlocks.stone.getDefaultState();
		EnumStoneTypeMOnly sType = null;
		EnumStoneTypeMOnly dType = EnumStoneTypeMOnly.DEEPSTONE;
		int deepStoneDepth = 35;

		for (int x = 0; x < 16; x++)
		{
			for (int z = 0; z < 16; z++)
			{
				BlockPos subpos = new BlockPos(x, 0, z);
				Biome biome = chunkManager.getBiome(subpos, Biomes.PLAINS);
				
				int i = subpos.getX();
		        int j = subpos.getZ();
		        int k = chunk.getBiomeArray()[j << 4 | i] & 255;

		        if (k == 255)
		        {
		            k = Biome.getIdForBiome(biome);
		            chunk.getBiomeArray()[j << 4 | i] = (byte)(k & 255);
		        }

		        biome = Biome.getBiome(k);

				sType = MStoneGen.getStoneForBiome(biome);
				dType = MStoneGen.getDeepStoneForBiome(biome);
				deepStoneDepth = MStoneGen.getDeepstoneDepthForBiome(biome, random);

				for (int y = 256; y >= 0; y--)
				{
					BlockPos subpos2 = new BlockPos((chunkX * 16 + x), y, (chunkZ * 16 + z));
					IBlockState state = world.getBlockState(subpos2);
					Block block = state.getBlock();

					if (state.isFullBlock() == true)
					{
						if(state.getBlock() instanceof BlockOre)
						{
							if(state == Blocks.COAL_ORE.getDefaultState())
							{
								if (y < deepStoneDepth)
								{
									chunk.setBlockState(subpos2, MBlocks.ore_coal.getDefaultState().withProperty(BlockStoneBaseMOnly.VARIANT, dType));
								}
								else if (sType != null)
								{
									chunk.setBlockState(subpos2, MBlocks.ore_coal.getDefaultState().withProperty(BlockStoneBaseMOnly.VARIANT, sType));
								}
							}
							else if(state == Blocks.IRON_ORE.getDefaultState())
							{
								if (y < deepStoneDepth)
								{
									chunk.setBlockState(subpos2, MBlocks.ore_iron.getDefaultState().withProperty(BlockStoneBaseMOnly.VARIANT, dType));
								}
								else if (sType != null)
								{
									chunk.setBlockState(subpos2, MBlocks.ore_iron.getDefaultState().withProperty(BlockStoneBaseMOnly.VARIANT, sType));
								}
							}
							else if(state == Blocks.GOLD_ORE.getDefaultState())
							{
								if (y < deepStoneDepth)
								{
									chunk.setBlockState(subpos2, MBlocks.ore_gold.getDefaultState().withProperty(BlockStoneBaseMOnly.VARIANT, dType));
								}
								else if (sType != null)
								{
									chunk.setBlockState(subpos2, MBlocks.ore_gold.getDefaultState().withProperty(BlockStoneBaseMOnly.VARIANT, sType));
								}
							}
							else if(state == Blocks.LAPIS_ORE.getDefaultState())
							{
								if (y < deepStoneDepth)
								{
									chunk.setBlockState(subpos2, MBlocks.ore_lapis.getDefaultState().withProperty(BlockStoneBaseMOnly.VARIANT, dType));
								}
								else if (sType != null)
								{
									chunk.setBlockState(subpos2, MBlocks.ore_lapis.getDefaultState().withProperty(BlockStoneBaseMOnly.VARIANT, sType));
								}
							}
							else if(state == Blocks.DIAMOND_ORE.getDefaultState())
							{
								if (y < deepStoneDepth)
								{
									chunk.setBlockState(subpos2, MBlocks.ore_diamond.getDefaultState().withProperty(BlockStoneBaseMOnly.VARIANT, dType));
								}
								else if (sType != null)
								{
									chunk.setBlockState(subpos2, MBlocks.ore_diamond.getDefaultState().withProperty(BlockStoneBaseMOnly.VARIANT, sType));
								}
							}
							else if(state == Blocks.EMERALD_ORE.getDefaultState())
							{
								if (y < deepStoneDepth)
								{
									chunk.setBlockState(subpos2, MBlocks.ore_emerald.getDefaultState().withProperty(BlockStoneBaseMOnly.VARIANT, dType));
								}
								else if (sType != null)
								{
									chunk.setBlockState(subpos2, MBlocks.ore_emerald.getDefaultState().withProperty(BlockStoneBaseMOnly.VARIANT, sType));
								}
							}
						}
						else if(state.getBlock() instanceof BlockRedstoneOre)
						{
							if (y < deepStoneDepth)
							{
								chunk.setBlockState(subpos2, MBlocks.ore_redstone.getDefaultState().withProperty(BlockStoneBaseMOnly.VARIANT, dType));
							}
							else if (sType != null)
							{
								chunk.setBlockState(subpos2, MBlocks.ore_redstone.getDefaultState().withProperty(BlockStoneBaseMOnly.VARIANT, sType));
							}
						}
						else if(state.getBlock() == Blocks.COBBLESTONE)
						{
							if (y < deepStoneDepth)
							{
								chunk.setBlockState(subpos2, MBlocks.cobblestone.getDefaultState().withProperty(BlockStoneBaseMOnly.VARIANT, dType));
							}
							else if (sType != null)
							{
								chunk.setBlockState(subpos2, MBlocks.cobblestone.getDefaultState().withProperty(BlockStoneBaseMOnly.VARIANT, sType));
							}
						}
						else if(state.getBlock() == Blocks.MOSSY_COBBLESTONE)
						{
							if (y < deepStoneDepth)
							{
								chunk.setBlockState(subpos2, MBlocks.mossy_cobblestone.getDefaultState().withProperty(BlockStoneBaseMOnly.VARIANT, dType));
							}
							else if (sType != null)
							{
								chunk.setBlockState(subpos2, MBlocks.mossy_cobblestone.getDefaultState().withProperty(BlockStoneBaseMOnly.VARIANT, sType));
							}
						}
//						else if(state.getBlock() instanceof BlockStoneBrick)
//						{
//							if(state.getValue(BlockStoneBrick.VARIANT) == BlockStoneBrick.EnumType.DEFAULT)
//							{
//								if (y < deepStoneDepth)
//								{
//									chunk.setBlockState(subpos2, MBlocks.stone_bricks.getDefaultState().withProperty(BlockStoneBaseMOnly.VARIANT, dType));
//								}
//								else if (sType != null)
//								{
//									chunk.setBlockState(subpos2, MBlocks.stone_bricks.getDefaultState().withProperty(BlockStoneBaseMOnly.VARIANT, sType));
//								}
//							}
//							if(state.getValue(BlockStoneBrick.VARIANT) == BlockStoneBrick.EnumType.MOSSY)
//							{
//								if (y < deepStoneDepth)
//								{
//									chunk.setBlockState(subpos2, MBlocks.mossy_stone_bricks.getDefaultState().withProperty(BlockStoneBaseMOnly.VARIANT, dType));
//								}
//								else if (sType != null)
//								{
//									chunk.setBlockState(subpos2, MBlocks.mossy_stone_bricks.getDefaultState().withProperty(BlockStoneBaseMOnly.VARIANT, sType));
//								}
//							}
//							if(state.getValue(BlockStoneBrick.VARIANT) == BlockStoneBrick.EnumType.CRACKED)
//							{
//								if (y < deepStoneDepth)
//								{
//									chunk.setBlockState(subpos2, MBlocks.cracked_stone_bricks.getDefaultState().withProperty(BlockStoneBaseMOnly.VARIANT, dType));
//								}
//								else if (sType != null)
//								{
//									chunk.setBlockState(subpos2, MBlocks.cracked_stone_bricks.getDefaultState().withProperty(BlockStoneBaseMOnly.VARIANT, sType));
//								}
//							}
//						}
						else if (biome.getTemperature() >= 1.0F || biome instanceof BiomeJungle || biome instanceof BiomeSwamp)
						{
							if (state.getBlock() == Blocks.DIRT)
								chunk.setBlockState(subpos2, MBlocks.clay_soil.getDefaultState().withProperty(BlockMDirt.VARIANT, BlockMDirt.DirtType.byMetadata(((BlockDirt.DirtType)state.getValue(BlockDirt.VARIANT)).getMetadata())));
							else if (state.getBlock() == Blocks.GRASS)
							{
								if(world.getBlockState(subpos2.up()).getBlock() instanceof BlockLeaves)
									chunk.setBlockState(subpos2, MBlocks.clay_soil.getDefaultState().withProperty(BlockMDirt.VARIANT, BlockMDirt.DirtType.PODZOL));
								else
									chunk.setBlockState(subpos2, MBlocks.clay_grass.getDefaultState());
							}
						}
						else if (biome.getTemperature() < 0.2F)
						{
							if (state.getBlock() == Blocks.DIRT)
								chunk.setBlockState(subpos2, MBlocks.permafrost.getDefaultState().withProperty(BlockMDirt.VARIANT, BlockMDirt.DirtType.byMetadata(((BlockDirt.DirtType)state.getValue(BlockDirt.VARIANT)).getMetadata())));
							else if (state.getBlock() == Blocks.SAND)
								chunk.setBlockState(subpos2, MBlocks.cold_sand.getDefaultState().withProperty(BlockColdSand.VARIANT, BlockColdSand.EnumType.byMetadata(((BlockSand.EnumType)state.getValue(BlockSand.VARIANT)).getMetadata())));
							else if (state.getBlock() == Blocks.GRASS)
							{
								boolean leaves = false;
								for (int n = subpos2.getY() ; n < (subpos2.getY() + 5) ; n++)
								{
									if(world.getBlockState(new BlockPos(subpos2.getX(), n + 1, subpos2.getZ())).getBlock() instanceof BlockLeaves)
									{
										leaves = true;
										break;
									}
								}
								if (leaves)
									chunk.setBlockState(subpos2, MBlocks.permafrost.getDefaultState().withProperty(BlockMDirt.VARIANT, BlockMDirt.DirtType.PODZOL));
								else
									chunk.setBlockState(subpos2, MBlocks.lichen.getDefaultState());
							}
						}
					}
					else if (state.getBlock() == Blocks.TALLGRASS)
					{
						if(biome.getTemperature() < 0.2F)
							chunk.setBlockState(subpos2, MBlocks.tundra_grass.getDefaultState());
						else if (biome instanceof BiomeSavanna)
						{
							int o = random.nextInt(3) + 1;
							
							for (int p = 0 ; p < o ; p++)
							{
								BlockPos grassPos = new BlockPos(subpos2.getX(), subpos2.getY() + p, subpos2.getZ());
								if(world.getBlockState(grassPos).getBlock().isReplaceable(world, grassPos))
									chunk.setBlockState(grassPos, MBlocks.savanna_grass.getDefaultState());
							}
						}
					}
					else if (state.getBlock() == Blocks.GRASS_PATH)
					{
						if (biome.getTemperature() >= 1.0F || biome instanceof BiomeJungle || biome instanceof BiomeSwamp)
							chunk.setBlockState(subpos2, MBlocks.clay_grass_path.getDefaultState());
						else if (biome.getTemperature() < 0.2F)
							chunk.setBlockState(subpos2, MBlocks.lichen_path.getDefaultState());
					}
					else if (state.getBlock() == Blocks.FARMLAND)
					{
						if (biome.getTemperature() >= 1.0F || biome instanceof BiomeJungle || biome instanceof BiomeSwamp)
							chunk.setBlockState(subpos2, MBlocks.clay_farmland.getDefaultState());
						else if (biome.getTemperature() < 0.2F)
							chunk.setBlockState(subpos2, MBlocks.permafrost_farmland.getDefaultState());
					}
				}
			}
		}
	}
}