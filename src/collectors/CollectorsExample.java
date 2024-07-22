package collectors;

import resource.ResourceData;

import java.util.*;
import java.util.stream.Collectors;

import static resource.ResourceData.*;

public class CollectorsExample {

    public static void main(String[] args) {

        ResourceData resourceData = new ResourceData();

        //group emp by their age
        Map<Integer, List<ResourceData.Employee>> empAgeMap = resourceData.getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(ResourceData.Employee::getAge));

        //printMap(empAgeMap);


        //total salary per dept

        Map<String, Integer> deptToSalMap = resourceData.getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(ResourceData.Employee::getDept, Collectors.summingInt(ResourceData.Employee::getSalary)));

        //printMap(deptToSalMap);

        //per dept max salary emp
        Map<String, Optional<ResourceData.Employee>> deptMaxSalEmp = resourceData.getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(ResourceData.Employee::getDept,
                        Collectors.maxBy((emp1, emp2) -> Math.max(emp1.getSalary(), emp2.getSalary()))));

        resourceData.getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(ResourceData.Employee::getDept,
                        Collectors.summingInt(ResourceData.Employee::getSalary)));

        //printMap(deptMaxSalEmp);


        //reverse sorted order

        List<String> sortedName = resourceData.getEmployeeList()
                .stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(ResourceData.Employee::getSalary)))
                //.sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                .map(ResourceData.Employee::getName).toList();


    //    System.out.println("highest salary names:" + sortedName);

        // if obj has same salary
        // grp them first then sort them in reverse
        ArrayList<ResourceData.Employee> employeeList = resourceData.getEmployeeList();

        employeeList.add(new ResourceData.Employee("Rima", 27, 31114, 56000, "Manager"));

        List<Map.Entry<Integer, List<String>>> groupedSortedSalary = employeeList.stream().collect(Collectors.groupingBy(Employee::getSalary,
                        Collectors.mapping(Employee::getName, Collectors.toList())))
                .entrySet()
                .stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .toList();

        System.out.println(groupedSortedSalary);


        // nth highest salary with above payload

        int n = 3;

        System.out.println(n+ "th highest salary : "+ getNthHighestSal(employeeList, n));





        //print name in sorted order and unique
//        TreeSet<String> sortedName = resourceData.getEmployeeList()
//                .stream()
//                .map(ResourceData.Employee::getName)
//                .collect(Collectors.toCollection(TreeSet::new));


       // printCollection(sortedName);

        // find Rivu name object

        ResourceData.Employee rivu = resourceData.getEmployeeList().stream()
                .filter(emp -> emp.getName()
                        .equals("Rivu")).findAny().orElseThrow(() -> new RuntimeException("No Element Found"));

     //   System.out.println("Rivu is->" + rivu);

    }

    private static Map.Entry<Integer, List<String>> getNthHighestSal(ArrayList<Employee> employeeList, int n) {

        return employeeList.stream().collect(Collectors.groupingBy(Employee::getSalary,
                        Collectors.mapping(Employee::getName, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .toList()
                .get(n - 1);
    }
}
