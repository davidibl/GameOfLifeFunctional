package de.lv1871.dms.GameOfLife;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import org.junit.Test;

public class AppTest {

    private static String ZEBRA = "Zebra";
    private static String APFEL = "Apfel";
    private static String BIRNE = "Birne";
    private static String DOJO = "Dojo";
    private static String WEIHNACHTEN = "Weihnachten";

    @Test
    private void testEqual() {
	List<String> liste = Arrays.asList(ZEBRA, APFEL, BIRNE, DOJO, WEIHNACHTEN);
	String filter = ZEBRA;

	String result = liste.stream().filter(value -> value.equals(filter)).findFirst().get();

	result = liste.stream().filter(equal(filter)).findFirst().get();

	assertEquals(ZEBRA, result);
    }

    private static <T> Predicate<T> equal(T filter) {
	return (value) -> Objects.equals(value, filter);
    }
}
