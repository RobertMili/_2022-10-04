package Imperative;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

public class StreamExamples {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> stringList = List.of("Apple", "Bapelsin", "Citrus", "Tomato", "Kiwi", "Grape");
        List<Cat> catList = List.of(
                new Cat("Misse", 10, true),
                new Cat("Pelle", 2, false),
                new Cat("Snow white", 15, true),
                new Cat("Bella", 5, true),
                new Cat("Luna", 2, true),
                new Cat("Leo", 1, false));

        int sum = integerList.stream()
                .mapToInt(i -> i)
                .filter(value -> value < 5)
                .sum();

        //System.out.println(sum);

        long count = integerList.stream()
                .mapToInt(i -> i)
                .filter(value -> isOdd(value))
                .count();
        //System.out.println(count);


        long catcount1 = catList.stream()
                .filter(Cat::isFemale)
                .count();
        System.out.println(catcount1);

        long maleCount = catList.stream()
                .filter(not(Cat::isFemale))
                .filter(cat -> cat.getAge() < 5)
                .count();
        System.out.println(catcount1);

        double average = catList.stream()
                .mapToInt(Cat::getAge)
                .average()
                .orElseThrow();
        System.out.println(average);

        //Sort according to number of characters in cat name
        var resual = catList.stream()
                .sorted(Comparator.comparingInt(Cat::getNameLength)
                        .thenComparing(Cat::getName))
                .toList();

        resual.forEach(System.out::println);

    }

    private static boolean isOdd(int value) {
        return value % 2 == 1;
    }

    private static boolean isLessThanFive(int value) {
        return value < 5;
    }
}

class Cat {
    private final String name;
    private final int age;
    private final boolean female;

    public Cat(String name, int age, boolean female) {
        this.name = name;
        this.age = age;
        this.female = female;
    }

    public String getName() {
        return name;
    }

    public int getNameLength() {
        return name.length();
    }

    public int getAge() {
        return age;
    }

    public boolean isFemale() {
        return female;
    }

    @Override
    public String toString() {
        return "Cat { " + name + " }";
    }
}
