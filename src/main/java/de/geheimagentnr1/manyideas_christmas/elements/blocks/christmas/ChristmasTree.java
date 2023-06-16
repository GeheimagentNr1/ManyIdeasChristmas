package de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas;

import de.geheimagentnr1.manyideas_christmas.elements.block_state_properties.ModBlockStateProperties;
import de.geheimagentnr1.manyideas_christmas.helpers.DecorateableBlockHelper;
import de.geheimagentnr1.manyideas_core.elements.blocks.BlockRenderTypeInterface;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.multi_block.MultiBlock;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;


public class ChristmasTree extends MultiBlock implements BlockRenderTypeInterface {
	
	
	public static final String registry_name = "christmas_tree";
	
	private static final VoxelShapeMemory TOP_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0, 0, 0, 4.5, 2, 4.5 ),
		VoxelShapeVector.create( 0, 2, 0, 2.5, 11, 2 )
	);
	
	private static final VoxelShapeMemory MIDDLE_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0, 0, 0, 3, 16, 9.5 ),
		VoxelShapeVector.create( 3, 0, 0, 9.5, 16, 3 ),
		VoxelShapeVector.create( 3, 0, 3, 6.5, 16, 6.5 )
	);
	
	private static final VoxelShapeMemory BOTTOM_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0, 0, 0, 1, 2, 7 ),
		VoxelShapeVector.create( 1, 0, 0, 7, 2, 1 ),
		VoxelShapeVector.create( 0, 1, 0, 2.5, 6, 2.5 ),
		VoxelShapeVector.create( 0, 6, 0, 3, 16, 16 ),
		VoxelShapeVector.create( 3, 6, 0, 16, 16, 3 ),
		VoxelShapeVector.create( 3, 6, 3, 13, 16, 13 )
	);
	
	public ChristmasTree() {
		
		super(
			BlockBehaviour.Properties.of()
				.mapColor( MapColor.PODZOL )
				.strength( 3.5F )
				.sound( SoundType.WOOD )
				.noOcclusion()
		);
	}
	
	@NotNull
	@Override
	public VoxelShape getShape(
		@NotNull BlockState state,
		@NotNull BlockGetter level,
		@NotNull BlockPos pos,
		@NotNull CollisionContext context ) {
		
		Direction facing = state.getValue( BlockStateProperties.HORIZONTAL_FACING );
		int z = state.getValue( Z_SIZE );
		if( state.getValue( X_SIZE ) == 1 ) {
			if( z == 1 ) {
				facing = facing.getCounterClockWise();
			} else {
				facing = facing.getOpposite();
			}
		} else {
			if( z == 0 ) {
				facing = facing.getClockWise();
			}
		}
		return switch( state.getValue( Y_SIZE ) ) {
			case 0 -> BOTTOM_SHAPES.getShapeFromHorizontalFacing( facing );
			case 1 -> MIDDLE_SHAPES.getShapeFromHorizontalFacing( facing );
			case 2 -> TOP_SHAPES.getShapeFromHorizontalFacing( facing );
			default -> Shapes.block();
		};
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
	
	protected void createBlockStateDefinition( StateDefinition.Builder<Block, BlockState> builder ) {
		
		super.createBlockStateDefinition( builder );
		builder.add( ModBlockStateProperties.DECORATION_TYPE );
	}
	
	@Override
	protected int getXSize() {
		
		return 2;
	}
	
	@Override
	protected int getYSize() {
		
		return 3;
	}
	
	@Override
	protected int getZSize() {
		
		return 2;
	}
	
	@Override
	protected boolean[][][] hasBlockStatesAtPos() {
		
		return new boolean[][][] {
			{
				{ true, true },
				{ true, true },
				{ true, true }
			},
			{
				{ true, true },
				{ true, true },
				{ true, true }
			}
		};
	}
	
	@Override
	public RenderType getRenderType() {
		
		return RenderType.cutoutMipped();
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( this, _properties, registry_name );
	}
}
