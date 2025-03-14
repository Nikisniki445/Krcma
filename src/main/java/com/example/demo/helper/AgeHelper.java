package com.example.demo.helper;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AgeHelper {

    public static Boolean isAdult(LocalDate dateOfBirth) {

        return ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now()) >= 18;
    }

    public static Long getAge(LocalDate dateOfBirth) {
        return ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
    }


}
