package minestrapp.block;


import minestrapp.block.util.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBauble extends BlockBase
{	
	public static final PropertyDirection FACING = PropertyDirection.create("facing");
	
	protected static final AxisAlignedBB AABB_UP = new AxisAlignedBB(0.25D, 0D, 0.25D, 0.75D, 0.5D, 0.75D);
	protected static final AxisAlignedBB AABB_DOWN = new AxisAlignedBB(0.25D, 0.5D, 0.25D, 0.75D, 1D, 0.75D);
	protected static final AxisAlignedBB AABB_NORTH = new AxisAlignedBB(0.25D, 0.25D, 0.5D, 0.75D, 0.75D, 1D);
	protected static final AxisAlignedBB AABB_EAST = new AxisAlignedBB(0D, 0.25D, 0.25D, 0.5D, 0.75D, 0.75D);
	protected static final AxisAlignedBB AABB_SOUTH = new AxisAlignedBB(0.25D, 0.25D, 0D, 0.75D, 0.75D, 0.5D);
	protected static final AxisAlignedBB AABB_WEST = new AxisAlignedBB(0.5D, 0.25D, 0.25D, 1D, 0.75D, 0.75D);
	
	private BlockRenderLayer layer = BlockRenderLayer.SOLID;
	
	public BlockBauble(String name, Material materialIn, MapColor mapColor, SoundType soundType, float hardness)
	{
		super(name, materialIn, mapColor, soundType, hardness);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
	}
	
	public BlockBauble(String name, Material materialIn, MapColor mapColor, SoundType soundType, float hardness, String tool, int harvestLevel)
	{
		super(name, materialIn, mapColor, soundType, hardness, tool, harvestLevel);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
	}
	
	public BlockBauble setRenderLayer(BlockRenderLayer layer)
	{
		this.layer = layer;
		return this;
	}
	
	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return this.layer;
    }
	
	public AxisAlignedBB getBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        if(blockState.getValue(FACING) == EnumFacing.UP)
        	return AABB_UP;
        if(blockState.getValue(FACING) == EnumFacing.DOWN)
        	return AABB_DOWN;
        if(blockState.getValue(FACING) == EnumFacing.NORTH)
        	return AABB_NORTH;
        if(blockState.getValue(FACING) == EnumFacing.EAST)
        	return AABB_EAST;
        if(blockState.getValue(FACING) == EnumFacing.SOUTH)
        	return AABB_SOUTH;
        if(blockState.getValue(FACING) == EnumFacing.WEST)
        	return AABB_WEST;
        else
        	return AABB_UP;
    }
	
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, facing);
    }
    
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing;
        IBlockState state = this.getDefaultState();
        
        if(meta == 0)
        	enumfacing = EnumFacing.UP;
        else if(meta == 1)
        	enumfacing = EnumFacing.DOWN;
        else if(meta == 2)
        	enumfacing = EnumFacing.NORTH;
        else if(meta == 3)
        	enumfacing = EnumFacing.SOUTH;
        else if(meta == 4)
        	enumfacing = EnumFacing.EAST;
        else
        	enumfacing = EnumFacing.WEST;
        
        return state.withProperty(FACING, enumfacing);
    }
    
    public int getMetaFromState(IBlockState state)
    {
    	int i;
    	EnumFacing enumfacing = state.getValue(FACING);
    	
    	if(enumfacing == EnumFacing.UP)
    		i = 0;
    	else if(enumfacing == EnumFacing.DOWN)
    		i = 1;
    	else if(enumfacing == EnumFacing.NORTH)
    		i = 2;
    	else if(enumfacing == EnumFacing.SOUTH)
    		i = 3;
    	else if(enumfacing == EnumFacing.EAST)
    		i = 4;
    	else
    		i = 5;
    	
    	return i;
    }
    
    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }
    
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }

    public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing)
    {
        return BlockFaceShape.UNDEFINED;
    }
}
