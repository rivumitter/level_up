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


        //only sorted order

        /*
        List<String> sortedName = resourceData.getEmployeeList()
                .stream()
                .sorted(Comparator.comparing(ResourceData.Employee::getName))
                //.sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                .map(ResourceData.Employee::getName).toList();


         */


        //print name in sorted order and unique
        TreeSet<String> sortedName = resourceData.getEmployeeList()
                .stream()
                .map(ResourceData.Employee::getName)
                .collect(Collectors.toCollection(TreeSet::new));


        printCollection(sortedName);

        // find Rivu name object

        ResourceData.Employee rivu = resourceData.getEmployeeList().stream()
                .filter(emp -> emp.getName()
                        .equals("Rivu")).findAny().orElseThrow(() -> new RuntimeException("No Element Found"));

        System.out.println("Rivu is->"+rivu);

    }
}
