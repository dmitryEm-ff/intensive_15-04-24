package ru.intensive.week09.task02;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CustomCollector implements Collector<String, StringBuilder, String> {

    public static CustomCollector toCustomCollector() {
        return new CustomCollector();
    }

    @Override
    public Supplier<StringBuilder> supplier() {
        return StringBuilder::new;
    }

    @Override
    public BiConsumer<StringBuilder, String> accumulator() {
        return (builder, city) -> {
            if (city.length() <= 10) {
                builder.setLength(0);
                builder.append(city);
            }
        };
    }

    @Override
    public BinaryOperator<StringBuilder> combiner() {
        return (builder1, builder2) -> {
            if (builder1.length() < builder2.length()) {
                return builder1;
            } else {
                return builder2;
            }
        };
    }

    @Override
    public Function<StringBuilder, String> finisher() {
        return (builder) -> {
            if (builder.length() == 0) {
                return "null";
            } else {
                return builder.toString();
            }
        };    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}
