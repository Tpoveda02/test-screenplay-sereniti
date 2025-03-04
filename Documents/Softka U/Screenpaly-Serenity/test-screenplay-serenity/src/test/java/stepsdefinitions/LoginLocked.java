package stepsdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.MessageQuestion;
import tasks.LoginTask;

import static org.hamcrest.CoreMatchers.equalTo;
import static userinterface.LoginPage.MESSAGE_ERROR;


public class LoginLocked {

    @When("ingresa credenciales bloqueadas: usuario {string} y contraseña {string}")
    public void ingresaCredencialesBloqueadasUsuarioYContraseña(String userName, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginTask.withCredentials(userName, password)
        );
    }

    @Then("debería mostrarse el mensaje de error {string}")
    public void deberíaMostrarseElMensajeDeErrorMessage_error(String messageError) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("El mensaje de error sería " + messageError,
                        MessageQuestion.verifyContentOfMessage(messageError, MESSAGE_ERROR), equalTo(true))
        );
    }


}