package se.hkr;

import java.util.List;
import java.util.Map;

// 1) Have a list of items, some of which are integers and some are strings.
// 2) Strings are numbers, look up in map.
// 3) Sum the numbers

public class First {
    public static void main(String[] args) {
        int sum = 0;
        var validNumbers = Map.of(
                "One", 1,
                "Two", 2,
                "Three", 3);

        var items = List.of("One", 4, "Two", 5, "Three", 1);

        for (var item : items) {
            sum += switch (item) {
                case String s -> validNumbers.get(s);
                case Integer i -> i;
                default -> 0;
            };
        }

        System.out.println(sum);    // Should print 16
    }
}