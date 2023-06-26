package de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.bowls;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;


public class BowlBirch extends Bowl {
	
	
	@NotNull
	public static final String registry_name = "bowl_birch";
	
	public BowlBirch() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.SAND ) );
	}
}
