package de.geheimagentnr1.manyideas_christmas.handlers;

import de.geheimagentnr1.manyideas_christmas.ManyIdeasChristmas;
import de.geheimagentnr1.manyideas_christmas.elements.blocks.ModBlocks;
import de.geheimagentnr1.manyideas_christmas.elements.item_groups.ModItemGroups;
import de.geheimagentnr1.manyideas_core.util.BlockRegistrationHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@SuppressWarnings( "unused" )
@Mod.EventBusSubscriber( modid = ManyIdeasChristmas.MODID, bus = Mod.EventBusSubscriber.Bus.MOD )
public class ModEventHandler {
	
	
	@OnlyIn( Dist.CLIENT )
	@SubscribeEvent
	public static void handleClientSetupEvent( FMLClientSetupEvent event ) {
		
		BlockRegistrationHelper.registerBlockRenderTypes( ModBlocks.BLOCKS );
		Minecraft minecraft = Minecraft.getInstance();
		BlockColors blockColors = minecraft.getBlockColors();
		ItemColors itemColors = minecraft.getItemColors();
		blockColors.register(
			( state, blockAndTintGetter, pos, tint ) -> FoliageColor.getEvergreenColor(),
			ModBlocks.CHRISTMAS_TREE
		);
		itemColors.register(
			( stack, tint ) -> {
				BlockState state = ( (BlockItem)stack.getItem() ).getBlock().defaultBlockState();
				return blockColors.getColor( state, null, null, tint );
			},
			ModBlocks.CHRISTMAS_TREE
		);
	}
	
	@SubscribeEvent
	public static void handleBlockRegistryEvent( RegistryEvent.Register<Block> event ) {
		
		event.getRegistry().registerAll( ModBlocks.BLOCKS );
	}
	
	@SubscribeEvent
	public static void handleItemRegistryEvent( RegistryEvent.Register<Item> event ) {
		
		Item.Properties properties = new Item.Properties().tab( ModItemGroups.MANYIDEAS_CHRISTMAS_ITEM_GROUP );
		
		BlockRegistrationHelper.registerBlockItems( event, ModBlocks.BLOCKS, properties );
	}
}
