package de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.fireplaces;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;


public class FireplaceBirch extends Fireplace {
	
	
	@NotNull
	public static final String registry_name = "fireplace_birch";
	
	public FireplaceBirch() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.SAND ) );
	}
}
