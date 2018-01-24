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
		return (field) -> field.getAlive();
	}

	public static Predicate<Field> isDead() {
		return isAlive().negate();
	}

	public static Function<Field, Field> toDeadField(Predicate<Field> isFieldKillable) {
		return (field) -> Optional.of(field).filter(isFieldKillable.negate()).orElse(returnDeadField(field));
	}

	public static Function<Field, Field> toAliveField(Predicate<Field> isFieldKillable) {
		return (field) -> Optional.of(field).filter(isFieldKillable.negate()).orElse(returnAliveField(field));
	}

	public static Field returnAliveField(Field field) {
		return new Field(field.getX(), field.getY(), true);
	}

	public static Field returnDeadField(Field field) {
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
