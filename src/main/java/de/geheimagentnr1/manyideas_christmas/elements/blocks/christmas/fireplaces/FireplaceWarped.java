package de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.fireplaces;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;


public class FireplaceWarped extends Fireplace {
	
	
	@NotNull
	public static final String registry_name = "fireplace_warped";
	
	public FireplaceWarped() {
		
		super( BlockBehaviour.Properties.of().mapColor( MapColor.WARPED_HYPHAE ) );
	}
}
