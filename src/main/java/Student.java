import java.util.*;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public void addGrades(int... newGrades) {
        for (int grade : newGrades) {
            grades.add(grade);
        }
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    @Override
    public String toString() {
        return String.format("Студент: %s, группа: %s, курс: %d, средний балл: %.2f",
                name, group, course, getAverageGrade());
    }
}

class StudentManager {
    public void removePoorStudents(Collection<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3) {
                iterator.remove();
            }
        }
    }

    public void promoteStudents(Collection<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                int currentCourse = student.getCourse();
                student.setCourse(currentCourse + 1);
            }
        }
    }

    public void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты " + course + " курса:");
        boolean found = false;
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("- " + student.getName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Студентов на " + course + " курсе нет");
        }
    }

    public void printAllStudents(Collection<Student> students) {
        System.out.println("\nВСЕ СТУДЕНТЫ: ");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Set<Student> students = new HashSet<>();

        Student petrova = new Student("Петрова", "Б1", 3);
        petrova.addGrades(4, 4, 5, 5, 5);
        students.add(petrova);

        Student ivanov = new Student("Иванов", "Б1", 2);
        ivanov.addGrades(2, 3, 3, 2, 2);
        students.add(ivanov);

        Student sidorov = new Student("Сидоров", "Б1", 1);
        sidorov.addGrades(3, 4, 4, 5, 3);
        students.add(sidorov);

        Student kozlov = new Student("Козлов", "Б2", 2);
        kozlov.addGrades(2, 2, 2, 3, 2);
        students.add(kozlov);

        System.out.println("НАЧАЛЬНОЕ СОСТОЯНИЕ:");
        manager.printAllStudents(students);

        System.out.println("\nТест printStudents:");
        manager.printStudents(students, 2);
        manager.printStudents(students, 3);
        manager.printStudents(students, 1);

        System.out.println("\nУдаление неуспевающих (средний балл < 3):");
        manager.removePoorStudents(students);
        manager.printAllStudents(students);

        System.out.println("\nПеревод успевающих на следующий курс:");
        manager.promoteStudents(students);
        manager.printAllStudents(students);

        System.out.println("\nИтоговая проверка по курсам:");
        manager.printStudents(students, 2);
        manager.printStudents(students, 3);
        manager.printStudents(students, 4);
    }
}