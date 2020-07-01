import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreamExercise {
    public static void main(String[] args) {
        /*
        * Source -> Filter/Sort/Map -> Collect/Reduce
        *
        * Stream Source <- Collection, list, array, file, set, int, long...
        *
        * Intermediate operations: Filter, map, sort (returns stream)
        * Terminal operations: forEach, collect, reduce, count, max-min (void/returns non-stream)
        *
        * */

        IntStream
                .range(1, 10)
                .forEach(System.out::print);
        System.out.println();
        //123456789

        IntStream
                .range(1,10)
                .skip(5)
                .forEach(System.out::print);
        System.out.println();
        //6789

        System.out.println(
                IntStream
                .range(1,5)
                .sum()
        );
        System.out.println();
        //10

        Stream.of("Java", "Python", "Scala")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
        System.out.println();
        //Java

        String[] names = {"Java", "Python", "Scala", "Javascript", "Pascal", "R", "C++"};
        Arrays.stream(names) //same as stream.of
                .filter(x -> x.startsWith("P"))
                .sorted()
                .forEach(System.out::println);
        System.out.println();
        //Pascal Python

        Arrays.stream(new int[] {2, 4, 6, 8, 10})
                .map(x -> x*x)
                .average()
                .ifPresent(System.out::println);
        System.out.println();
        //44.0

        List<String> people = Arrays.asList("Java", "Python", "Scala", "Javascript", "Pascal", "R", "C++");
        people
                .stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("s"))
                .forEach(System.out::println);
        System.out.println();
        //scala

        try {
            Stream<String> rows = Files.lines(Paths.get("deneme.csv"));
            int rowCount = (int) rows
                    .map(x -> x.split(","))
                    .filter(x -> x.length == 5)
                    .count();
            System.out.println(rowCount + " rows.");
            System.out.println();
            //5 rows

            rows.close();
        } catch (IOException err){
            System.out.println(err);
        }

        try {
            Stream<String> rows2 = Files.lines(Paths.get("deneme.csv"));
            rows2
                    .map(x -> x.split(","))
                    .filter(x -> x.length == 5)
                    .filter(x -> Integer.parseInt(x[1]) < 5)
                    .forEach(x -> System.out.println((x[0] + "  " + x[1] + "  " + x[2])));
                    System.out.println();
            /*
            *
            A  1  2
            C  3  4
            D  2  3
            * */
            rows2.close();
        } catch (IOException err){
            System.out.println(err);
        }

        try {
            Stream<String> rows3 = Files.lines(Paths.get("deneme.csv"));
            Map<String, Integer> map = new HashMap<>();
            map = rows3
                    .map(x -> x.split(","))
                    .filter(x -> x.length == 5)
                    .filter(x -> Integer.parseInt(x[1]) > 5)
                    .collect(Collectors.toMap(
                        x -> x[0],
                           x -> Integer.parseInt(x[1])
                    ));
            rows3.close();
            for(String key : map.keySet()) {
               System.out.println(key + "  " + map.get(key));
            }
            System.out.println();
        } catch (IOException err){
            System.out.println(err);
        }
        /* B  7
        * E  9
        */

        double total = Stream.of(7.3, 1.5, 4.8)
                .reduce(0.0, (Double a, Double b) -> a + b); //initial point and a combiner
        System.out.println("Total = " + total);
        System.out.println();
        /*Total = 13.600000000000001*/

        IntSummaryStatistics summary = IntStream.of(7,2,19,88,73,4,10)
                .summaryStatistics();
        System.out.println(summary);
        System.out.println();
        /*
        * IntSummaryStatistics{count=7, sum=203, min=2, average=29,000000, max=88}
        */
    }
}
