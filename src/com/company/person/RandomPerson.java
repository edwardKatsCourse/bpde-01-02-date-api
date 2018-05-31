package com.company.person;

import java.time.LocalDate;
import java.util.Random;

public class RandomPerson {

    private static final String[] NAMES = {
            "David",
            "Jane",
            "Pavel",
            "Jodie",
            "Peter",
            "Clara",
            "Michael",
            "Jim"
    };

    public static Person getRandomPerson() {
        int nameRandomIndex = new Random().nextInt(NAMES.length); // 0...NAMES.length-1
        String name = NAMES[nameRandomIndex];

        LocalDate dateOfBirth = getRandomDateOfBirth();

        return new Person(name, dateOfBirth);

    }

    private static int getYear() {
        int min = 1950;
        int max = 2000;
        return new Random().nextInt(max + 1 - min) + min; //(max + 1 - min) + min
    }

    private static int getMonth() {
        int max = 12;
        int min = 1;
        return new Random().nextInt(max + 1 - min) + min;
    }

    private static LocalDate getRandomDateOfBirth() {
        LocalDate localDate = LocalDate.of(getYear(), getMonth(), 1);

        int min = 1;
        int max = localDate.lengthOfMonth();
        int randomDay = new Random().nextInt(max + 1 - min) + min;

        return LocalDate.of(localDate.getYear(), localDate.getMonth(), randomDay);
    }
}
