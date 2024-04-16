package com.school.hibernate_student_management.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.school.hibernate_student_management.entities.Student;
import com.school.hibernate_student_management.utilities.HibernateUtil;

public class StudentService {
    public Student getById(Integer entityId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, entityId);
        session.getTransaction().commit();
        session.close();
        return student;
    }
    public Student getByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        NativeQuery<Student> nativeQuery = session.createNativeQuery("SELECT * FROM students WHERE email = :email", Student.class);
        nativeQuery.setParameter("email", email);
        Student student = nativeQuery.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return student;
    }
    public void createStudent(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(student);
        session.getTransaction().commit();
        session.close();
    }
    public Integer deleteStudent(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(student);
        session.getTransaction().commit();
        session.close();
        return student.getId();
    }
    public void updateStudent(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(student);
        session.getTransaction().commit();
        session.close();
    }
    public List<Student> getStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Student> students = session.createNativeQuery("SELECT * FROM students", Student.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return students;
    }
    public void deleteStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.createNativeQuery("DELETE FROM students", Student.class).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
