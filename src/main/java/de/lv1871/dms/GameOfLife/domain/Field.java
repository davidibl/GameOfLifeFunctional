package de.lv1871.dms.GameOfLife.domain;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class Field {

	private final int x;
	private final int y;
	private final boolean alive;

	public Field(int x, int y, boolean alive) {
		this.x = x;
		this.y = y;
		this.alive = alive;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

	public boolean getAlive() {
		return alive;
	}

	public static Predicate<Field> isAlive() {
		return Field::getAlive;
	}

	public static Predicate<Field> isDead() {
		return isAlive().negate();
	}

	public static Function<Field, Field> toDeadField(Predicate<Field> isFieldKillable) {
		// @formatter:off
		return (field) -> Optional
							.of(field)
							.filter(isFieldKillable.negate())
							.orElse(newDeadField(field));
		// @formatter:on
	}

	public static Function<Field, Field> toAliveField(Predicate<Field> isFieldViable) {
		// @formatter:off
		return (field) -> Optional
							.of(field)
							.filter(isFieldViable.negate())
							.orElse(newAliveField(field));
		// @formatter:on
	}

	public static Field newAliveField(Field field) {
		return new Field(field.getX(), field.getY(), true);
	}

	public static Field newDeadField(Field field) {
		return new Field(field.getX(), field.getY(), false);
	}

	public static Predicate<Field> isLivingNeighbour(Field original) {
		// @formatter:off
		return (field) -> (Math.abs(original.getX() - field.getX()) < 2)
				&& (Math.abs(original.getY() - field.getY()) < 2)
				&& !field.equals(original) && isAlive().test(field);
		// @formatter:on
	}

	public static Function<Field, String> mapToSign() {
		return (field) -> (isAlive().test(field)) ? "#" : "-";
	}

}
