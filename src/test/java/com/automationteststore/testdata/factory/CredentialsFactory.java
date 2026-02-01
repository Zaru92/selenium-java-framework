package com.automationteststore.testdata.factory;

import com.automationteststore.config.TestConfig;
import com.automationteststore.testdata.model.Credentials;

import java.util.UUID;

public class CredentialsFactory {

    public static Credentials invalid() {
        return new Credentials("wrong_user", "wrong_pass");
    }

    public static Credentials empty() {
        return new Credentials("", "");
    }

    public static Credentials from(String user, String pass) {
        return new Credentials(user, pass);
    }

    public static Credentials validUser() {
        return new Credentials(TestConfig.validUsername(), TestConfig.validPassword());
    }

    public static Credentials randomUser() {
        String login = generateLogin(5);
        String password = generatePassword();
        return new Credentials(login, password);
    }

    private static String generateLogin(int minLength) {
        String base = "user" + UUID.randomUUID().toString().replace("-", "");
        return base.substring(0, Math.max(minLength, base.length()));
    }

    private static String generatePassword() {
        return ("Pass!" + UUID.randomUUID().toString().replace("-", ""))
                .substring(0, 20);
    }

}
