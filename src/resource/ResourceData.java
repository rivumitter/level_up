package resource;

import data.Student;

import java.util.*;

public class ResourceData {

    public static List<Integer> getNumList() {
        return List.of(1,2,5,6,7,2,6,7,9,10);
    }

    public static List<String> getStringList() {
        return List.of("tim","john","sara","rivu","tim","aron");
    }

    public static void printCollection(Collection<?> collection) {
        collection.forEach(c-> System.out.println("data is: "+c.toString()));
    }

    public static void printMap(Map<?,?> map) {
        map.forEach((k, v) -> System.out.println("key: "+k+" value: "+v.toString()));
    }


    public ArrayList<Employee> getEmployeeList() {

        ArrayList<Employee> tempEmpList = new ArrayList<>();

        tempEmpList.add(this.getSara());
        tempEmpList.add(this.getRivu());
        tempEmpList.add(this.getTim());
        tempEmpList.add(this.getRon());
        tempEmpList.add(this.getRik());

        return tempEmpList;
    }


    public Employee getSara() {
        return new Employee("Sara",22,12345,22000,"Testing");
    }

    public Employee getTim() {
        return new Employee("Tim",42,12143,56000,"Management");
    }

    public Employee getRivu() {
        return new Employee("Rivu",22,12561,122000,"Development");
    }

    public Employee getRon() {
        return new Employee("Ron",23,34511,28000,"Development");
    }

    public Employee getRik() {
        return new Employee("Ron",21,34014,18000,"Testing");
    }

    public Student getStudent1() {
        return new Student("student_1","maths",95);
    }

    public Student getStudent2() {
        return new Student("student_2","maths",85);
    }

    public Student getStudent3() {
        return new Student("student_3","physics",88);
    }

    public Student getStudent4() {
        return new Student("student_4","biology",79);
    }

    public Student getStudent5() {
        return new Student("student_5","maths",65);
    }


    public class Employee {
        String name;
        int age;
        int id;
        int salary;
        String dept;

        public Employee(String name, int age, int id, int salary, String dept) {
            this.name = name;
            this.age = age;
            this.id = id;
            this.salary = salary;
            this.dept = dept;
        }

        public String getDept() {
            return dept;
        }

        public void setDept(String dept) {
            this.dept = dept;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", id=" + id +
                    ", salary=" + salary +
                    '}';
        }
    }

}
