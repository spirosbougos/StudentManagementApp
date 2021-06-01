package com.example.services.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Students")
@NamedQueries({
        @NamedQuery(
                name = "STUDENTS.ALL",
                query = "select s from Student s"
        ),
        @NamedQuery(
                name = "STUDENT.GRADE",
                query = "select s from Student s where s.grade >= :p"
        )
})

public class Student {

    public static final String STUDENTS_FIND_ALL = "STUDENTS.ALL";
    public static final String STUDENT_FIND_BY_GRADE = "STUDENT.GRADE";

    @Id
    @Column(name = "STUDENTID")
    private int id;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "TOTALGRADE")
    private double grade;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<Phone> phone;

    @OneToOne(mappedBy = "student", fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ACCOUNT_ID")
    private Account account;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Student() {}

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }

}
