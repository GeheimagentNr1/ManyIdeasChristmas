package de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas;

import de.geheimagentnr1.manyideas_christmas.elements.block_state_properties.ModBlockStateProperties;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
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


public class Present extends Block implements BlockItemInterface, BlockRenderTypeInterface {
	
	
	public static final String registry_name = "present";
	
	private static final Integer MAX_PRESENT_COUNT = 4;
	
	private static final VoxelShapeMemory PRESENT_1_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.WEST,
		VoxelShapeVector.create( 1.75, 0.01, 2.25, 14.25, 4.76, 14.75 ),
		VoxelShapeVector.create( 7, 0, 2, 9, 5, 15 ),
		VoxelShapeVector.create( 1.5, 0, 7, 14.5, 5, 9 ),
		VoxelShapeVector.create( 5.5, 5, 7, 10.5, 7, 9 ),
		VoxelShapeVector.create( 7.5, 5, 6.75, 8.5, 6, 9.25 )
	);
	
	private static final VoxelShapeMemory PRESENT_2_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.WEST,
		VoxelShapeVector.create( 1.75, 0.01, 1.25, 8.25, 2.76, 13.75 ),
		VoxelShapeVector.create( 4, 0, 1, 6, 3, 14 ),
		VoxelShapeVector.create( 1.5, 0, 8, 8.5, 3, 10 ),
		VoxelShapeVector.create( 4.5, 3, 7.75, 5.5, 4, 10.25 ),
		VoxelShapeVector.create( 2.5, 3, 8, 7.5, 5, 10 ),
		
		VoxelShapeVector.create( 8.75, 0.01, 1.25, 15.25, 9.76, 6.75 ),
		VoxelShapeVector.create( 11, 0, 1, 13, 10, 7 ),
		VoxelShapeVector.create( 8.5, 0, 3, 15.5, 10, 5 ),
		VoxelShapeVector.create( 11.5, 10, 2.75, 12.5, 11, 5.25 ),
		VoxelShapeVector.create( 9.5, 10, 3, 14.5, 12, 5 )
	);
	
	private static final VoxelShapeMemory PRESENT_3_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.WEST,
		VoxelShapeVector.create( 1.25, 0.01, 1.25, 8.75, 7.76, 8.75 ),
		VoxelShapeVector.create( 4, 0, 1, 6, 8, 9 ),
		VoxelShapeVector.create( 1, 0, 4, 9, 8, 6 ),
		VoxelShapeVector.create( 4.5, 8, 3.75, 5.5, 9, 6.25 ),
		VoxelShapeVector.create( 2, 8, 4, 8, 10, 6 ),
		
		VoxelShapeVector.create( 1.75, 0.01, 9.75, 8.25, 5.76, 15.25 ),
		VoxelShapeVector.create( 4, 0, 9.5, 6, 6, 15.5 ),
		VoxelShapeVector.create( 1.5, 0, 11.5, 8.5, 6, 13.5 ),
		VoxelShapeVector.create( 4.5, 6, 11.25, 5.5, 7, 13.75 ),
		VoxelShapeVector.create( 2, 6, 11.5, 8, 8, 13.5 ),
		
		VoxelShapeVector.create( 10.75, 0.01, 2.25, 15.25, 3.76, 14.75 ),
		VoxelShapeVector.create( 12, 0, 2, 14, 4, 15 ),
		VoxelShapeVector.create( 10.5, 0, 10, 15.5, 6, 12 ),
		VoxelShapeVector.create( 12.5, 4, 9.75, 13.5, 5, 12.25 )
	);
	
	private static final VoxelShapeMemory PRESENT_4_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.WEST,
		VoxelShapeVector.create( 1.25, 0.01, 1.25, 5.25, 12.01, 6.25 ),
		VoxelShapeVector.create( 2.5, 12, 2.75, 3.5, 13, 5.25 ),
		VoxelShapeVector.create( 0.5, 12, 3, 5.5, 14, 5 ),
		
		VoxelShapeVector.create( 1.25, 0.01, 8.25, 6.75, 4.76, 14.75 ),
		VoxelShapeVector.create( 1, 0, 10.5, 7, 5, 12.5 ),
		VoxelShapeVector.create( 3, 0, 8, 5, 5, 15 ),
		VoxelShapeVector.create( 3.5, 5, 10.25, 4.5, 6, 12.75 ),
		VoxelShapeVector.create( 1.5, 5, 10.5, 6.5, 7, 12.5 ),
		
		VoxelShapeVector.create( 7.25, 0.01, 1.25, 14.75, 7.76, 6.75 ),
		VoxelShapeVector.create( 7, 0, 4, 15, 8, 6 ),
		VoxelShapeVector.create( 9, 0, 1, 11, 8, 7 ),
		VoxelShapeVector.create( 9.5, 8, 3.75, 10.5, 9, 6.25 ),
		VoxelShapeVector.create( 7.5, 8, 4, 12.5, 10, 6 ),
		
		VoxelShapeVector.create( 9.25, 0.01, 9.25, 14.75, 1.76, 14.75 ),
		VoxelShapeVector.create( 9, 0, 11, 15, 2, 13 ),
		VoxelShapeVector.create( 11.5, 2, 10.75, 12.5, 3, 13.25 ),
		VoxelShapeVector.create( 9.5, 2, 11, 14.5, 4, 13 )
	);
	
	public Present() {
		
		super(
			BlockBehaviour.Properties.of()
				.mapColor( MapColor.SNOW )
				.strength( 0.5F )
				.sound( SoundType.GRASS )
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
		return switch( state.getValue( ModBlockStateProperties.PRESENT_COUNT ) ) {
			case 1 -> PRESENT_1_SHAPES.getShapeFromHorizontalFacing( facing );
			case 2 -> PRESENT_2_SHAPES.getShapeFromHorizontalFacing( facing );
			case 3 -> PRESENT_3_SHAPES.getShapeFromHorizontalFacing( facing );
			case 4 -> PRESENT_4_SHAPES.getShapeFromHorizontalFacing( facing );
			default -> Shapes.block();
		};
	}
	
	public BlockState getStateForPlacement( BlockPlaceContext context ) {
		
		return defaultBlockState().setValue(
			BlockStateProperties.HORIZONTAL_FACING,
			context.getHorizontalDirection().getOpposite()
		);
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
		
		ItemStack stack = player.getItemInHand( hand );
		if( stack.is( asItem() ) ) {
			Integer currentPresentCount = state.getValue( ModBlockStateProperties.PRESENT_COUNT );
			if( currentPresentCount < MAX_PRESENT_COUNT ) {
				if( !player.isCreative() ) {
					stack.shrink( 1 );
				}
				level.setBlock(
					pos,
					state.setValue( ModBlockStateProperties.PRESENT_COUNT, currentPresentCount + 1 ),
					3
				);
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.PASS;
	}
	
	
	protected void createBlockStateDefinition( StateDefinition.Builder<Block, BlockState> builder ) {
		
		builder.add( BlockStateProperties.HORIZONTAL_FACING, ModBlockStateProperties.PRESENT_COUNT );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( this, _properties, registry_name );
	}
	
	@Override
	public RenderType getRenderType() {
		
		return RenderType.cutout();
	}
}
