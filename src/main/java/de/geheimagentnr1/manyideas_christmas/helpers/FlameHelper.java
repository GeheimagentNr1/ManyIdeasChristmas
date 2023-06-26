package de.geheimagentnr1.manyideas_christmas.helpers;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;


public class FlameHelper {
	
	
	public static void animateFlames(
		@NotNull Vec3 flamePos,
		@NotNull Level level,
		@NotNull BlockPos pos,
		@NotNull RandomSource randomSource,
		double rotation ) {
		
		float randomFactor = randomSource.nextFloat();
		Vec3 position = turnVector( flamePos, createYturnMatrix( rotation ) )
			.multiply( 0.0625, 0.0625, 0.0625 ).add( pos.getX(), pos.getY(), pos.getZ() );
		
		if( randomFactor < 0.3F ) {
			level.addParticle( ParticleTypes.SMOKE, position.x, position.y, position.z, 0.0D, 0.0D, 0.0D );
			if( randomFactor < 0.17F ) {
				level.playLocalSound(
					position.x,
					position.y,
					position.z,
					SoundEvents.CANDLE_AMBIENT,
					SoundSource.BLOCKS,
					1.0F + randomSource.nextFloat(),
					randomSource.nextFloat() * 0.7F + 0.3F,
					false
				);
			}
		}
		
		level.addParticle( ParticleTypes.SMALL_FLAME, position.x, position.y, position.z, 0.0D, 0.0D, 0.0D );
	}
	
	private static double[][] createYturnMatrix( double degree ) {
		
		return new double[][] {
			{ cos( degree ), 0.0, sin( degree ) }, { 0.0, 1.0, 0.0 }, {
			-sin( degree ), 0.0, cos( degree )
		}
		};
	}
	
	private static double cos( double degree ) {
		
		degree = ( degree + ( degree < 0.0 ? 360 : 0 ) ) % 360.0;
		
		return switch( (int)degree ) {
			case 0 -> 1.0;
			case 90 -> 0.0;
			case 180 -> -1.0;
			case 270 -> 0.0;
			default -> 1.0;
		};
	}
	
	private static double sin( double degree ) {
		
		degree = ( degree + ( degree < 0.0 ? 360 : 0 ) ) % 360.0;
		
		return switch( (int)degree ) {
			case 0 -> 0.0;
			case 90 -> 1.0;
			case 180 -> 0.0;
			case 270 -> -1.0;
			default -> 1.0;
		};
	}
	
	@NotNull
	private static Vec3 turnVector( @NotNull Vec3 vector, double[][] turn_matrix ) {
		
		double vx = vector.x - 8.0;
		double vy = vector.y - 8.0;
		double vz = vector.z - 8.0;
		double x = vx * turn_matrix[0][0] + vy * turn_matrix[0][1] + vz * turn_matrix[0][2];
		double y = vx * turn_matrix[1][0] + vy * turn_matrix[1][1] + vz * turn_matrix[1][2];
		double z = vx * turn_matrix[2][0] + vy * turn_matrix[2][1] + vz * turn_matrix[2][2];
		x += 8.0;
		y += 8.0;
		z += 8.0;
		return new Vec3( x, y, z );
	}
}
