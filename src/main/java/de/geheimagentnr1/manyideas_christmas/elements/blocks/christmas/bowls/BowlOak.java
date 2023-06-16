package de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.bowls;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;


public class BowlOak extends Bowl {
	
	
	public static final String registry_name = "bowl_oak";
	
	public BowlOak() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.WOOD ) );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( this, _properties, registry_name );
	}
}
