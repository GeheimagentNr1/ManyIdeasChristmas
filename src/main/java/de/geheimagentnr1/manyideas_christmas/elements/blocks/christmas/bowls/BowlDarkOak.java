package de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.bowls;

import de.geheimagentnr1.manyideas_core.core.registry.RegistryHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;


public class BowlDarkOak extends Bowl {
	
	
	@NotNull
	public static final String registry_name = "bowl_dark_oak";
	
	public BowlDarkOak() {
		
		super( RegistryHelper.withBlockId( BlockBehaviour.Properties.of() ).mapColor( MapColor.COLOR_BROWN ) );
	}
}
