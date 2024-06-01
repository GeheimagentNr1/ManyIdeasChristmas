package de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.bowls;

import de.geheimagentnr1.manyideas_christmas.ManyIdeasChristmas;
import de.geheimagentnr1.manyideas_christmas.elements.block_state_properties.BowlContent;
import de.geheimagentnr1.manyideas_christmas.elements.block_state_properties.ModBlockStateProperties;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import de.geheimagentnr1.minecraft_forge_api.elements.blocks.BlockItemInterface;
import de.geheimagentnr1.minecraft_forge_api.util.TranslationKeyHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public abstract class Bowl extends Block implements BlockItemInterface {
	
	
	@NotNull
	private static final int APPLE_COUNT = 7;
	
	@NotNull
	private static final int COOKIE_COUNT = 4;
	
	@NotNull
	private static final VoxelShape EMPTY_SHAPE = VoxelShapeMemory.createVoxelShape(
		VoxelShapeVector.create( 6, 0, 6, 10, 0.5, 10 ),
		VoxelShapeVector.create( 5, 0.5, 5, 11, 1, 11 ),
		VoxelShapeVector.create( 4, 1, 4, 12, 1.5, 12 ),
		VoxelShapeVector.create( 3, 1.5, 3, 13, 2, 13 ),
		VoxelShapeVector.create( 2, 2, 2, 14, 3, 14 )
	);
	
	@NotNull
	private static final VoxelShape APPLES_SHAPE = VoxelShapeMemory.createVoxelShape(
		VoxelShapeVector.create( 6, 0, 6, 10, 0.5, 10 ),
		VoxelShapeVector.create( 5, 0.5, 5, 11, 1, 11 ),
		VoxelShapeVector.create( 4, 1, 4, 12, 1.5, 12 ),
		VoxelShapeVector.create( 3, 1.5, 3, 13, 2, 13 ),
		VoxelShapeVector.create( 2, 2, 2, 14, 3, 14 ),
		VoxelShapeVector.create( 3, 3, 3, 13, 5.5, 13 )
	);
	
	@NotNull
	private static final VoxelShapeMemory COOKIES_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.WEST,
		VoxelShapeVector.create( 6, 0, 6, 10, 0.5, 10 ),
		VoxelShapeVector.create( 5, 0.5, 5, 11, 1, 11 ),
		VoxelShapeVector.create( 4, 1, 4, 12, 1.5, 12 ),
		VoxelShapeVector.create( 3, 1.5, 3, 13, 2, 13 ),
		VoxelShapeVector.create( 2, 2, 2, 14, 3, 14 ),
		VoxelShapeVector.create( 4.5, 3, 3.5, 12, 3.5, 11.5 )
	);
	
	Bowl( @NotNull BlockBehaviour.Properties _properties ) {
		
		super(
			_properties
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
	
	
	@Nullable
	@Override
	public BlockState getStateForPlacement( @NotNull BlockPlaceContext context ) {
		
		return defaultBlockState().setValue(
			BlockStateProperties.HORIZONTAL_FACING,
			context.getHorizontalDirection().getOpposite()
		);
	}
	
	@NotNull
	@Override
	protected ItemInteractionResult useItemOn(
		@NotNull ItemStack pStack,
		@NotNull BlockState pState,
		@NotNull Level pLevel,
		@NotNull BlockPos pPos,
		@NotNull Player pPlayer,
		@NotNull InteractionHand pHand,
		@NotNull BlockHitResult pHitResult ) {
		
		BowlContent bowlContent = pState.getValue( ModBlockStateProperties.BOWL_CONTENT );
		if( bowlContent == BowlContent.EMPTY ) {
			if( pStack.is( Items.APPLE ) ) {
				if( pStack.getCount() >= APPLE_COUNT ) {
					pLevel.playSound( pPlayer, pPos, SoundEvents.COMPOSTER_FILL, SoundSource.BLOCKS, 1.0F, 1.0F );
					if( !pPlayer.isCreative() ) {
						pStack.shrink( APPLE_COUNT );
					}
					pLevel.setBlock(
						pPos,
						pState.setValue( ModBlockStateProperties.BOWL_CONTENT, BowlContent.APPLES ),
						3
					);
					return ItemInteractionResult.SUCCESS;
				} else {
					if( pLevel.isClientSide() ) {
						pPlayer.sendSystemMessage(
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
				if( pStack.is( Items.COOKIE ) ) {
					if( pStack.getCount() >= COOKIE_COUNT ) {
						pLevel.playSound( pPlayer, pPos, SoundEvents.COMPOSTER_FILL, SoundSource.BLOCKS, 1.0F, 1.0F );
						if( !pPlayer.isCreative() ) {
							pStack.shrink( COOKIE_COUNT );
						}
						pLevel.setBlock(
							pPos,
							pState.setValue( ModBlockStateProperties.BOWL_CONTENT, BowlContent.COOKIES ),
							3
						);
						return ItemInteractionResult.SUCCESS;
					} else {
						if( pLevel.isClientSide() ) {
							pPlayer.sendSystemMessage(
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
			if( pStack.isEmpty() ) {
				pLevel.playSound( pPlayer, pPos, SoundEvents.COMPOSTER_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F );
				if( !pPlayer.isCreative() ) {
					ItemStack dropStack;
					switch( bowlContent ) {
						case APPLES -> dropStack = new ItemStack( Items.APPLE, APPLE_COUNT );
						case COOKIES -> dropStack = new ItemStack( Items.COOKIE, COOKIE_COUNT );
						default -> dropStack = null;
					}
					if( dropStack != null && !pPlayer.addItem( dropStack ) ) {
						pPlayer.drop( dropStack, false );
					}
				}
				pLevel.setBlock(
					pPos,
					pState.setValue( ModBlockStateProperties.BOWL_CONTENT, BowlContent.EMPTY ),
					3
				);
				return ItemInteractionResult.SUCCESS;
			}
		}
		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}
	
	protected void createBlockStateDefinition( @NotNull StateDefinition.Builder<Block, BlockState> builder ) {
		
		builder.add( BlockStateProperties.HORIZONTAL_FACING, ModBlockStateProperties.BOWL_CONTENT );
	}
}
