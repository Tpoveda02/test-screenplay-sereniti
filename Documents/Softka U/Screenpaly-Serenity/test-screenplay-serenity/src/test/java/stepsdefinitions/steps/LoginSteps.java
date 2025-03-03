package stepsdefinitions.steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.steps.ScenarioSteps;
import questions.CurrentUrl;

import static constants.Constants.ACTOR;
import static userinterface.PageLogin.*;

public class LoginSteps extends ScenarioSteps {

    @Step("El usuario ingresa su nombre de usuario")
    public void enterUsername(String username) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Clear.field(FIELD_USERNAME),
                Enter.theValue(username).into(FIELD_USERNAME)
        );
    }

    @Step("El usuario ingresa su contraseña")
    public void enterPassword(String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Clear.field(FIELD_PASSWORD),
                Enter.theValue(password).into(FIELD_PASSWORD)
        );
    }

    @Step("El usuario hace clic en el botón de login")
    public void clickLoginButton() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(SUBMIT_LOGIN)
        );
    }

}