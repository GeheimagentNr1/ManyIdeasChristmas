package de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.fireplaces;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;


public class FireplaceSpruce extends Fireplace {
	
	
	public static final String registry_name = "fireplace_spruce";
	
	public FireplaceSpruce() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.PODZOL ) );
	}
	
	@Override
	public Item getBlockItem( Item.Properties properties ) {
		
		return createBlockItem( this, properties, registry_name );
	}
}
