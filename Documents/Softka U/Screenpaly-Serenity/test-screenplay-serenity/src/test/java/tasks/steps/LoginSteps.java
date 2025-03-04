package tasks.steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.steps.ScenarioSteps;

import static userinterface.LoginPage.*;

public class LoginSteps extends ScenarioSteps {

    @Step("{actor} ingresa el usuario '{text}'")
    public void enterUsername(Actor actor, String text) {
        actor.attemptsTo(
                Clear.field(FIELD_USERNAME),
                Enter.theValue(text).into(FIELD_USERNAME)
        );
        actor.attemptsTo(Ensure.that(FIELD_USERNAME).value().isEqualTo(text));
    }

    @Step("{actor} ingresa su contraseña")
    public void enterPassword(Actor actor, String password) {
        actor.attemptsTo(
                Clear.field(FIELD_PASSWORD),
                Enter.theValue(password).into(FIELD_PASSWORD)
        );
    }

    @Step("{actor} hace clic en el botón de login")
    public void clickLoginButton(Actor actor) {
        actor.attemptsTo(Click.on(SUBMIT_LOGIN));
    }
}
