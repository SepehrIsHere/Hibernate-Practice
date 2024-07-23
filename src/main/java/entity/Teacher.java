package entity;

import entity.enumeration.AcademicRank;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = Teacher.TABLE_NAME)
public class Teacher extends Person {
    public static final String TABLE_NAME = "teacher";
    public static final String TEACHER_ID = "teacher_id";
    public static final String DEGREE = "degree";
    public static final String MONTHLY_SALARY = "monthly_salary";

    @Column(name = TEACHER_ID)
    private String teacherId;

    @Column(name = DEGREE)
    private String degree;

    @Enumerated(EnumType.STRING)
    private AcademicRank academicRank;

    @Column(name = MONTHLY_SALARY)
    private double monthSalary;
}
