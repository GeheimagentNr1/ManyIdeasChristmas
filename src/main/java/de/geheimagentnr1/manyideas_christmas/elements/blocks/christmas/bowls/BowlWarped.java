package de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.bowls;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;


public class BowlWarped extends Bowl {
	
	
	public static final String registry_name = "bowl_warped";
	
	public BowlWarped() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.WARPED_HYPHAE ) );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( this, _properties, registry_name );
	}
}
