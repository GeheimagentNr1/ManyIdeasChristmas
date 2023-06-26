package de.geheimagentnr1.manyideas_christmas.helpers;

import de.geheimagentnr1.manyideas_christmas.elements.block_state_properties.DecorationType;
import de.geheimagentnr1.manyideas_christmas.elements.block_state_properties.ModBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;


public class DecorateableBlockHelper {
	
	
	@NotNull
	public static InteractionResult use(
		@NotNull BlockState state,
		@NotNull Level level,
		@NotNull BlockPos pos,
		@NotNull Player player,
		@NotNull InteractionHand hand ) {
		
		DecorationType decorationType = state.getValue( ModBlockStateProperties.DECORATION_TYPE );
		ItemStack stack = player.getItemInHand( hand );
		if( decorationType == DecorationType.NONE ) {
			if( stack.is( Items.GOLD_INGOT ) ) {
				level.playSound( player, pos, SoundEvents.COMPOSTER_FILL, SoundSource.BLOCKS, 1.0F, 1.0F );
				if( !player.isCreative() ) {
					stack.shrink( 1 );
				}
				level.setBlock(
					pos,
					state.setValue( ModBlockStateProperties.DECORATION_TYPE, DecorationType.GOLD ),
					3
				);
				return InteractionResult.SUCCESS;
			} else {
				if( stack.is( Items.SWEET_BERRIES ) ) {
					level.playSound( player, pos, SoundEvents.COMPOSTER_FILL, SoundSource.BLOCKS, 1.0F, 1.0F );
					if( !player.isCreative() ) {
						stack.shrink( 1 );
					}
					level.setBlock(
						pos,
						state.setValue( ModBlockStateProperties.DECORATION_TYPE, DecorationType.RED ),
						3
					);
					return InteractionResult.SUCCESS;
				} else {
					if( stack.is( Items.GLOWSTONE_DUST ) ) {
						level.playSound( player, pos, SoundEvents.COMPOSTER_FILL, SoundSource.BLOCKS, 1.0F, 1.0F );
						if( !player.isCreative() ) {
							stack.shrink( 1 );
						}
						level.setBlock(
							pos,
							state.setValue( ModBlockStateProperties.DECORATION_TYPE, DecorationType.YELLOW ),
							3
						);
						return InteractionResult.SUCCESS;
					}
				}
			}
		} else {
			if( stack.isEmpty() ) {
				level.playSound( player, pos, SoundEvents.COMPOSTER_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F );
				if( !player.isCreative() ) {
					ItemStack dropStack;
					switch( decorationType ) {
						case GOLD -> dropStack = new ItemStack( Items.GOLD_INGOT );
						case RED -> dropStack = new ItemStack( Items.SWEET_BERRIES );
						case YELLOW -> dropStack = new ItemStack( Items.GLOWSTONE_DUST );
						default -> dropStack = null;
					}
					if( dropStack != null && !player.addItem( dropStack ) ) {
						player.drop( dropStack, false );
					}
				}
				level.setBlock(
					pos,
					state.setValue( ModBlockStateProperties.DECORATION_TYPE, DecorationType.NONE ),
					3
				);
			}
		}
		return InteractionResult.PASS;
	}
}
