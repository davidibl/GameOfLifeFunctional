package de.lv1871.dms.GameOfLife.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaPredicateExtension {

    public static Predicate<Field> which(Predicate<Field> firstPredicate,
	    Function<List<Predicate<Field>>, Optional<Predicate<Field>>> combiner, Predicate<Field> secondPredicate) {
	return combiner.apply(Arrays.asList(firstPredicate, secondPredicate)).get();
    }

    public static BinaryOperator<Predicate<Field>> combinePredicateWithAnd() {
	return (predicate, otherPredicate) -> predicate.and(otherPredicate);
    }

    public static BinaryOperator<Predicate<Field>> combinePredicateWithOr() {
	return (predicate, otherPredicate) -> predicate.or(otherPredicate);
    }

    public static Function<List<Predicate<Field>>, Optional<Predicate<Field>>> and() {
	return (predicate) -> predicate.stream().reduce(combinePredicateWithAnd());
    }

    public static Function<List<Predicate<Field>>, Optional<Predicate<Field>>> or() {
	return (predicate) -> predicate.stream().reduce(combinePredicateWithOr());
    }

}
