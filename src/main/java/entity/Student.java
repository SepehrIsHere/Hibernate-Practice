package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Student extends Person {
    public static final String TABLE_NAME = "student";
    public static final String MAJOR = "major";
    public static final String ENTER_YEAR = "enter_year";
    public static final String STUDENT_ID = "student_id";

    @Column(name = STUDENT_ID)
    private String studentId;

    @Column(name = MAJOR)
    private String major;

    @Column(name = ENTER_YEAR)
    private int enterYear;

    public Student(String studentId,String firstName, String lastName, Date birthDate, String major, int enterYear) {
        super(firstName, lastName, birthDate);
        this.studentId = studentId;
        this.major = major;
        this.enterYear = enterYear;
    }
}
