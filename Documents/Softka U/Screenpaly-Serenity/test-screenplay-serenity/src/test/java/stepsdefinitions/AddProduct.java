package stepsdefinitions;

import hook.OpenBrowser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static constants.Constants.ACTOR;
import static constants.Constants.WEB_URL;
import static tasks.Login.loginWithCredentials;

public class AddProduct {
    @Given("un usuario se encuentra en la página de inicio de sesión")
    public void unUsuarioSeEncuentraEnLaPáginaDeInicioDeSesión() {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                OpenBrowser.openBrowser(WEB_URL)
        );
    }
    @And("se autentica con credenciales válidas")
    public void seAutenticaConCredencialesVálidas() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                loginWithCredentials("standard_user", "secret_sauce")
        );
    }

    @When("agrega al carrito el producto {string}")
    public void agregaAlCarritoElProductoProduct() {
        
    }

    @And("se dirige al carriro de compras")
    public void seDirigeAlCarriroDeCompras() {
    }

    @Then("se visualizará el {string} en el carrito")
    public void seVisualizaráElProductEnElCarrito() {
    }


}
