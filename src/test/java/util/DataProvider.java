package util;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "login data")
    public Object[][] getData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"}
        };
    }
    @org.testng.annotations.DataProvider(name = "standart login")
    public Object[][] getCredentialsStandart() {
        return new Object[][]{
                {"standard_user", "secret_sauce"}
        };
    }
    @org.testng.annotations.DataProvider(name = "locked out login")
    public Object[][] getCredentialsLockedOut() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce"}
        };
    }
    @org.testng.annotations.DataProvider(name = "problem login")
    public Object[][] getCredentialsProblem() {
        return new Object[][]{
                {"problem_user", "secret_sauce"}
        };
    }

}
