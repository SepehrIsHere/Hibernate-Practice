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
        Student student = new Student("1S",faker.name().firstName(), faker.name().lastName(),new Date(String.valueOf(faker.date().birthday())),"Computer Science",2020);
        Student student1 = new Student("2S",faker.name().firstName(), faker.name().lastName(),new Date(String.valueOf(faker.date().birthday())),"Computer Engineer",2018);
        Student student2 = new Student("3S",faker.name().firstName(), faker.name().lastName(),new Date(String.valueOf(faker.date().birthday())),"Data Science",2021);
        studentService.save(student);
        studentService.save(student1);
        studentService.save(student2);

        Teacher teacher = new Teacher("1T",faker.name().firstName(), faker.name().lastName(),new Date(String.valueOf(faker.date().birthday())) , "Master" , AcademicRank.PROFESSOR, 5000.0);
        Teacher teacher1 = new Teacher("2T",faker.name().firstName(), faker.name().lastName(),new Date(String.valueOf(faker.date().birthday())) , "Bachelor" , AcademicRank.ASSOCIATE, 2500.0);
        Teacher teacher2 = new Teacher("3T",faker.name().firstName(), faker.name().lastName(),new Date(String.valueOf(faker.date().birthday())) , "Master" , AcademicRank.ASSISTANT, 10000.0);
        teacherService.save(teacher);
        teacherService.save(teacher1);
        teacherService.save(teacher2);

        List<Teacher> teachers = teacherService.findAll();
        for (Teacher teacher3 : teachers){
            System.out.println(teacher3);
        }

        List<Student> students = studentService.findAll();
        for (Student student3 : students){
            System.out.println(student3);
        }


    }
}
