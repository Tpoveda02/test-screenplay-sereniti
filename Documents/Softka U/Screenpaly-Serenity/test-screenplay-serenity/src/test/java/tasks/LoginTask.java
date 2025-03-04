package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import tasks.steps.LoginSteps;

public class LoginTask implements Task {

    private final String userName;
    private final String password;

    @Steps
    LoginSteps loginSteps;

    public LoginTask(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Step("{0} intenta iniciar sesión con usuario #userName y contraseña #password")
    @Override
    public <T extends Actor> void performAs(T actor) {
        loginSteps.enterUsername(actor, userName);
        loginSteps.enterPassword(actor, password);
        loginSteps.clickLoginButton(actor);
    }

    public static LoginTask withCredentials(String userName, String password) {
        return Tasks.instrumented(LoginTask.class, userName, password);
    }
}