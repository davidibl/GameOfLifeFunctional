package de.lv1871.dms.GameOfLife;

import static org.junit.Assert.assertEquals;

import java.util.Objects;
import java.util.function.Predicate;

import org.junit.Test;

public class LambdaExpressionStep2 extends LambdaExpressionRefactoringBase {

	@Test
	public void testLambdaFilterWithEqual() {
		// @formatter:off
		String result = BEGRIFF_LISTE
				.stream()
				.filter(equal(FILTER_VALUE))
				.findFirst()
				.get();
		// @formatter::on
		
		assertEquals(FILTER_VALUE, result);
	}
	
	private static <T> Predicate<T> equal(T filter) {
		return (value) -> Objects.equals(value, filter);
	}
	
}
