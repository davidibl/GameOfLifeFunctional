package de.lv1871.dms.GameOfLife;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LambdaExpressionStep1 extends LambdaExpressionRefactoringBase {

	@Test
	public void testLambdaFilter() {
		// @formatter:off
		String result = BEGRIFF_LISTE
				.stream()
				.filter(value -> value.equals(FILTER_VALUE))
				.findFirst()
				.get();
		// @formatter:on

		assertEquals(result, FILTER_VALUE);
	}

}
