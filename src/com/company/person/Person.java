package com.company.person;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person implements Comparable<Person> {
    private String name;
    private LocalDate dateOfBirth;

    public Person(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public int compareTo(Person o) {
        return -this.dateOfBirth.compareTo(o.getDateOfBirth()); //0 ... 100 -> 1950 ... 2000
    }

    @Override
    public String toString() {
        int years = (int) ChronoUnit.YEARS.between(this.dateOfBirth, LocalDate.now());
        return String.format("%s born in %td %tB %tY and is %s years old",
                this.name,
                this.dateOfBirth,
                this.dateOfBirth,
                this.dateOfBirth,
                years);
    }
}
