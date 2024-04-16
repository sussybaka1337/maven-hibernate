package com.school.hibernate_student_management;

import java.util.List;

import com.school.hibernate_student_management.entities.Student;
import com.school.hibernate_student_management.services.StudentService;

public class App {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        // Xoá tất cả học sinh đã thêm vào lần chạy trước
        studentService.deleteStudents();

        // Thêm 2 học sinh mới vào CSDL
        Student studentABC = new Student("Nguyen Van ABC", "abcnv.23itb@school.udn.vn", "Quang Ngai", "23GITB", 4);
        studentService.createStudent(studentABC);
        Student studentDEF = new Student("Nguyen Van DEF", "defnv.23itb@school.udn.vn", "Quang Nam", "23GITB", 3);
        studentService.createStudent(studentDEF);

        // Lấy ra học sinh có email là abcnv.23itb@school.udn.vn
        System.out.println("\nStudent with email abcnv.23itb@school.udn.vn");
        Student student = studentService.getByEmail("abcnv.23itb@school.udn.vn");
        student.printEntity();

        // Cập nhật GPA học sinh có email là abcnv.23itb@school.udn.vn thành 3.5
        student.setGpa(3.5);
        studentService.updateStudent(student);

        // In ra lại kết quả
        System.out.println("\nChange GPA of student with email abcnv.23itb@school.udn.vn to 3.5");
        student.printEntity();

        // In danh sách học sinh
        System.out.println("\nAll students in database:");
        List<Student> students = studentService.getStudents();
        for (Student studentEach: students) {
            studentEach.printEntity();
        }
        
        // Xoá học sinh có email là defnv.23itb@school.udn.vn
        Student defStudent = studentService.getByEmail("defnv.23itb@school.udn.vn");
        studentService.deleteStudent(defStudent);

        // In danh sách học sinh ra lại để xem thay đổi
        System.out.println("\nAll students in database (defnv.23itb@school.udn.vn has been deleted):");
        List<Student> studentsWithoutDef = studentService.getStudents();
        for (Student studentEach: studentsWithoutDef) {
            studentEach.printEntity();
        }
    }
}
