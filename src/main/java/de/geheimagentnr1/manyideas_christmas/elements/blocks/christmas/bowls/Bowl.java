package de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.bowls;

import de.geheimagentnr1.manyideas_christmas.ManyIdeasChristmas;
import de.geheimagentnr1.manyideas_christmas.elements.block_state_properties.BowlContent;
import de.geheimagentnr1.manyideas_christmas.elements.block_state_properties.ModBlockStateProperties;
import de.geheimagentnr1.manyideas_core.elements.blocks.BlockItemInterface;
import de.geheimagentnr1.manyideas_core.elements.blocks.BlockRenderTypeInterface;
import de.geheimagentnr1.manyideas_core.util.TranslationKeyHelper;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
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


public abstract class Bowl extends Block implements BlockItemInterface, BlockRenderTypeInterface {
	
	
	private static final int APPLE_COUNT = 7;
	
	private static final int COOKIE_COUNT = 4;
	
	private static VoxelShape EMPTY_SHAPE = VoxelShapeMemory.createVoxelShape(
		VoxelShapeVector.create( 6, 0, 6, 10, 0.5, 10 ),
		VoxelShapeVector.create( 5, 0.5, 5, 11, 1, 11 ),
		VoxelShapeVector.create( 4, 1, 4, 12, 1.5, 12 ),
		VoxelShapeVector.create( 3, 1.5, 3, 13, 2, 13 ),
		VoxelShapeVector.create( 2, 2, 2, 14, 3, 14 )
	);
	
	private static VoxelShape APPLES_SHAPE = VoxelShapeMemory.createVoxelShape(
		VoxelShapeVector.create( 6, 0, 6, 10, 0.5, 10 ),
		VoxelShapeVector.create( 5, 0.5, 5, 11, 1, 11 ),
		VoxelShapeVector.create( 4, 1, 4, 12, 1.5, 12 ),
		VoxelShapeVector.create( 3, 1.5, 3, 13, 2, 13 ),
		VoxelShapeVector.create( 2, 2, 2, 14, 3, 14 ),
		VoxelShapeVector.create( 3, 3, 3, 13, 5.5, 13 )
	);
	
	private static VoxelShapeMemory COOKIES_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.WEST,
		VoxelShapeVector.create( 6, 0, 6, 10, 0.5, 10 ),
		VoxelShapeVector.create( 5, 0.5, 5, 11, 1, 11 ),
		VoxelShapeVector.create( 4, 1, 4, 12, 1.5, 12 ),
		VoxelShapeVector.create( 3, 1.5, 3, 13, 2, 13 ),
		VoxelShapeVector.create( 2, 2, 2, 14, 3, 14 ),
		VoxelShapeVector.create( 4.5, 3, 3.5, 12, 3.5, 11.5 )
	);
	
	Bowl() {
		
		super(
			Properties.of( Material.WOOD )
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
		
		return switch( state.getValue( ModBlockStateProperties.BOWL_CONTENT ) ) {
			case EMPTY -> EMPTY_SHAPE;
			case APPLES -> APPLES_SHAPE;
			case COOKIES ->
				COOKIES_SHAPES.getShapeFromHorizontalFacing( state.getValue( BlockStateProperties.HORIZONTAL_FACING ) );
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
		
		BowlContent bowlContent = state.getValue( ModBlockStateProperties.BOWL_CONTENT );
		ItemStack stack = player.getItemInHand( hand );
		if( bowlContent == BowlContent.EMPTY ) {
			if( stack.is( Items.APPLE ) ) {
				if( stack.getCount() >= APPLE_COUNT ) {
					level.playSound( player, pos, SoundEvents.COMPOSTER_FILL, SoundSource.BLOCKS, 1.0F, 1.0F );
					if( !player.isCreative() ) {
						stack.shrink( APPLE_COUNT );
					}
					level.setBlock(
						pos,
						state.setValue( ModBlockStateProperties.BOWL_CONTENT, BowlContent.APPLES ),
						3
					);
					return InteractionResult.SUCCESS;
				} else {
					if( level.isClientSide() ) {
						player.sendSystemMessage(
							Component.translatable(
								TranslationKeyHelper.generateMessageTranslationKey(
									ManyIdeasChristmas.MODID,
									"bowl_to_few_apples"
								),
								APPLE_COUNT
							)
						);
					}
				}
			} else {
				if( stack.is( Items.COOKIE ) ) {
					if( stack.getCount() >= COOKIE_COUNT ) {
						level.playSound( player, pos, SoundEvents.COMPOSTER_FILL, SoundSource.BLOCKS, 1.0F, 1.0F );
						if( !player.isCreative() ) {
							stack.shrink( COOKIE_COUNT );
						}
						level.setBlock(
							pos,
							state.setValue( ModBlockStateProperties.BOWL_CONTENT, BowlContent.COOKIES ),
							3
						);
						return InteractionResult.SUCCESS;
					} else {
						if( level.isClientSide() ) {
							player.sendSystemMessage(
								Component.translatable(
									TranslationKeyHelper.generateMessageTranslationKey(
										ManyIdeasChristmas.MODID,
										"bowl_to_few_cookies"
									),
									COOKIE_COUNT
								)
							);
						}
					}
				}
			}
		} else {
			if( stack.isEmpty() ) {
				level.playSound( player, pos, SoundEvents.COMPOSTER_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F );
				if( !player.isCreative() ) {
					ItemStack dropStack;
					switch( bowlContent ) {
						case APPLES -> dropStack = new ItemStack( Items.APPLE, APPLE_COUNT );
						case COOKIES -> dropStack = new ItemStack( Items.COOKIE, COOKIE_COUNT );
						default -> dropStack = null;
					}
					if( dropStack != null && !player.addItem( dropStack ) ) {
						player.drop( dropStack, false );
					}
				}
				level.setBlock(
					pos,
					state.setValue( ModBlockStateProperties.BOWL_CONTENT, BowlContent.EMPTY ),
					3
				);
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.PASS;
	}
	
	protected void createBlockStateDefinition( StateDefinition.Builder<Block, BlockState> builder ) {
		
		builder.add( BlockStateProperties.HORIZONTAL_FACING, ModBlockStateProperties.BOWL_CONTENT );
	}
	
	@Override
	public RenderType getRenderType() {
		
		return RenderType.cutout();
	}
}
