package com.example.studentapi;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class StudentController {

    private final List<Student> students =
            new ArrayList<>();

    private final AtomicLong counter = new AtomicLong(0);

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {

        Student newStudent = new Student(
                counter.incrementAndGet(),
                student.name(),
                student.email()
        );

        students.add(newStudent);

        return newStudent;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }

    public record Student(Long id, String name, String email) {}
}
