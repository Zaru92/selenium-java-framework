package com.automationteststore.testdata.factory;

import com.automationteststore.testdata.model.AddressData;
import net.datafaker.Faker;

public class AddressFactory {

    private static final Faker FAKER = new Faker();

    public static AddressData randomValidAddress() {

        String company = FAKER.company().name();

        String addressLine1 =
                FAKER.address().streetName() + " " + FAKER.number().numberBetween(1, 200);

        String addressLine2 =
                FAKER.bool().bool()
                        ? "Apt " + FAKER.number().numberBetween(1, 50)
                        : "";

        String city = FAKER.address().city();

        String zipCode =
                FAKER.regexify("[0-9]{2}-[0-9]{3}");

        return new AddressData(
                company,
                addressLine1,
                addressLine2,
                city,
                zipCode
        );
    }
}
