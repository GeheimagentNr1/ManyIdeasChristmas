package de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.wreaths;

import de.geheimagentnr1.manyideas_christmas.elements.block_state_properties.ModBlockStateProperties;
import de.geheimagentnr1.manyideas_christmas.helpers.FlameHelper;
import de.geheimagentnr1.manyideas_core.elements.blocks.BlockItemInterface;
import de.geheimagentnr1.manyideas_core.elements.blocks.BlockRenderTypeInterface;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;


public class WreathCandle extends Block implements BlockItemInterface, BlockRenderTypeInterface {
	
	
	public static final String registry_name = "wreath_candle";
	
	private static final Integer MIN_LIT_COUNT = 0;
	
	private static final Integer MAX_LIT_COUNT = 4;
	
	private static final VoxelShape LIT_0_1_SHAPE = VoxelShapeMemory.createVoxelShape(
		VoxelShapeVector.create( 2, 0, 2, 14, 2.5, 14 ),
		VoxelShapeVector.create( 2, 2.5, 6.5, 5, 3, 9.5 ),
		VoxelShapeVector.create( 6.5, 2.5, 11, 9.5, 3, 14 ),
		VoxelShapeVector.create( 11, 2.5, 6.5, 14, 3, 9.5 ),
		VoxelShapeVector.create( 6.5, 2.5, 2, 9.6, 3, 5 ),
		VoxelShapeVector.create( 2.5, 3, 7, 4.5, 7, 9 ),
		VoxelShapeVector.create( 7, 3, 11.5, 9, 7, 13.5 ),
		VoxelShapeVector.create( 11.5, 3, 7, 13.5, 7, 9 ),
		VoxelShapeVector.create( 7, 3, 2.5, 9, 7, 4.5 )
	);
	
	private static final VoxelShapeMemory LIT_2_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.WEST,
		VoxelShapeVector.create( 2, 0, 2, 14, 2.5, 14 ),
		VoxelShapeVector.create( 2, 2.5, 6.5, 5, 3, 9.5 ),
		VoxelShapeVector.create( 6.5, 2.5, 11, 9.5, 3, 14 ),
		VoxelShapeVector.create( 11, 2.5, 6.5, 14, 3, 9.5 ),
		VoxelShapeVector.create( 6.5, 2.5, 2, 9.6, 3, 5 ),
		VoxelShapeVector.create( 2.5, 3, 7, 4.5, 6, 9 ),
		VoxelShapeVector.create( 7, 3, 11.5, 9, 7, 13.5 ),
		VoxelShapeVector.create( 11.5, 3, 7, 13.5, 7, 9 ),
		VoxelShapeVector.create( 7, 3, 2.5, 9, 7, 4.5 )
	);
	
	private static final VoxelShapeMemory LIT_3_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.WEST,
		VoxelShapeVector.create( 2, 0, 2, 14, 2.5, 14 ),
		VoxelShapeVector.create( 2, 2.5, 6.5, 5, 3, 9.5 ),
		VoxelShapeVector.create( 6.5, 2.5, 11, 9.5, 3, 14 ),
		VoxelShapeVector.create( 11, 2.5, 6.5, 14, 3, 9.5 ),
		VoxelShapeVector.create( 6.5, 2.5, 2, 9.6, 3, 5 ),
		VoxelShapeVector.create( 2.5, 3, 7, 4.5, 5, 9 ),
		VoxelShapeVector.create( 7, 3, 11.5, 9, 6, 13.5 ),
		VoxelShapeVector.create( 11.5, 3, 7, 13.5, 7, 9 ),
		VoxelShapeVector.create( 7, 3, 2.5, 9, 7, 4.5 )
	);
	
	private static final VoxelShapeMemory LIT_4_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.WEST,
		VoxelShapeVector.create( 2, 0, 2, 14, 2.5, 14 ),
		VoxelShapeVector.create( 2, 2.5, 6.5, 5, 3, 9.5 ),
		VoxelShapeVector.create( 6.5, 2.5, 11, 9.5, 3, 14 ),
		VoxelShapeVector.create( 11, 2.5, 6.5, 14, 3, 9.5 ),
		VoxelShapeVector.create( 6.5, 2.5, 2, 9.6, 3, 5 ),
		VoxelShapeVector.create( 2.5, 3, 7, 4.5, 4, 9 ),
		VoxelShapeVector.create( 7, 3, 11.5, 9, 5, 13.5 ),
		VoxelShapeVector.create( 11.5, 3, 7, 13.5, 7, 9 ),
		VoxelShapeVector.create( 7, 3, 2.5, 9, 6, 4.5 )
	);
	
	public WreathCandle() {
		
		super(
			BlockBehaviour.Properties.of( Material.LEAVES )
				.strength( 2.0F )
				.sound( SoundType.GRASS )
				.lightLevel( value -> value.getValue( ModBlockStateProperties.WREATH_CANDLE_LIT_COUNT ) * 3 )
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
		return switch( state.getValue( ModBlockStateProperties.WREATH_CANDLE_LIT_COUNT ) ) {
			case 0, 1 -> LIT_0_1_SHAPE;
			case 2 -> LIT_2_SHAPES.getShapeFromHorizontalFacing( facing );
			case 3 -> LIT_3_SHAPES.getShapeFromHorizontalFacing( facing );
			case 4 -> LIT_4_SHAPES.getShapeFromHorizontalFacing( facing );
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
		if( stack.isEmpty() ) {
			Integer currentlitCount = state.getValue( ModBlockStateProperties.WREATH_CANDLE_LIT_COUNT );
			if( currentlitCount > MIN_LIT_COUNT ) {
				level.playSound( player, pos, SoundEvents.CANDLE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F );
				level.setBlock(
					pos,
					state.setValue( ModBlockStateProperties.WREATH_CANDLE_LIT_COUNT, currentlitCount - 1 ),
					3
				);
				return InteractionResult.SUCCESS;
			}
		} else {
			if( stack.is( Items.FLINT_AND_STEEL ) ) {
				Integer currentlitCount = state.getValue( ModBlockStateProperties.WREATH_CANDLE_LIT_COUNT );
				if( currentlitCount < MAX_LIT_COUNT ) {
					if( !player.isCreative() ) {
						stack.hurtAndBreak( 1, player, breakPlayer -> breakPlayer.broadcastBreakEvent( hand ) );
					}
					level.playSound(
						player,
						pos,
						SoundEvents.FLINTANDSTEEL_USE,
						SoundSource.BLOCKS,
						1.0F,
						level.getRandom().nextFloat() * 0.4F + 0.8F
					);
					level.setBlock(
						pos,
						state.setValue( ModBlockStateProperties.WREATH_CANDLE_LIT_COUNT, currentlitCount + 1 ),
						3
					);
					return InteractionResult.SUCCESS;
				}
			}
		}
		return InteractionResult.PASS;
	}
	
	@Override
	public void animateTick(
		@NotNull BlockState state,
		@NotNull Level level,
		@NotNull BlockPos pos,
		@NotNull RandomSource randomSource ) {
		
		double rotation = switch( state.getValue( BlockStateProperties.HORIZONTAL_FACING ) ) {
			case NORTH -> 270.0;//180.0
			case EAST -> 180.0;//270
			case SOUTH -> 90.0;//0
			case WEST -> 0.0;//90.0
			default -> 0.0;
		};
		switch( state.getValue( ModBlockStateProperties.WREATH_CANDLE_LIT_COUNT ) ) {
			case 1 -> FlameHelper.animateFlames( new Vec3( 3.5, 9, 8 ), level, pos, randomSource, rotation );
			case 2 -> {
				FlameHelper.animateFlames( new Vec3( 3.5, 8, 8 ), level, pos, randomSource, rotation );
				FlameHelper.animateFlames( new Vec3( 8, 9, 12.5 ), level, pos, randomSource, rotation );
			}
			case 3 -> {
				FlameHelper.animateFlames( new Vec3( 3.5, 7, 8 ), level, pos, randomSource, rotation );
				FlameHelper.animateFlames( new Vec3( 8, 8, 12.5 ), level, pos, randomSource, rotation );
				FlameHelper.animateFlames( new Vec3( 8, 9, 3.5 ), level, pos, randomSource, rotation );
			}
			case 4 -> {
				FlameHelper.animateFlames( new Vec3( 3.5, 6, 8 ), level, pos, randomSource, rotation );
				FlameHelper.animateFlames( new Vec3( 8, 7, 12.5 ), level, pos, randomSource, rotation );
				FlameHelper.animateFlames( new Vec3( 8, 8, 3.5 ), level, pos, randomSource, rotation );
				FlameHelper.animateFlames( new Vec3( 12.5, 9, 8 ), level, pos, randomSource, rotation );
			}
		}
	}
	
	protected void createBlockStateDefinition( StateDefinition.Builder<Block, BlockState> builder ) {
		
		builder.add( BlockStateProperties.HORIZONTAL_FACING, ModBlockStateProperties.WREATH_CANDLE_LIT_COUNT );
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
