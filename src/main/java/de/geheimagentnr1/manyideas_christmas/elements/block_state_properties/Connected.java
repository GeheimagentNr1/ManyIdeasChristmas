package de.geheimagentnr1.manyideas_christmas.elements.block_state_properties;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;


public enum Connected implements StringRepresentable {
	NON,
	FRONT_LEFT,
	FRONT_RIGHT,
	BACK_LEFT,
	BACK_RIGHT;
	
	@NotNull
	@Override
	public String getSerializedName() {
		
		return name().toLowerCase( Locale.ENGLISH );
	}
}