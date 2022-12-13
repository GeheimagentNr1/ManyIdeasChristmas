package de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas;

import de.geheimagentnr1.manyideas_christmas.elements.block_state_properties.Connected;
import de.geheimagentnr1.manyideas_christmas.elements.block_state_properties.ModBlockStateProperties;
import de.geheimagentnr1.manyideas_christmas.helpers.DecorateableBlockHelper;
import de.geheimagentnr1.manyideas_core.elements.blocks.BlockItemInterface;
import de.geheimagentnr1.manyideas_core.elements.blocks.BlockRenderTypeInterface;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class Garland extends Block implements BlockItemInterface, BlockRenderTypeInterface {
	
	
	public static final String registry_name = "garland";
	
	private static final VoxelShapeVector STRAIGHT_SHAPE = VoxelShapeVector.create( 0, 9, 0, 16, 15, 4 );
	
	private static final VoxelShapeMemory STRAIGHT_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		STRAIGHT_SHAPE
	);
	
	private static final VoxelShapeMemory BACK_LEFT_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		STRAIGHT_SHAPE,
		VoxelShapeVector.create( 0, 9, 4, 4, 15, 16 )
	);
	
	private static final VoxelShapeMemory FRONT_LEFT_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0, 9, 0, 4, 15, 4 )
	);
	
	public Garland() {
		
		super(
			Properties.of( Material.LEAVES )
				.strength( 2.0F )
				.sound( SoundType.GRASS )
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
		
		Direction facing = state.getValue( BlockStateProperties.HORIZONTAL_FACING );
		return switch( state.getValue( ModBlockStateProperties.CONNECTED ) ) {
			case NON -> STRAIGHT_SHAPES.getShapeFromHorizontalFacing( facing );
			case BACK_LEFT -> BACK_LEFT_SHAPES.getShapeFromHorizontalFacing( facing );
			case BACK_RIGHT -> BACK_LEFT_SHAPES.getShapeFromHorizontalFacing( facing.getClockWise() );
			case FRONT_LEFT -> FRONT_LEFT_SHAPES.getShapeFromHorizontalFacing( facing );
			case FRONT_RIGHT -> FRONT_LEFT_SHAPES.getShapeFromHorizontalFacing( facing.getClockWise() );
		};
	}
	
	@Nullable
	@Override
	public BlockState getStateForPlacement( BlockPlaceContext context ) {
		
		return connect(
			defaultBlockState().setValue(
				BlockStateProperties.HORIZONTAL_FACING,
				context.getHorizontalDirection()
			),
			context.getLevel(),
			context.getClickedPos()
		);
	}
	
	@NotNull
	@Override
	public BlockState updateShape(
		@NotNull BlockState state,
		@NotNull Direction facing,
		@NotNull BlockState facingState,
		@NotNull LevelAccessor level,
		@NotNull BlockPos pos,
		@NotNull BlockPos facingPos ) {
		
		return connect( state, level, pos );
	}
	
	private static BlockState connect(
		BlockState state,
		LevelAccessor level,
		BlockPos pos ) {
		
		Direction direction = state.getValue( BlockStateProperties.HORIZONTAL_FACING );
		BlockState directionState = level.getBlockState( pos.relative( direction ) );
		if( directionState.getBlock() instanceof Garland ) {
			if( directionState.getValue( BlockStateProperties.HORIZONTAL_FACING ) == direction.getCounterClockWise() ) {
				return state.setValue( ModBlockStateProperties.CONNECTED, Connected.FRONT_LEFT );
			}
			if( directionState.getValue( BlockStateProperties.HORIZONTAL_FACING ) == direction.getClockWise() ) {
				return state.setValue( ModBlockStateProperties.CONNECTED, Connected.FRONT_RIGHT );
			}
		}
		BlockState backDirectionState = level.getBlockState( pos.relative( direction.getOpposite() ) );
		if( backDirectionState.getBlock() instanceof Garland ) {
			if( backDirectionState.getValue( BlockStateProperties.HORIZONTAL_FACING ) ==
				direction.getCounterClockWise() ) {
				return state.setValue( ModBlockStateProperties.CONNECTED, Connected.BACK_LEFT );
			}
			if( backDirectionState.getValue( BlockStateProperties.HORIZONTAL_FACING ) == direction.getClockWise() ) {
				return state.setValue( ModBlockStateProperties.CONNECTED, Connected.BACK_RIGHT );
			}
		}
		return state;
	}
	
	@NotNull
	@Override
	public InteractionResult use(
		@NotNull BlockState state,
		@NotNull Level level,
		@NotNull BlockPos pos,
		@NotNull Player player,
		@NotNull InteractionHand hand,
		@NotNull BlockHitResult blockHitResult ) {
		
		return DecorateableBlockHelper.use( state, level, pos, player, hand );
	}
	
	@Override
	protected void createBlockStateDefinition( StateDefinition.Builder<Block, BlockState> builder ) {
		
		builder.add(
			BlockStateProperties.HORIZONTAL_FACING,
			ModBlockStateProperties.DECORATION_TYPE,
			ModBlockStateProperties.CONNECTED
		);
	}
	
	@Override
	public RenderType getRenderType() {
		
		return RenderType.cutout();
	}
	
	@Override
	public Item getBlockItem( Item.Properties properties ) {
		
		return createBlockItem( this, properties, registry_name );
	}
}
