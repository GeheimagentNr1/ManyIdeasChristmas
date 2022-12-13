package de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas;

import de.geheimagentnr1.manyideas_core.elements.block_state_properties.EveryDirectionFacing;
import de.geheimagentnr1.manyideas_core.elements.block_state_properties.ModBlockStateProperties;
import de.geheimagentnr1.manyideas_core.elements.blocks.BlockItemInterface;
import de.geheimagentnr1.manyideas_core.elements.blocks.BlockRenderTypeInterface;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.EveryDirectionBlock;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.EveryDirectionFacingVoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;


public class PlushiCat extends EveryDirectionBlock implements BlockItemInterface, BlockRenderTypeInterface {
	
	
	public static final String registry_name = "plushi_cat";
	
	private static final EveryDirectionFacingVoxelShapeMemory SHAPES =
		EveryDirectionFacingVoxelShapeMemory.createEveryDirectionVoxelShapes(
			EveryDirectionFacing.DOWN_SOUTH,
			VoxelShapeVector.create( 5, 0, 5, 10, 2, 13 ),
			VoxelShapeVector.create( 4, 0, 9, 5, 1, 11 ),
			VoxelShapeVector.create( 4.5, 0, 3, 9, 4, 7 ),
			VoxelShapeVector.create( 5, 0, 1.5, 10, 1, 5.5 ),
			VoxelShapeVector.create( 10, 0, 7, 12, 1, 12.5 )
		);
	
	public PlushiCat() {
		
		super(
			Properties.of( Material.CLOTH_DECORATION )
				.strength( 0.1F )
				.sound( SoundType.WOOL )
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
		
		return SHAPES.getShapeFromEveryDirectionFacing( state.getValue( ModBlockStateProperties.EVERY_DIRECTION_FACING ) );
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
		
		level.playSound( player, pos, SoundEvents.CAT_PURR, SoundSource.NEUTRAL, 1.0F, 1.0F );
		return InteractionResult.SUCCESS;
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
