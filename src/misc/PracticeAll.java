package misc;

import sorting.Employee;

import javax.sound.sampled.EnumControl;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PracticeAll {

    public static void main(String[] args) {


        List<String> strList = List.of("arghya", "rivu", "arunima", "arka", "buban");

        // count of string starts with ar

        Long count = strList.stream().filter(str -> str.startsWith("ar")).count();

     //   System.out.println(count);

        // remove duplicates

        List<Integer> intList = List.of(1, 2, 3, 3, 4, 5);

        List<Integer> integerList = intList.stream().distinct().toList();

    //    System.out.println(integerList);

        // check if list has even value

        List<Integer> isEvenList = List.of(1, 2, 3, 3);


        boolean isEven = isEvenList.stream().allMatch(num -> num % 2 == 0);

     //   System.out.println(isEven);

        // freq of each word in a string

        String str = "Java is a language and Java is great";

        Map<String, Long> freqMap = Arrays.stream(str.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

      //  System.out.println(freqMap);

        // give all num if num starts with 1

        List<Integer> numList = List.of(11, 12, 33, 145);

        List<Integer> oneList = numList.stream().filter(num -> {
            int temp = 0;
            while (num > 0) {
                temp = num % 10;
                num = num / 10;
            }
            return temp == 1;
        }).toList();

      //  System.out.println(oneList);

        // given a name list grp them with their first letter and count num of names

        List<String> nameList = List.of("Alice", "Bob", "Charlie", "Ammy", "Bill", "Anna");

        Map<Character, Long> letterMap = nameList.stream().collect(Collectors.groupingBy(name -> name.charAt(0), Collectors.counting()));

       // System.out.println(letterMap);


        // merge two sorted array
        int[] arr1 = {1,4,5};
        int[] arr2 = {2,6,3};

        Object[] mergedArray = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).boxed().sorted().toArray(); // for primitive

      //  System.out.println(Arrays.toString(mergedArray));

        // concat two list of strings and remove duplicate

        List<String> name1 = List.of("arghya", "rivu", "rivu");
        List<String> name2 = List.of("rima", "rima", "rik");

        List<String> disList = Stream.concat(name1.stream(), name2.stream()).distinct().toList();

      //  System.out.println(disList);

        String strTemp = "arghya";

        Map<String, Long> strMap = Arrays.stream(strTemp.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(strMap);



    }
}
