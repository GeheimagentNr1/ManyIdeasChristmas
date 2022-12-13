package de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.bowls;

import net.minecraft.world.item.Item;


public class BowlBirch extends Bowl {
	
	
	public static final String registry_name = "bowl_birch";
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( this, _properties, registry_name );
	}
}
