package com.automationteststore.testdata.factory;

import com.automationteststore.testdata.model.UserData;
import net.datafaker.Faker;

public class UserFactory {

    private static final Faker FAKER = new Faker();

    public static UserData randomValidUser() {

        String firstName = FAKER.name().firstName();
        String lastName = FAKER.name().lastName();

        String email =
                FAKER.regexify("[a-zA-Z]{5,10}")
                        + FAKER.regexify("[0-9]{1,4}")
                        + System.currentTimeMillis()
                        + "@"
                        + FAKER.regexify("[a-zA-Z]{5,10}")
                        + "."
                        + FAKER.regexify("[a-zA-Z]{2,3}");

        String phone =
                FAKER.regexify("[0-9]{3}")
                        + "-"
                        + FAKER.regexify("[0-9]{3}")
                        + "-"
                        + FAKER.regexify("[0-9]{3}");

        return new UserData(
                firstName,
                lastName,
                email,
                phone
        );
    }
}
