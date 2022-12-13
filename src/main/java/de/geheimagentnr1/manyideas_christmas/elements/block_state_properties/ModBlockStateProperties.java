package de.geheimagentnr1.manyideas_christmas.elements.block_state_properties;

import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;


public class ModBlockStateProperties {
	
	
	public static final EnumProperty<BowlContent> BOWL_CONTENT = EnumProperty.create(
		"bowl_content",
		BowlContent.class
	);
	
	public static final EnumProperty<Connected> CONNECTED = EnumProperty.create( "connected", Connected.class );
	
	public static final EnumProperty<DecorationType> DECORATION_TYPE = EnumProperty.create(
		"decoration_type",
		DecorationType.class
	);
	
	public static final IntegerProperty PRESENT_COUNT = IntegerProperty.create( "present_count", 1, 4 );
	
	public static final IntegerProperty WREATH_CANDLE_LIT_COUNT = IntegerProperty.create( "lit_count", 0, 4 );
}
