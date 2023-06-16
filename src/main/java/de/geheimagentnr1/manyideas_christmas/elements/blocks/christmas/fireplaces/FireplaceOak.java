package de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.fireplaces;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;


public class FireplaceOak extends Fireplace {
	
	
	public static final String registry_name = "fireplace_oak";
	
	public FireplaceOak() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.WOOD ) );
	}
	
	@Override
	public Item getBlockItem( Item.Properties properties ) {
		
		return createBlockItem( this, properties, registry_name );
	}
}
