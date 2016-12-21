package de.lv1871.dms.GameOfLife;

import java.util.Arrays;
import java.util.List;

public class LambdaExpressionRefactoringBase {

	public static String ZEBRA = "Zebra";
	public static String APFEL = "Apfel";
	public static String BIRNE = "Birne";
	public static String DOJO = "Dojo";
	public static String WEIHNACHTEN = "Weihnachten";

	public static List<String> BEGRIFF_LISTE = Arrays.asList(ZEBRA, APFEL, BIRNE, DOJO, WEIHNACHTEN);
	public static List<Begriff> BEGRIFF_OBJEKT_LISTE = Arrays.asList(new Begriff(ZEBRA), new Begriff(APFEL),
			new Begriff(BIRNE), new Begriff(DOJO), new Begriff(WEIHNACHTEN));

	public static String FILTER_VALUE = WEIHNACHTEN;

}
