package de.geheimagentnr1.manyideas_christmas.elements.blocks;

import de.geheimagentnr1.manyideas_christmas.ManyIdeasChristmas;
import de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.*;
import de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.bowls.*;
import de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.fireplaces.*;
import de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.wreaths.Wreath;
import de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.wreaths.WreathCandle;
import de.geheimagentnr1.minecraft_forge_api.elements.blocks.BlocksRegisterFactory;
import de.geheimagentnr1.minecraft_forge_api.registry.RegistryEntry;
import de.geheimagentnr1.minecraft_forge_api.registry.RegistryKeys;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ObjectHolder;
import org.jetbrains.annotations.NotNull;

import java.util.List;


@SuppressWarnings( { "StaticNonFinalField", "PublicField", "unused" } )
public class ModBlocksRegisterFactory extends BlocksRegisterFactory {
	
	//TODO:
	// B - Block Textur fertig
	// C - Cullface korrekt
	// P - Partikel fertig
	// F - Funktion fertig
	// I - Item fertig
	// N - Name und Registierungsname vorhanden und fertig
	// R - Rezept fertig
	// L - Loottable fertig
	// T - Tags fertig
	
	//Christmas: Bowls
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasChristmas.MODID + ":" + BowlAcacia.registry_name )
	public static BowlAcacia BOWL_ACACIA;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasChristmas.MODID + ":" + BowlBirch.registry_name )
	public static BowlBirch BOWL_BIRCH;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasChristmas.MODID + ":" + BowlCrimson.registry_name )
	public static BowlCrimson BOWL_CRIMSON;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasChristmas.MODID + ":" + BowlDarkOak.registry_name )
	public static BowlDarkOak BOWL_DARK_OAK;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasChristmas.MODID + ":" + BowlJungle.registry_name )
	public static BowlJungle BOWL_JUNGLE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasChristmas.MODID + ":" + BowlOak.registry_name )
	public static BowlOak BOWL_OAK;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasChristmas.MODID + ":" + BowlSpruce.registry_name )
	public static BowlSpruce BOWL_SPRUCE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasChristmas.MODID + ":" + BowlWarped.registry_name )
	public static BowlWarped BOWL_WARPED;
	
	//Christmas: Fireplaces
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasChristmas.MODID + ":" + FireplaceAcacia.registry_name )
	public static FireplaceAcacia FIREPLACE_ACACIA;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasChristmas.MODID + ":" + FireplaceBirch.registry_name )
	public static FireplaceBirch FIREPLACE_BIRCH;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasChristmas.MODID + ":" + FireplaceCrimson.registry_name )
	public static FireplaceCrimson FIREPLACE_CRIMSON;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasChristmas.MODID + ":" + FireplaceDarkOak.registry_name )
	public static FireplaceDarkOak FIREPLACE_DARK_OAK;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasChristmas.MODID + ":" + FireplaceJungle.registry_name )
	public static FireplaceJungle FIREPLACE_JUNGLE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasChristmas.MODID + ":" + FireplaceOak.registry_name )
	public static FireplaceOak FIREPLACE_OAK;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasChristmas.MODID + ":" + FireplaceSpruce.registry_name )
	public static FireplaceSpruce FIREPLACE_SPRUCE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasChristmas.MODID + ":" + FireplaceWarped.registry_name )
	public static FireplaceWarped FIREPLACE_WARPED;
	
	//Christmas: Wreaths
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasChristmas.MODID + ":" + Wreath.registry_name )
	public static Wreath WREATH;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasChristmas.MODID + ":" + WreathCandle.registry_name )
	public static WreathCandle WREATH_CANDLE;
	
	//Christmas
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasChristmas.MODID + ":" + ChristmasTree.registry_name )
	public static ChristmasTree CHRISTMAS_TREE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasChristmas.MODID + ":" + Garland.registry_name )
	public static Garland GARLAND;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasChristmas.MODID + ":" + GoldenStar.registry_name )
	public static GoldenStar GOLDEN_STAR;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasChristmas.MODID + ":" + HotChocolate.registry_name )
	public static HotChocolate HOT_CHOCOLATE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasChristmas.MODID + ":" + PlushiCat.registry_name )
	public static PlushiCat PLUSHI_CAT;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasChristmas.MODID + ":" + Present.registry_name )
	public static Present PRESENT;
	
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
