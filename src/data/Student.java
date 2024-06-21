package data;

import java.util.Objects;

public class Student {

    String name;
    String subject;
    int marks;

    ClassRoom classRoom;

    public Student(String name, String subject, int marks) {
        this.name = name;
        this.subject = subject;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return marks == student.marks && Objects.equals(name, student.name) && Objects.equals(subject, student.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subject, marks);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", marks=" + marks +
                '}';
    }
}
