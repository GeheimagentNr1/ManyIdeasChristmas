package de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.fireplaces;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;


public class FireplaceCrimson extends Fireplace {
	
	
	public static final String registry_name = "fireplace_crimson";
	
	public FireplaceCrimson() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.CRIMSON_HYPHAE ) );
	}
	
	@Override
	public Item getBlockItem( Item.Properties properties ) {
		
		return createBlockItem( this, properties, registry_name );
	}
}
