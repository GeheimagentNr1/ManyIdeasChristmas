package de.geheimagentnr1.manyideas_christmas.elements.item_groups;

import de.geheimagentnr1.manyideas_christmas.ManyIdeasChristmas;
import de.geheimagentnr1.manyideas_christmas.elements.blocks.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;


public class ManyIdeasChristmasItemGroup extends CreativeModeTab {
	
	
	//package-private
	ManyIdeasChristmasItemGroup() {
		
		super( ManyIdeasChristmas.MODID );
	}
	
	@NotNull
	@Override
	public ItemStack makeIcon() {
		
		return new ItemStack( ModBlocks.GOLDEN_STAR );
	}
}
