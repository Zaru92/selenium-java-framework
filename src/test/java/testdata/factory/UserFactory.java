package testdata.factory;

import net.datafaker.Faker;
import testdata.model.UserData;

public class UserFactory {

    private static final Faker faker = new Faker();

    public static UserData randomValidUser() {

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        String email =
                faker.regexify("[a-zA-Z]{5,10}")
                        + faker.regexify("[0-9]{1,4}")
                        + System.currentTimeMillis()
                        + "@"
                        + faker.regexify("[a-zA-Z]{5,10}")
                        + "."
                        + faker.regexify("[a-zA-Z]{2,3}");

        String phone =
                faker.regexify("[0-9]{3}")
                        + "-"
                        + faker.regexify("[0-9]{3}")
                        + "-"
                        + faker.regexify("[0-9]{3}");

        return new UserData(
                firstName,
                lastName,
                email,
                phone
        );
    }
}
