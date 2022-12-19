package de.geheimagentnr1.manyideas_christmas.elements.creative_mod_tabs;

import de.geheimagentnr1.manyideas_christmas.ManyIdeasChristmas;
import de.geheimagentnr1.manyideas_christmas.elements.blocks.ModBlocks;
import de.geheimagentnr1.manyideas_core.elements.blocks.BlockItemInterface;
import de.geheimagentnr1.manyideas_core.elements.creative_mod_tabs.CreativeModeTabFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;


public class ManyIdeasChristmasCreativeModeTabFactory implements CreativeModeTabFactory {
	
	
	@Override
	public String getModId() {
		
		return ManyIdeasChristmas.MODID;
	}
	
	@Override
	public String getRegistryName() {
		
		return ManyIdeasChristmas.MODID;
	}
	
	@Override
	public Item getDisplayItem() {
		
		return ModBlocks.GOLDEN_STAR.asItem();
	}
	
	@Override
	public List<ItemStack> getDisplayItems() {
		
		return ModBlocks.BLOCKS.stream()
			.filter( registryEntry -> registryEntry.getValue() instanceof BlockItemInterface )
			.map( registryEntry -> new ItemStack( registryEntry.getValue() ) )
			.toList();
	}
}
