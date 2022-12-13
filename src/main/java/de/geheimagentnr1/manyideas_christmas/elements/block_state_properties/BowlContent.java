package de.geheimagentnr1.manyideas_christmas.elements.block_state_properties;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;


public enum BowlContent implements StringRepresentable {
	EMPTY,
	APPLES,
	COOKIES;
	
	@NotNull
	@Override
	public String getSerializedName() {
		
		return name().toLowerCase( Locale.ENGLISH );
	}
}
