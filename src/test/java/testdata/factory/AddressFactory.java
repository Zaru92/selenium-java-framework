package testdata.factory;

import net.datafaker.Faker;
import testdata.model.AddressData;

public class AddressFactory {

    private static final Faker faker = new Faker();

    public static AddressData randomValidAddress() {

        String company = faker.company().name();

        String addressLine1 =
                faker.address().streetName() + " " + faker.number().numberBetween(1, 200);

        String addressLine2 =
                faker.bool().bool()
                        ? "Apt " + faker.number().numberBetween(1, 50)
                        : "";

        String city = faker.address().city();

        String zipCode =
                faker.regexify("[0-9]{2}-[0-9]{3}");

        return new AddressData(
                company,
                addressLine1,
                addressLine2,
                city,
                zipCode
        );
    }
}
