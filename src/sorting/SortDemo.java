package sorting;



import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortDemo {

    public static void main(String[] args) {

        List<Employee> employeeList = new java.util.ArrayList<>(List.of(
                new Employee("rivu", 1000),
                new Employee("arghya", 5000),
                new Employee("arghya", 2000),
                new Employee("antara", 4000),
                new Employee("rimpa", 3500)));

//        employeeList.sort((o1, o2) -> o2.salary() - o1.salary()); // sort actual list
//
//        System.out.println(employeeList);

//        Function<String, String> fn = String::toUpperCase;
//
//        String apply = fn.apply("Arghya");
//        System.out.println(apply);


        // sort based on name desc order

        List<Employee> employees = employeeList.stream().sorted((emp1, emp2) -> emp2.name().compareTo(emp1.name())).toList();

        String names = employees.stream().map(Employee::name).collect(Collectors.joining(","));
      //  System.out.println("names:" +names);

        // sort based on name desc order

     //   List<Employee> employees = employeeList.stream().sorted(Comparator.comparing(Employee::name)).toList();


      //  System.out.println("sorted: "+ employees);

        List<Employee> employeesNew = employeeList.stream()
                .sorted(Comparator.comparing(Employee::name)
                        .thenComparing(Employee::salary)).toList();

        System.out.println("sorted:"+ employeesNew);

        /*
        List<Employee> sortedEmployees = employeeList.stream()
                .sorted((o1, o2) -> o2.salary() - o1.salary())
                .toList();

        System.out.println(sortedEmployees);

         */

        Map<String, Integer> nameMap = Map.of("rmp2", 2000, "rmp1", 1000, "rmp3", 3500);

        LinkedHashMap<String, Integer> sortedMap = nameMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

       // System.out.println(sortedMap);


    }
}

