package de.lv1871.dms.GameOfLife;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import de.lv1871.dms.GameOfLife.domain.Field;

public class LambdaExpressionStep5 {

	private static Field FIELD00 = new Field(0, 0, false);
	private static Field FIELD01 = new Field(0, 1, true);
	private static Field FIELD02 = new Field(0, 2, true);
	private static Field FIELD11 = new Field(1, 1, true);
	private static Field FIELD10 = new Field(1, 0, false);
	private static List<Field> GAME = Arrays.asList(FIELD00, FIELD01, FIELD02, FIELD11, FIELD10);

	// Implementiert folgenden Test. Hoffe die Begriffe machen den Kontext klar.
	// In Ermangelung der nicht unbegrenzt verfügbaren Ressource "Lust" müssen
	// alle weiteren für das Game Of Life notwendigen Funktionalitäten ganz ohne
	// Hilfestellung implementiert werden. Viel Glück.

	@Test
	public void testGetNeighboursInGame() {
		// List<Field> result =
		// Optional.of(FIELD00).map(livingNeighboursIn(GAME)).get();
		//
		// assertEquals(2, result.size());
	}

	// public static Function<Field, List<Field>> livingNeighboursIn(List<Field>
	// game) {
//		// @formatter:off
//		return (field) -> game
//				.stream()
//				.filter(isLivingNeighbour(field))
//				.collect(Collectors.toList());
//		// @formatter:on
	// }

}
