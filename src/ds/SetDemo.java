package ds;

import data.Student;
import resource.ResourceData;
import java.util.*;
import resource.ResourceData.*;

import java.util.HashSet;

import static resource.ResourceData.*;

public class SetDemo {
    public static void main(String[] args) {
        ResourceData resourceData = new ResourceData();

        Set<Integer> integerSet = new HashSet<>();
        Set<Integer> integerSet2 = new HashSet<>(getNumList()); //1,2,5,6,7,2,6,7,9,10

        //add
        integerSet.add(1);
        integerSet.add(5);
        integerSet.add(4);
        integerSet.add(3);
        integerSet.add(5);

        System.out.println("integerSet->"+integerSet);

        //retainAll (intersection)
//        integerSet.retainAll(integerSet2);
//        System.out.println("integerSet->"+integerSet);

        // removeAll remove the intersection
       // integerSet.removeAll(integerSet2);
        //System.out.println("integerSet->"+integerSet);

        // if I need only odd element
//        integerSet.removeIf(i-> i%2==0);
//        System.out.println("integerSet->"+integerSet);

        // hashSet
        /*
        Set<Student> studentSet = new HashSet<>();

        addStudent(resourceData, studentSet);

        printCollection(studentSet);

         */

        // ordering maintain
        /*
        Set<Student> studentSet = new LinkedHashSet<>();
        addStudent(resourceData, studentSet);

        printCollection(studentSet);

        // contains
        boolean studentPresent = studentSet.contains(new Student("student_3", "physics", 88));

        System.out.println("studentPresent->"+studentPresent);

         */

        // sorted high to low marks
        /*
        Set<Student> studentSet = new TreeSet<>((o1, o2) -> o2.getMarks() - o1.getMarks()); // if the Student class doent implement comparable it will throw ClassCastException

        addStudent(resourceData, studentSet);

        printCollection(studentSet);

         */

        // navigable set extends TresSet

        NavigableSet<Integer> integerSetNew = new TreeSet<>(getNumList());  //1,2,5,6,7,2,6,7,9,10

        // floor <=
        System.out.println("floor->"+integerSetNew.floor(8));

        // ceiling <=
        System.out.println("ceil->"+integerSetNew.ceiling(9));

        // higher > .. lower < ( strict bound )
        System.out.println("higher->"+integerSetNew.higher(9));


    }

    private static void addStudent(ResourceData resourceData, Set<Student> studentSet) {
        studentSet.add(resourceData.getStudent1());
        studentSet.add(resourceData.getStudent2());
        studentSet.add(resourceData.getStudent3());
        studentSet.add(resourceData.getStudent4());
        studentSet.add(resourceData.getStudent5());
    }
}
