package com.example.web.services.soap;

import com.example.services.ejbs.Accounts;
import com.example.services.ejbs.Phones;
import com.example.services.ejbs.Students;
import com.example.services.entities.Account;
import com.example.services.entities.Phone;
import com.example.services.entities.Student;

import javax.ejb.EJB;
import java.util.List;

@javax.jws.WebService
public class Operation implements OperationInterface {

    @EJB
    private Students students;
    @EJB
    private Phones phones;
    @EJB
    private Accounts accounts;

    @Override
    public String getHello(String name) {
        return "Hello " + name + " !";
    }

    @Override
    public void createStudent(Student student) {
        students.add(student);
    }

    @Override
    public String deleteStudent(int id) {
        if(students.delete(id)) {
            return "Student successfully deleted";
        } else {
            return "Can't access student with id: " + id;
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return students.getAll();
    }

    @Override
    public List<Student> gradeOnDemand(double grade) {
        return students.getGrade(grade);
    }

    @Override
    public List<Phone> getStudentPhone(int id) {
        return phones.getPhone(id);
    }

    @Override
    public List<Phone> getAllPhones() {
        return phones.getPhones();
    }

    @Override
    public Phone addStudentPhone(Phone phone) {
        return phones.addPhone(phone);
    }

    @Override
    public List<Account> findAccount(int id) {
        return accounts.get(id);
    }
}
