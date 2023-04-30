package ru.intensive.week03;

import lombok.*;
import ru.intensive.week02.dz02.Cat;

import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class LombokExample {

    private String description;
    private int counter;
    private List<Cat> cats;

    public static void main(String[] args) {
        LombokExample lombokExample01 = new LombokExample();
        lombokExample01.cats = List.of(new Cat(), new Cat());
        lombokExample01.counter = 2;
        lombokExample01.description = "Test01";

        LombokExample lombokExample02 = new LombokExample("Test02", 1, List.of());
        LombokExample lombokExample03 = new LombokExample("Test02", 1, List.of());

        System.out.println("Equal: " + lombokExample01.equals(lombokExample02)); //false
        System.out.println("Equal: " + Objects.equals(lombokExample02, lombokExample03)); //true
    }



    public static class WithoutLombok {

        private String description;
        private int counter;
        private List<Cat> cats;

        public WithoutLombok() {
        }

        public WithoutLombok(String description, int counter, List<Cat> cats) {
            this.description = description;
            this.counter = counter;
            this.cats = cats;
        }

        @Override
        public String toString() {
            return "WithoutLombok{" +
                    "description='" + description + '\'' +
                    ", counter=" + counter +
                    ", cats=" + cats +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            WithoutLombok that = (WithoutLombok) o;
            return counter == that.counter && Objects.equals(description, that.description) && Objects.equals(cats, that.cats);
        }

        @Override
        public int hashCode() {
            return Objects.hash(description, counter, cats);
        }

        public static void main(String[] args) {
            WithoutLombok withoutLombok01 = new WithoutLombok();
            WithoutLombok withoutLombok02 = new WithoutLombok("Test01", 1, List.of());
            WithoutLombok withoutLombok03 = new WithoutLombok("Test01", 1, List.of());

            System.out.println("Equal: " + withoutLombok02.equals(withoutLombok03)); //true
        }
    }
}