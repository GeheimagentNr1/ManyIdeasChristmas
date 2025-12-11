package de.geheimagentnr1.manyideas_christmas.elements.creative_mod_tabs;

import de.geheimagentnr1.manyideas_christmas.ManyIdeasChristmas;
import de.geheimagentnr1.manyideas_core.core.elements.creative_mod_tabs.CreativeModeTabFactory;
import de.geheimagentnr1.manyideas_core.core.registry.RegistryEntry;
import de.geheimagentnr1.manyideas_christmas.elements.blocks.ModBlocksRegisterFactory;
import lombok.RequiredArgsConstructor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.List;


@RequiredArgsConstructor
public class ManyIdeasChristmasCreativeModeTabFactory implements CreativeModeTabFactory {
	
	
	@NotNull
	private final ModBlocksRegisterFactory modBlocksRegisterFactory;
	
	@NotNull
	@Override
	public String getRegistryName() {
		
		return ManyIdeasChristmas.MODID;
	}
	
	@NotNull
	@Override
	public ItemLike getIconItem() {
		
		return modBlocksRegisterFactory.getGoldenStar();
	}
	
	@NotNull
	@Override
	public List<RegistryEntry<Block>> getDisplayBlocks() {
		
		return modBlocksRegisterFactory.getBlocks();
	}
	
	@NotNull
	@Override
	public List<RegistryEntry<Item>> getDisplayItems() {
		
		return List.of();
	}
}
