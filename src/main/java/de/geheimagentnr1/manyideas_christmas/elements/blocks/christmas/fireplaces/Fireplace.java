package de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.fireplaces;

import de.geheimagentnr1.manyideas_core.elements.blocks.BlockRenderTypeInterface;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.multi_block.MultiBlock;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;


public abstract class Fireplace extends MultiBlock implements BlockRenderTypeInterface {
	
	
	private static final VoxelShapeMemory TOP_LEFT_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		VoxelShapeVector.create( 0, 14, 0, 16, 16, 16 ),
		VoxelShapeVector.create( 0, 12, 3, 15, 14, 16 ),
		VoxelShapeVector.create( 6, 0, 8, 15, 12, 16 ),
		VoxelShapeVector.create( 0, 0, 14, 6, 12, 16 ),
		VoxelShapeVector.create( 6, 10, 4, 15, 12, 8 ),
		VoxelShapeVector.create( 7, 9, 5, 14, 10, 8 ),
		VoxelShapeVector.create( 13, 0, 6, 14, 9, 8 ),
		VoxelShapeVector.create( 8, 0, 7, 13, 9, 8 ),
		VoxelShapeVector.create( 8, 2.5, 6, 13, 3.5, 7 ),
		VoxelShapeVector.create( 11, 0, 6, 12, 2.5, 7 ),
		VoxelShapeVector.create( 9, 0, 6, 10, 2.5, 7 ),
		VoxelShapeVector.create( 7, 0, 6, 8, 9, 8 ),
		VoxelShapeVector.create( 8, 5.25, 6.01, 8.5, 7.25, 7 ),
		VoxelShapeVector.create( 8.5, 4.75, 6.01, 9, 7.75, 7 ),
		VoxelShapeVector.create( 9, 4.25, 6.01, 9.5, 8.25, 7 ),
		VoxelShapeVector.create( 9.5, 3.75, 6.01, 10, 8.75, 7 ),
		VoxelShapeVector.create( 10, 3.5, 6.01, 11, 9.5, 7 ),
		VoxelShapeVector.create( 11, 3.75, 6.01, 11.5, 8.75, 7 ),
		VoxelShapeVector.create( 11.5, 4.25, 6.01, 12, 8.25, 7 ),
		VoxelShapeVector.create( 12, 4.75, 6.01, 12.5, 7.75, 7 ),
		VoxelShapeVector.create( 12.5, 5.25, 6.01, 13, 7.25, 7 ),
		VoxelShapeVector.create( 1, 10, 9, 6, 12, 14 ),
		VoxelShapeVector.create( 2, 8, 10, 5, 10, 13 ),
		VoxelShapeVector.create( 5.5, 0, 8.5, 6, 12, 14 ),
		VoxelShapeVector.create( 5, 0, 9, 5.5, 12, 14 ),
		VoxelShapeVector.create( 4.5, 0, 9.5, 5, 12, 14 ),
		VoxelShapeVector.create( 4, 0, 10, 4.5, 12, 14 ),
		VoxelShapeVector.create( 3.5, 0, 10.5, 4, 12, 14 ),
		VoxelShapeVector.create( 3, 0, 11, 3.5, 12, 14 ),
		VoxelShapeVector.create( 2.5, 0, 11.5, 3, 12, 14 ),
		VoxelShapeVector.create( 2, 0, 12, 2.5, 12, 14 ),
		VoxelShapeVector.create( 1.5, 0, 12.5, 2, 12, 14 ),
		VoxelShapeVector.create( 1, 0, 13, 1.5, 12, 14 ),
		VoxelShapeVector.create( 0.5, 0, 13.5, 1, 12, 14 )
	);
	
	private static final VoxelShapeMemory TOP_MIDDLE_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		VoxelShapeVector.create( 0, 14, 0, 16, 16, 16 ),
		VoxelShapeVector.create( 0, 12, 3, 16, 14, 16 )
	);
	
	private static final VoxelShapeMemory TOP_RIGHT_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		VoxelShapeVector.create( 0, 14, 0, 16, 16, 16 ),
		VoxelShapeVector.create( 1, 12, 3, 16, 14, 16 ),
		VoxelShapeVector.create( 1, 0, 8, 10, 12, 16 ),
		VoxelShapeVector.create( 10, 0, 14, 16, 12, 16 ),
		VoxelShapeVector.create( 1, 10, 4, 10, 12, 8 ),
		VoxelShapeVector.create( 2, 9, 5, 9, 10, 8 ),
		VoxelShapeVector.create( 8, 0, 6, 9, 9, 8 ),
		VoxelShapeVector.create( 3, 0, 7, 8, 9, 8 ),
		VoxelShapeVector.create( 3, 2.5, 6, 8, 3.5, 7 ),
		VoxelShapeVector.create( 6, 0, 6, 7, 2.5, 7 ),
		VoxelShapeVector.create( 4, 0, 6, 5, 2.5, 7 ),
		VoxelShapeVector.create( 2, 0, 6, 3, 9, 8 ),
		
		VoxelShapeVector.create( 3, 5.25, 6.01, 3.5, 7.25, 7 ),
		VoxelShapeVector.create( 3.5, 4.75, 6.01, 4, 7.75, 7 ),
		VoxelShapeVector.create( 4, 4.25, 6.01, 4.5, 8.25, 7 ),
		VoxelShapeVector.create( 4.5, 3.75, 6.01, 5, 8.75, 7 ),
		VoxelShapeVector.create( 5, 3.5, 6.01, 6, 9.5, 7 ),
		VoxelShapeVector.create( 6, 3.75, 6.01, 6.5, 8.75, 7 ),
		VoxelShapeVector.create( 6.5, 4.25, 6.01, 7, 8.25, 7 ),
		VoxelShapeVector.create( 7, 4.75, 6.01, 7.5, 7.75, 7 ),
		VoxelShapeVector.create( 7.5, 5.25, 6.01, 8, 7.25, 7 ),
		
		VoxelShapeVector.create( 10, 10, 9, 15, 12, 14 ),
		VoxelShapeVector.create( 11, 8, 10, 14, 10, 13 ),
		
		VoxelShapeVector.create( 10, 0, 8.5, 10.5, 12, 14 ),
		VoxelShapeVector.create( 10.5, 0, 9, 11, 12, 14 ),
		VoxelShapeVector.create( 11, 0, 9.5, 11.5, 12, 14 ),
		VoxelShapeVector.create( 11.5, 0, 10, 12, 12, 14 ),
		VoxelShapeVector.create( 12, 0, 10.5, 12.5, 12, 14 ),
		VoxelShapeVector.create( 12.5, 0, 11, 13, 12, 14 ),
		VoxelShapeVector.create( 13, 0, 11.5, 13.5, 12, 14 ),
		VoxelShapeVector.create( 13.5, 0, 12, 14, 12, 14 ),
		VoxelShapeVector.create( 14, 0, 12.5, 14.5, 12, 14 ),
		VoxelShapeVector.create( 14.5, 0, 13, 15, 12, 14 ),
		VoxelShapeVector.create( 15, 0, 13.5, 15.5, 12, 14 )
	);
	
	private static final VoxelShapeMemory BOTTOM_LEFT_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		VoxelShapeVector.create( 6, 0, 8, 15, 16, 16 ),
		VoxelShapeVector.create( 6, 0, 4, 15, 2, 8 ),
		VoxelShapeVector.create( 7, 2, 5, 14, 3, 8 ),
		VoxelShapeVector.create( 13, 3, 6, 14, 16, 8 ),
		VoxelShapeVector.create( 8, 3, 7, 13, 16, 8 ),
		VoxelShapeVector.create( 11, 3, 6, 12, 16, 7 ),
		VoxelShapeVector.create( 9, 3, 6, 10, 16, 7 ),
		VoxelShapeVector.create( 7, 3, 6, 8, 16, 8 ),
		VoxelShapeVector.create( 0, 0, 14, 6, 16, 16 ),
		VoxelShapeVector.create( 0, 0, 8, 6, 3, 14 ),
		VoxelShapeVector.create( 5.5, 3, 8.5, 6, 16, 14 ),
		VoxelShapeVector.create( 5, 3, 9, 5.5, 16, 14 ),
		VoxelShapeVector.create( 4.5, 3, 9.5, 5, 16, 14 ),
		VoxelShapeVector.create( 4, 3, 10, 4.5, 16, 14 ),
		VoxelShapeVector.create( 3.5, 3, 10.5, 4, 16, 14 ),
		VoxelShapeVector.create( 3, 3, 11, 3.5, 16, 14 ),
		VoxelShapeVector.create( 2.5, 3, 11.5, 3, 16, 14 ),
		VoxelShapeVector.create( 2, 3, 12, 2.5, 16, 14 ),
		VoxelShapeVector.create( 1.5, 3, 12.5, 2, 16, 14 ),
		VoxelShapeVector.create( 1, 3, 13, 1.5, 16, 14 ),
		VoxelShapeVector.create( 0.5, 3, 13.5, 1, 16, 14 )
	);
	
	private static final VoxelShapeMemory BOTTOM_MIDDLE_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		VoxelShapeVector.create( 0, 0, 8, 16, 3, 16 ),
		VoxelShapeVector.create( 0, 4, 15, 16, 5, 16 ),
		VoxelShapeVector.create( 0, 3, 14, 1, 6, 15 ),
		VoxelShapeVector.create( 3, 3, 14, 4, 6, 15 ),
		VoxelShapeVector.create( 6, 3, 14, 7, 6, 15 ),
		VoxelShapeVector.create( 9, 3, 14, 10, 6, 15 ),
		VoxelShapeVector.create( 12, 3, 14, 13, 6, 15 ),
		VoxelShapeVector.create( 15, 3, 14, 16, 6, 15 )
	);
	
	private static final VoxelShapeMemory BOTTOM_MIDDLE_COLLISION_SHAPES =
		VoxelShapeMemory.createHorizontalVoxelShapes(
			Direction.SOUTH,
			VoxelShapeVector.create( 0, 0, 8, 16, 3, 16 )
		);
	
	private static final VoxelShapeMemory BOTTOM_RIGHT_SHAPES = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		VoxelShapeVector.create( 1, 0, 8, 10, 16, 16 ),
		VoxelShapeVector.create( 1, 0, 4, 10, 2, 8 ),
		VoxelShapeVector.create( 2, 2, 5, 9, 3, 8 ),
		VoxelShapeVector.create( 8, 3, 6, 9, 16, 8 ),
		VoxelShapeVector.create( 3, 3, 7, 8, 16, 8 ),
		VoxelShapeVector.create( 6, 3, 6, 7, 16, 7 ),
		VoxelShapeVector.create( 4, 3, 6, 5, 16, 7 ),
		VoxelShapeVector.create( 2, 3, 6, 3, 16, 8 ),
		VoxelShapeVector.create( 10, 0, 14, 16, 16, 16 ),
		VoxelShapeVector.create( 10, 0, 8, 16, 3, 14 ),
		VoxelShapeVector.create( 10, 3, 8.5, 10.5, 16, 14 ),
		VoxelShapeVector.create( 10.5, 3, 9, 11, 16, 14 ),
		VoxelShapeVector.create( 11, 3, 9.5, 11.5, 16, 14 ),
		VoxelShapeVector.create( 11.5, 3, 10, 12, 16, 14 ),
		VoxelShapeVector.create( 12, 3, 10.5, 12.5, 16, 14 ),
		VoxelShapeVector.create( 12.5, 3, 11, 13, 16, 14 ),
		VoxelShapeVector.create( 13, 3, 11.5, 13.5, 16, 14 ),
		VoxelShapeVector.create( 13.5, 3, 12, 14, 16, 14 ),
		VoxelShapeVector.create( 14, 3, 12.5, 14.5, 16, 14 ),
		VoxelShapeVector.create( 14.5, 3, 13, 15, 16, 14 ),
		VoxelShapeVector.create( 15, 3, 13.5, 15.5, 16, 14 )
	);
	
	Fireplace( String registry_name ) {
		
		super(
			Properties.of( Material.STONE, MaterialColor.COLOR_RED )
				.requiresCorrectToolForDrops()
				.noOcclusion()
				.strength( 2.0F, 6.0F )
				.sound( SoundType.STONE ),
			registry_name
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
		boolean top = state.getValue( Y_SIZE ) == 1;
		return switch( state.getValue( Z_SIZE ) ) {
			case 0 -> top ? TOP_LEFT_SHAPES.getShapeFromHorizontalFacing( facing )
				: BOTTOM_LEFT_SHAPES.getShapeFromHorizontalFacing( facing );
			case 1 -> top ? TOP_MIDDLE_SHAPES.getShapeFromHorizontalFacing( facing )
				: BOTTOM_MIDDLE_SHAPES.getShapeFromHorizontalFacing( facing );
			case 2 -> top ? TOP_RIGHT_SHAPES.getShapeFromHorizontalFacing( facing )
				: BOTTOM_RIGHT_SHAPES.getShapeFromHorizontalFacing( facing );
			default -> Shapes.block();
		};
	}
	
	@NotNull
	@Override
	public VoxelShape getCollisionShape(
		@NotNull BlockState state,
		@NotNull BlockGetter level,
		@NotNull BlockPos pos,
		@NotNull CollisionContext context ) {
		
		if( state.getValue( Y_SIZE ) == 0 && state.getValue( Z_SIZE ) == 1 ) {
			return BOTTOM_MIDDLE_COLLISION_SHAPES.getShapeFromHorizontalFacing(
				state.getValue( BlockStateProperties.HORIZONTAL_FACING )
			);
		}
		return super.getCollisionShape( state, level, pos, context );
	}
	
	@Override
	protected int getXSize() {
		
		return 1;
	}
	
	@Override
	protected int getYSize() {
		
		return 2;
	}
	
	@Override
	protected int getZSize() {
		
		return 3;
	}
	
	@Override
	protected boolean[][][] hasBlockStatesAtPos() {
		
		return new boolean[][][] {
			{
				{ true, true, true },
				{ true, true, true }
			}
		};
	}
	
	@Override
	public RenderType getRenderType() {
		
		return RenderType.cutout();
	}
}
