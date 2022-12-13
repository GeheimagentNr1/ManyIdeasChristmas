package de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.fireplaces;

import net.minecraft.world.item.Item;


public class FireplaceOak extends Fireplace {
	
	
	public static final String registry_name = "fireplace_oak";
	
	@Override
	public Item getBlockItem( Item.Properties properties ) {
		
		return createBlockItem( this, properties, registry_name );
	}
}
