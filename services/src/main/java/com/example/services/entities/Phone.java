package com.example.services.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@NamedQueries({
        @NamedQuery(
                name = "PHONE.FIND",
                query = "select p from Phone p where p.student.id = :id"
        ),
        @NamedQuery(
                name = "PHONE.ALL",
                query = "select p from Phone p "
        )
})
@Table(name = "Phone")
public class Phone {

    public static final String FIND_PHONE = "PHONE.FIND";
    public static final String GET_PHONES = "PHONE.ALL";

    @Id
    @Column(name = " PHONE_ID")
    private int id;

    @Column(name = " NUMBER")
    private String number;

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @XmlTransient
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}

