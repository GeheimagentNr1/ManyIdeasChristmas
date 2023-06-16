package de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.bowls;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;


public class BowlSpruce extends Bowl {
	
	
	public static final String registry_name = "bowl_spruce";
	
	public BowlSpruce() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.PODZOL ) );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( this, _properties, registry_name );
	}
}
