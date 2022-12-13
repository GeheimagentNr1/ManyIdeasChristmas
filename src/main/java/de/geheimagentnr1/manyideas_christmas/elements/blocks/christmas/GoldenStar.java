package de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas;

import de.geheimagentnr1.manyideas_christmas.helpers.FlameHelper;
import de.geheimagentnr1.manyideas_core.elements.blocks.BlockItemInterface;
import de.geheimagentnr1.manyideas_core.elements.blocks.BlockRenderTypeInterface;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.Random;


public class GoldenStar extends LanternBlock implements BlockItemInterface, BlockRenderTypeInterface {
	
	
	public static final String registry_name = "golden_star";
	
	private static final VoxelShapeMemory HANGING_SHAPES = VoxelShapeMemory.createHorizontalAxisVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 3, 4, 4, 13, 12, 12 ),
		VoxelShapeVector.create( 4, 3, 4, 12, 13, 12 ),
		VoxelShapeVector.create( 6, 1.5, 4, 10, 14.5, 12 ),
		VoxelShapeVector.create( 1.5, 6, 4, 14.5, 10, 12 ),
		VoxelShapeVector.create( 6.5, 14.5, 6.5, 9.5, 16, 9.5 )
	);
	
	private static final VoxelShapeMemory STANDING_SHAPES = VoxelShapeMemory.createHorizontalAxisVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 3, 4, 4, 13, 12, 12 ),
		VoxelShapeVector.create( 4, 3, 4, 12, 13, 12 ),
		VoxelShapeVector.create( 6, 1.5, 4, 10, 14.5, 12 ),
		VoxelShapeVector.create( 1.5, 6, 4, 14.5, 10, 12 ),
		VoxelShapeVector.create( 7, 0, 7, 9, 3, 9 )
	);
	
	public GoldenStar() {
		
		super(
			BlockBehaviour.Properties.of( Material.METAL, MaterialColor.GOLD )
				.requiresCorrectToolForDrops()
				.strength( 3.5F )
				.sound( SoundType.METAL )
				.lightLevel( value -> 15 )
				.noOcclusion()
		
		);
		setRegistryName( registry_name );
	}
	
	@NotNull
	@Override
	public VoxelShape getShape(
		@NotNull BlockState state,
		@NotNull BlockGetter level,
		@NotNull BlockPos pos,
		@NotNull CollisionContext context ) {
		
		if( state.getValue( BlockStateProperties.HANGING ) ) {
			return HANGING_SHAPES.getShapeFromHorizontalAxis( state.getValue( BlockStateProperties.HORIZONTAL_FACING )
				.getAxis() );
		} else {
			return STANDING_SHAPES.getShapeFromHorizontalAxis( state.getValue( BlockStateProperties.HORIZONTAL_FACING )
				.getAxis() );
		}
	}
	
	@Override
	public Item getBlockItem( Item.Properties properties ) {
		
		return createBlockItem( this, properties, registry_name );
	}
	
	public BlockState getStateForPlacement( @NotNull BlockPlaceContext context ) {
		
		return Optional.ofNullable( super.getStateForPlacement( context ) )
			.map( state -> state.setValue(
				BlockStateProperties.HORIZONTAL_FACING,
				context.getHorizontalDirection().getOpposite()
			) )
			.orElse( null );
	}
	
	@Override
	public void animateTick(
		@NotNull BlockState state,
		@NotNull Level level,
		@NotNull BlockPos pos,
		@NotNull Random random ) {
		
		FlameHelper.animateFlames( new Vec3( 8, 12, 8 ), level, pos, random, 0 );
	}
	
	protected void createBlockStateDefinition( @NotNull StateDefinition.Builder<Block, BlockState> builder ) {
		
		super.createBlockStateDefinition( builder );
		builder.add( BlockStateProperties.HORIZONTAL_FACING );
	}
	
	@Override
	public RenderType getRenderType() {
		
		return RenderType.translucent();
	}
}
