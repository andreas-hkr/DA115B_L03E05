package se.hkr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// 1) Have a list of items, some of which are integers and some are strings.
// 2) Strings are numbers, look up in map.
// 3) Sum the numbers

// 4) Handle invalid items (not in map, not integer) by skipping them (Hello, 3.14)
// 5) Add invalid items to a list and print them out separately
// 6) Add support for doubles

public class Second {
    public static void main(String[] args) {
        double sum = 0;
        var validNumbers = Map.of(
                "One", 1,
                "Two", 2,
                "Three", 3);

        var items = List.of("One", 4, "Two", 5, "Three", 1, "Hello", 3.14);

        ArrayList<Object> invalidItems = new ArrayList<>();
        for (var item : items) {
            sum += switch (item) {
                case String s when validNumbers.containsKey(s)-> validNumbers.get(s);
                case Integer i -> i;
                case Double d -> d;
                default -> {
                    invalidItems.add(item);
                    yield 0;
                }
            };
        }

        System.out.println(STR."The sum is: \{sum}");
        System.out.println(STR."Here are the invalid items: \{invalidItems}");
    }
}