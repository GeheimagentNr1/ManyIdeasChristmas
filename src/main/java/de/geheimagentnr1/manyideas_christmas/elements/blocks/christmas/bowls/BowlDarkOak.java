package de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.bowls;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;


public class BowlDarkOak extends Bowl {
	
	
	@NotNull
	public static final String registry_name = "bowl_dark_oak";
	
	public BowlDarkOak() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.COLOR_BROWN ) );
	}
}
