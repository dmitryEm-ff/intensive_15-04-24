package ru.intensive.week05;

import ru.intensive.week02.dz02.Cat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OutOfMemoryExample {
    public static void main(String[] args) throws InterruptedException {
        List<Object> list = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<BigDecimal> decimals = new ArrayList<>();
        Random random = new Random();
        int count = 0;
        while (true) {
            list.add(new Object());
            strings.add("String " + count);
            cats.add(new Cat());
            decimals.add(new BigDecimal(random.nextInt(1000)).multiply(new BigDecimal(count)));
            count++;
            if (count % 1000 == 0) {
                System.out.println("Created " + count + " objects.");
            }
            Thread.sleep(1);
        }
    }
}
// -Xmx128m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Tools/OOME.hprof