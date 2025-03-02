package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.annotations.Steps;
import tasks.steps.LoginSteps;


public class Login implements Task {

    private String userName;
    private String password;

    @Steps
    LoginSteps loginSteps;


    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        loginSteps.enterUsername("standard_user");
        loginSteps.enterPassword("secret_sauce");
        loginSteps.clickLoginButton();
    }

    public static Login loginWithCredentials(String userName, String password) {
        return Tasks.instrumented(Login.class, userName, password);
    }
}