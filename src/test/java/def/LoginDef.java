package test.def;

import io.cucumber.java.en.Given;
import test.pages.MainPage;

public class LoginDef {

    private MainPage mainPage;


//    public LoginDef(MainPage mainPage) {
//        this.mainPage = mainPage;
//    }

    @Given("User is logged")
    public void user_is_logged() {
        mainPage.openLogInForm();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
