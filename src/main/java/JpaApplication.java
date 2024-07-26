import com.github.javafaker.Faker;
import entity.Student;
import entity.Teacher;
import entity.enumeration.AcademicRank;
import service.StudentService;
import service.TeacherService;
import util.ApplicationContext;

import java.util.Date;
import java.util.List;

public class JpaApplication {
    public static void main(String[] args) {
        ApplicationContext context = ApplicationContext.getInstance();

        StudentService studentService = new StudentService(context.getStudentRepository());
        TeacherService teacherService = new TeacherService(context.getTeacherRepository());

        Faker faker = new Faker();

        // Create and Save Students
        System.out.println("Creating and saving students...");
        Student student = new Student("1S", faker.name().firstName(), faker.name().lastName(), new Date(), "Computer Science", 2020);
        Student student1 = new Student("2S", faker.name().firstName(), faker.name().lastName(), new Date(), "Computer Engineering", 2018);
        Student student2 = new Student("3S", faker.name().firstName(), faker.name().lastName(), new Date(), "Data Science", 2021);
        studentService.save(student);
        studentService.save(student1);
        studentService.save(student2);

        // Create and Save Teachers
        System.out.println("Creating and saving teachers...");
        Teacher teacher = new Teacher("1T", faker.name().firstName(), faker.name().lastName(), new Date(), "Master", AcademicRank.PROFESSOR, 5000.0);
        Teacher teacher1 = new Teacher("2T", faker.name().firstName(), faker.name().lastName(), new Date(), "Bachelor", AcademicRank.ASSOCIATE, 2500.0);
        Teacher teacher2 = new Teacher("3T", faker.name().firstName(), faker.name().lastName(), new Date(), "Master", AcademicRank.ASSISTANT, 10000.0);
        teacherService.save(teacher);
        teacherService.save(teacher1);
        teacherService.save(teacher2);

        // Find and Print All Students
        System.out.println("Finding all students...");
        List<Student> students = studentService.findAll();
        for (Student student3 : students) {
            System.out.println(student3);
        }

        // Find and Print All Teachers
        System.out.println("Finding all teachers...");
        List<Teacher> teachers = teacherService.findAll();
        for (Teacher teacher3 : teachers) {
            System.out.println(teacher3);
        }

        // Find and Print a Specific Student
        System.out.println("Finding a specific student...");
        Student foundStudent = studentService.findById(student.getId());
        System.out.println("Found student: " + foundStudent);

        // Update a Student
        System.out.println("Updating a student...");
        foundStudent.setMajor("Updated Major");
        studentService.update(foundStudent);
        Student updatedStudent = studentService.findById(foundStudent.getId());
        System.out.println("Updated student: " + updatedStudent);

        // Delete a Student
        System.out.println("Deleting a student...");
        studentService.delete(foundStudent);
        List<Student> studentsAfterDeletion = studentService.findAll();
        System.out.println("Students after deletion: " + studentsAfterDeletion);

        // Find and Print a Specific Teacher
        System.out.println("Finding a specific teacher...");
        Teacher foundTeacher = teacherService.findById(teacher.getId());
        System.out.println("Found teacher: " + foundTeacher);

        // Update a Teacher
        System.out.println("Updating a teacher...");
        foundTeacher.setMonthSalary(7000.0);
        teacherService.update(foundTeacher);
        Teacher updatedTeacher = teacherService.findById(foundTeacher.getId());
        System.out.println("Updated teacher: " + updatedTeacher);

        // Delete a Teacher
        System.out.println("Deleting a teacher...");
        teacherService.delete(foundTeacher);
        List<Teacher> teachersAfterDeletion = teacherService.findAll();
        System.out.println("Teachers after deletion: " + teachersAfterDeletion);
    }
}
