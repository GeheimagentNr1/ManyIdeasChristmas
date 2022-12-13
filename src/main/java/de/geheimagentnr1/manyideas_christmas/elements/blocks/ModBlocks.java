package de.geheimagentnr1.manyideas_christmas.elements.blocks;

import de.geheimagentnr1.manyideas_christmas.ManyIdeasChristmas;
import de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.*;
import de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.bowls.*;
import de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.fireplaces.*;
import de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.wreaths.Wreath;
import de.geheimagentnr1.manyideas_christmas.elements.blocks.christmas.wreaths.WreathCandle;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ObjectHolder;


@SuppressWarnings( { "StaticNonFinalField", "PublicField", "PublicStaticArrayField", "unused" } )
public class ModBlocks {
	
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
	
	public static final Block[] BLOCKS = new Block[] {//BCPFINRLT
		//Christmas: Bowls
		new BowlAcacia(),//BCPFINRLT
		new BowlBirch(),//BCPFINRLT
		new BowlCrimson(),//BCPFINRLT
		new BowlDarkOak(),//BCPFINRLT
		new BowlJungle(),//BCPFINRLT
		new BowlOak(),//BCPFINRLT
		new BowlSpruce(),//BCPFINRLT
		new BowlWarped(),//BCPFINRLT
		//Christmas: Fireplaces
		new FireplaceAcacia(),//BCPFINRLT
		new FireplaceBirch(),//BCPFINRLT
		new FireplaceCrimson(),//BCPFINRLT
		new FireplaceDarkOak(),//BCPFINRLT
		new FireplaceJungle(),//BCPFINRLT
		new FireplaceOak(),//BCPFINRLT
		new FireplaceSpruce(),//BCPFINRLT
		new FireplaceWarped(),//BCPFINRLT
		//Christmas: Wreaths
		new Wreath(),//BCPFINRLT
		new WreathCandle(),//BCPFINRLT
		//Christmas
		new ChristmasTree(),//BCPFINRLT
		new Garland(),//BCPFINRLT
		new GoldenStar(),//BCPFINRLT
		new HotChocolate(),//BCPFINRLT
		new PlushiCat(),//BCPFINRLT
		new Present(),//BCPFINRLT
	};
	
	//Christmas: Bowls
	
	@ObjectHolder( ManyIdeasChristmas.MODID + ":" + BowlAcacia.registry_name )
	public static BowlAcacia BOWL_ACACIA;
	
	@ObjectHolder( ManyIdeasChristmas.MODID + ":" + BowlBirch.registry_name )
	public static BowlBirch BOWL_BIRCH;
	
	@ObjectHolder( ManyIdeasChristmas.MODID + ":" + BowlCrimson.registry_name )
	public static BowlCrimson BOWL_CRIMSON;
	
	@ObjectHolder( ManyIdeasChristmas.MODID + ":" + BowlDarkOak.registry_name )
	public static BowlDarkOak BOWL_DARK_OAK;
	
	@ObjectHolder( ManyIdeasChristmas.MODID + ":" + BowlJungle.registry_name )
	public static BowlJungle BOWL_JUNGLE;
	
	@ObjectHolder( ManyIdeasChristmas.MODID + ":" + BowlOak.registry_name )
	public static BowlOak BOWL_OAK;
	
	@ObjectHolder( ManyIdeasChristmas.MODID + ":" + BowlSpruce.registry_name )
	public static BowlSpruce BOWL_SPRUCE;
	
	@ObjectHolder( ManyIdeasChristmas.MODID + ":" + BowlWarped.registry_name )
	public static BowlWarped BOWL_WARPED;
	
	//Christmas: Fireplaces
	
	@ObjectHolder( ManyIdeasChristmas.MODID + ":" + FireplaceAcacia.registry_name )
	public static FireplaceAcacia FIREPLACE_ACACIA;
	
	@ObjectHolder( ManyIdeasChristmas.MODID + ":" + FireplaceBirch.registry_name )
	public static FireplaceBirch FIREPLACE_BIRCH;
	
	@ObjectHolder( ManyIdeasChristmas.MODID + ":" + FireplaceCrimson.registry_name )
	public static FireplaceCrimson FIREPLACE_CRIMSON;
	
	@ObjectHolder( ManyIdeasChristmas.MODID + ":" + FireplaceDarkOak.registry_name )
	public static FireplaceDarkOak FIREPLACE_DARK_OAK;
	
	@ObjectHolder( ManyIdeasChristmas.MODID + ":" + FireplaceJungle.registry_name )
	public static FireplaceJungle FIREPLACE_JUNGLE;
	
	@ObjectHolder( ManyIdeasChristmas.MODID + ":" + FireplaceOak.registry_name )
	public static FireplaceOak FIREPLACE_OAK;
	
	@ObjectHolder( ManyIdeasChristmas.MODID + ":" + FireplaceSpruce.registry_name )
	public static FireplaceSpruce FIREPLACE_SPRUCE;
	
	@ObjectHolder( ManyIdeasChristmas.MODID + ":" + FireplaceWarped.registry_name )
	public static FireplaceWarped FIREPLACE_WARPED;
	
	//Christmas: Wreaths
	
	@ObjectHolder( ManyIdeasChristmas.MODID + ":" + Wreath.registry_name )
	public static Wreath WREATH;
	
	@ObjectHolder( ManyIdeasChristmas.MODID + ":" + WreathCandle.registry_name )
	public static WreathCandle WREATH_CANDLE;
	
	//Christmas
	
	@ObjectHolder( ManyIdeasChristmas.MODID + ":" + ChristmasTree.registry_name )
	public static ChristmasTree CHRISTMAS_TREE;
	
	@ObjectHolder( ManyIdeasChristmas.MODID + ":" + Garland.registry_name )
	public static Garland GARLAND;
	
	@ObjectHolder( ManyIdeasChristmas.MODID + ":" + GoldenStar.registry_name )
	public static GoldenStar GOLDEN_STAR;
	
	@ObjectHolder( ManyIdeasChristmas.MODID + ":" + HotChocolate.registry_name )
	public static HotChocolate HOT_CHOCOLATE;
	
	@ObjectHolder( ManyIdeasChristmas.MODID + ":" + PlushiCat.registry_name )
	public static PlushiCat PLUSHI_CAT;
	
	@ObjectHolder( ManyIdeasChristmas.MODID + ":" + Present.registry_name )
	public static Present PRESENT;
}
