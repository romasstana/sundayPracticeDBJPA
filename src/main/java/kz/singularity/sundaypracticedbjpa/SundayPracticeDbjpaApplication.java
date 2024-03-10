package kz.singularity.sundaypracticedbjpa;

import kz.singularity.sundaypracticedbjpa.entity.School;
import kz.singularity.sundaypracticedbjpa.entity.Student;
import kz.singularity.sundaypracticedbjpa.repository.SchoolRepository;
import kz.singularity.sundaypracticedbjpa.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SundayPracticeDbjpaApplication implements CommandLineRunner {
    private final SchoolRepository schoolRepository;
    private final StudentRepository studentRepository;
    public static void main(String[] args) {
        SpringApplication.run(SundayPracticeDbjpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        School school = new School(1L, "RPhMs", 900);
        School school1 = new School(2L, "NIS", 500);
        School school2 = new School(3L, "KTL", 200);
        List<School> schoolList = new ArrayList<>();
        schoolList.add(school);
        schoolList.add(school1);
        schoolList.add(school2);
        schoolRepository.saveAll(schoolList);

        Student student = new Student(1L, "Ramazan", "Roma", "ramazan@gmail.com", 23, 99);
        Student student1 = new Student(2L, "Beibarys", "Bob", "beibarys@gmail.com", 28, 97);
        Student student2 = new Student(3L, "Adi", "Kek", "adikek@gmail.com", 20, 100);
        Student student3 = new Student(4L, "Talgat", "Lol", "Talych@gmail.com", 20, 100);
        studentRepository.save(student);
        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        List<Student> studentList = studentRepository.findStudentsByFirstName("Ramazan");
        System.out.println("First method findStudentsByName result " + studentList.toString());

        List<Student> studentList1 = studentRepository.findStudentsByAge(20);
        System.out.println("Second method findStudentsByAge result " + studentList1.toString());

        School school3 = schoolRepository.findSchoolByName("KTL");
        System.out.println("Third method findSchoolByName " + school3);

        int numberOfStudents = schoolRepository.getNumberOfStudentsById(3L);
        System.out.println("Fourth method getNumberOfStudentsBySchoolId " + numberOfStudents);
    }
}
