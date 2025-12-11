package de.geheimagentnr1.manyideas_christmas.elements.blocks;

import de.geheimagentnr1.manyideas_christmas.ManyIdeasChristmas;
import de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.*;
import de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.bowls.*;
import de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.fireplaces.*;
import de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.wreaths.Wreath;
import de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.wreaths.WreathCandle;
import de.geheimagentnr1.manyideas_core.core.elements.blocks.BlocksRegisterFactory;
import de.geheimagentnr1.manyideas_core.core.registry.RegistryEntry;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public class ModBlocksRegisterFactory extends BlocksRegisterFactory {
	
	
	@NotNull
	@Override
	protected String getModId() {
		
		return ManyIdeasChristmas.MODID;
	}
	
	@SubscribeEvent
	public void registerEvent( @NotNull RegisterEvent event ) {
		
		doRegisterEvent( event );
	}
	
	@NotNull
	public Block getGoldenStar() {
		
		return getBlocks().stream()
			.filter( entry -> entry.getName().equals( GoldenStar.registry_name ) )
			.findFirst()
			.map( RegistryEntry::getValue )
			.orElseThrow();
	}
	
	@NotNull
	@Override
	protected List<RegistryEntry<Block>> blocks() {
		
		return List.of(//BCPFINRLT
			//Christmas: Bowls
			RegistryEntry.create( BowlAcacia.registry_name, new BowlAcacia() ),//BCPFINRLT
			RegistryEntry.create( BowlBirch.registry_name, new BowlBirch() ),//BCPFINRLT
			RegistryEntry.create( BowlCrimson.registry_name, new BowlCrimson() ),//BCPFINRLT
			RegistryEntry.create( BowlDarkOak.registry_name, new BowlDarkOak() ),//BCPFINRLT
			RegistryEntry.create( BowlJungle.registry_name, new BowlJungle() ),//BCPFINRLT
			RegistryEntry.create( BowlOak.registry_name, new BowlOak() ),//BCPFINRLT
			RegistryEntry.create( BowlSpruce.registry_name, new BowlSpruce() ),//BCPFINRLT
			RegistryEntry.create( BowlWarped.registry_name, new BowlWarped() ),//BCPFINRLT
			//Christmas: Fireplaces
			RegistryEntry.create( FireplaceAcacia.registry_name, new FireplaceAcacia() ),//BCPFINRLT
			RegistryEntry.create( FireplaceBirch.registry_name, new FireplaceBirch() ),//BCPFINRLT
			RegistryEntry.create( FireplaceCrimson.registry_name, new FireplaceCrimson() ),//BCPFINRLT
			RegistryEntry.create( FireplaceDarkOak.registry_name, new FireplaceDarkOak() ),//BCPFINRLT
			RegistryEntry.create( FireplaceJungle.registry_name, new FireplaceJungle() ),//BCPFINRLT
			RegistryEntry.create( FireplaceOak.registry_name, new FireplaceOak() ),//BCPFINRLT
			RegistryEntry.create( FireplaceSpruce.registry_name, new FireplaceSpruce() ),//BCPFINRLT
			RegistryEntry.create( FireplaceWarped.registry_name, new FireplaceWarped() ),//BCPFINRLT
			//Christmas: Wreaths
			RegistryEntry.create( Wreath.registry_name, new Wreath() ),//BCPFINRLT
			RegistryEntry.create( WreathCandle.registry_name, new WreathCandle() ),//BCPFINRLT
			//Christmas
			RegistryEntry.create( ChristmasTree.registry_name, new ChristmasTree() ),//BCPFINRLT
			RegistryEntry.create( Garland.registry_name, new Garland() ),//BCPFINRLT
			RegistryEntry.create( GoldenStar.registry_name, new GoldenStar() ),//BCPFINRLT
			RegistryEntry.create( HotChocolate.registry_name, new HotChocolate() ),//BCPFINRLT
			RegistryEntry.create( PlushiCat.registry_name, new PlushiCat() ),//BCPFINRLT
			RegistryEntry.create( Present.registry_name, new Present() )//BCPFINRLT
		);
	}
}
