package stepsdefinitions;

import hook.OpenBrowser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.GivenWhenThen;

import net.serenitybdd.screenplay.actors.OnStage;

import static constants.Constants.ACTOR;
import static constants.Constants.WEB_URL;
import static org.hamcrest.CoreMatchers.containsString;
import static questions.CurrentUrl.currentUrl;
import static tasks.Login.loginWithCredentials;


public class Login {

    @Given("un usuario se encuentra en la página de login")
    public void unUsuarioSeEncuentraEnLaPaginaDeLogin() {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                OpenBrowser.openBrowser(WEB_URL)
        );
    }

    @When("ingresa sus credenciales válidas")
    public void ingresaSusCredencialesValidas() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                loginWithCredentials("standard_user", "secret_sauce")
        );
    }

    @Then("debería ser redirigido a la página de productos")
    public void deberiaSerRedirigidoALaPaginaDeProductos() {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("La URL actual",
                        currentUrl(),
                        containsString("/inventory.html"))
        );
    }

}