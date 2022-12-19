package de.geheimagentnr1.manyideas_christmas.handlers;

import de.geheimagentnr1.manyideas_christmas.ManyIdeasChristmas;
import de.geheimagentnr1.manyideas_christmas.elements.blocks.ModBlocks;
import de.geheimagentnr1.manyideas_christmas.elements.creative_mod_tabs.ModCreativeTabs;
import de.geheimagentnr1.manyideas_core.util.BlockRegistrationHelper;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;


@SuppressWarnings( "unused" )
@Mod.EventBusSubscriber( modid = ManyIdeasChristmas.MODID, bus = Mod.EventBusSubscriber.Bus.MOD )
public class ModEventHandler {
	
	
	@OnlyIn( Dist.CLIENT )
	@SubscribeEvent
	public static void handleClientSetupEvent( FMLClientSetupEvent event ) {
		
		BlockRegistrationHelper.registerBlockRenderTypes( ModBlocks.BLOCKS );
	}
	
	@SubscribeEvent
	public static void handleBlockRegistryEvent( RegisterEvent event ) {
		
		if( event.getRegistryKey().equals( ForgeRegistries.Keys.BLOCKS ) ) {
			event.register(
				ForgeRegistries.Keys.BLOCKS,
				registerHelper -> ModBlocks.BLOCKS.forEach( registryEntry -> registerHelper.register(
					registryEntry.getRegistryName(),
					registryEntry.getValue()
				) )
			);
		}
	}
	
	@SubscribeEvent
	public static void handleItemRegistryEvent( RegisterEvent event ) {
		
		if( event.getRegistryKey().equals( ForgeRegistries.Keys.ITEMS ) ) {
			Item.Properties properties = new Item.Properties();
			BlockRegistrationHelper.registerBlockItems( event, ModBlocks.BLOCKS, properties );
		}
	}
	
	@SubscribeEvent
	public static void handleCreativeModeTabRegisterEvent( CreativeModeTabEvent.Register event ) {
		
		ModCreativeTabs.CREATIVE_TAB_FACTORIES.forEach( creativeModeTabFactory ->
			event.registerCreativeModeTab( creativeModeTabFactory.getName(), creativeModeTabFactory ) );
	}
}
