package de.lv1871.dms.GameOfLife.domain;

import static de.lv1871.dms.GameOfLife.domain.Field.isLivingNeighbour;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Gameboard {

	public static List<Field> initRandomGame(int xSize, int ySize) {
		List<Field> game = new LinkedList<Field>();
		for (int i = 0; i < ySize; i++) {
			for (int e = 0; e < xSize; e++) {
				game.add(new Field(e, i, (new Random().nextInt(20) % 4 == 0)));
			}
		}

		return game;
	}

	public static Function<Field, List<Field>> livingNeighboursIn(List<Field> game) {
		// @formatter:off
		return (field) -> game
				.stream()
				.filter(isLivingNeighbour(field))
				.collect(Collectors.toList());
		// @formatter:on
	}

}
