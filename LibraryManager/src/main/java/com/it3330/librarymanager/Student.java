package com.it3330.librarymanager;

import java.util.*;
public class Student extends Member {
    private Professor advisor;
    //private int memberId;
    // constructor
    public Student(String name, String address, Date dob, String email, SSN ssn, Professor advisor) {
        super(name, address, dob, email, ssn);
        this.advisor = advisor;
    }

    public Student(String name, String address, Date dob, String email, SSN ssn) {
        super(name, address, dob, email, ssn);
    }

    // getters and setters
    public Professor getAdvisor() { return advisor; }
    public void setAdvisor(Professor advisor) { this.advisor = advisor; }
}
