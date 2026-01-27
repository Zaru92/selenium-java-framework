package testdata.provider;

import testdata.model.Credentials;

public class TestUserProvider {

    public static Credentials validUser() {
        String user = EnvironmentDataProvider.get("validUser", "demoUser");
        String pass = EnvironmentDataProvider.get("validPass", "demoPass");

        return new Credentials(user, pass);
    }
}
