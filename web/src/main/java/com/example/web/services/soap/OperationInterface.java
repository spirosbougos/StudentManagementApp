package com.example.web.services.soap;

import com.example.services.entities.Account;
import com.example.services.entities.Phone;
import com.example.services.entities.Student;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface OperationInterface {

    @WebMethod
    String getHello(String name);

    @WebMethod
    void createStudent(Student student);

    @WebMethod
    String deleteStudent(int id);

    @WebMethod
    List<Student> getAllStudents();

    @WebMethod
    List<Student> gradeOnDemand(double grade);

    @WebMethod
    List<Phone> getStudentPhone(int id);

    @WebMethod
    List<Phone> getAllPhones();

    @WebMethod
    Phone addStudentPhone(Phone phone);

    @WebMethod
    List<Account> findAccount(int id);
}
