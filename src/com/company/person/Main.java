package com.company.person;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<Person> personSet = new HashSet<>();
        for (int i = 0; i < 15; i++) {
            personSet.add(RandomPerson.getRandomPerson());
        }

        personSet.stream().sorted().forEach(System.out::println);

        System.out.println();

    }
}
