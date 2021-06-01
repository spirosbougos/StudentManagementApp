package com.example.services.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "ACCOUNT.ALL",
                query = "select a from Account a where a.id = :p"
        )
})
@Table(name = "Account")
public class Account {

    public static final String FIND_ACCOUNT = "ACCOUNT.ALL";

    @Id
    @Column(name = "ACCOUNT_ID")
    private int id;

    @Column(name = "ACCOUNT_NUMBER")
    private String number;

    @OneToOne
    @MapsId
    @JoinColumn(name = "ACCOUNT_ID")
    @JsonIgnore
    private Student student;

    public Account() { }

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
