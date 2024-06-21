package math;

import resource.ResourceData;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static resource.ResourceData.*;

public class MathOp {
    public static void main(String[] args) {
        ResourceData resourceData = new ResourceData();

        // get duplicate element
        Set<Integer> duplicateIntList = getNumList()
                .stream()
                .filter(num -> Collections.frequency(getNumList(),num) > 1)
                .collect(Collectors.toSet());

        //printCollection(duplicateIntList);

        //another method

        Set<Integer> duplicateIntList1 = getNumList().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(num -> num.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

       // printCollection(duplicateIntList1);

        Thread thread = new Thread(()-> System.out.println("test"));

        //sum of all numbers

        long sum = getNumList().stream()
                .collect(Collectors.summarizingInt(i -> i)).getSum();

        System.out.println("sum is->"+sum);

        int sum1 = getNumList().stream().mapToInt(i -> i).sum();

        System.out.println("sum is :"+sum1);

        //or
//        Integer sum1 = getNumList().stream().reduce(Integer::sum).orElse(0);
//        System.out.println("sum1 is->"+sum1);

        String p = """
                Arghya""";


        // avg of all
        double avg = getNumList().stream()
                .mapToInt(i->i).average().orElse(0.0);

        System.out.println("avg is->"+avg);

        //square -> filter i >100 -> avg

        double calAvg = getNumList().stream()
                .map(num -> num * num)
                .filter(num -> num > 10)
                .mapToInt(i -> i).average().orElse(0.0);

        System.out.println("new avg is->"+calAvg);

        //sort desc
        /*
        List<Integer> descList = getNumList().stream().sorted((o1, o2) -> o2 - o1).toList();

        System.out.println("desc list->"+descList);

         */

        // first 5 num-> get sum of them
        int firstFiveSum = getNumList().stream().limit(5).mapToInt(i -> i).sum();
        System.out.println("firstFiveSum->"+firstFiveSum);

        //get second highest

        Integer secondHighest = getNumList().stream().sorted(Collections.reverseOrder()).distinct().skip(1).findFirst().orElse(-1);
        System.out.println("secondHighest->"+secondHighest);




    }
}
