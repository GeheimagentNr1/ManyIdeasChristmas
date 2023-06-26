package de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.bowls;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;


public class BowlOak extends Bowl {
	
	
	@NotNull
	public static final String registry_name = "bowl_oak";
	
	public BowlOak() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.WOOD ) );
	}
}
