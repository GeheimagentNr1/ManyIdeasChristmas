package de.geheimagentnr1.manyideas_christmas;

import de.geheimagentnr1.manyideas_core.core.AbstractMod;
import de.geheimagentnr1.manyideas_christmas.elements.blocks.ModBlocksRegisterFactory;
import de.geheimagentnr1.manyideas_christmas.elements.creative_mod_tabs.ModCreativeModeTabRegisterFactory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.jetbrains.annotations.NotNull;


@Mod( ManyIdeasChristmas.MODID )
public class ManyIdeasChristmas extends AbstractMod {
	
	
	@NotNull
	public static final String MODID = "manyideas_christmas";
	
	public ManyIdeasChristmas( @NotNull IEventBus modEventBus, @NotNull ModContainer modContainer ) {
		
		super( modEventBus, modContainer );
	}
	
	@NotNull
	@Override
	public String getModId() {
		
		return MODID;
	}
	
	@Override
	protected void initMod() {
		
		ModBlocksRegisterFactory modBlocksRegisterFactory = registerEventHandler( new ModBlocksRegisterFactory() );
		registerEventHandler( new ModCreativeModeTabRegisterFactory( modBlocksRegisterFactory ) );
	}
}
