package stepsdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.OrderProducts;

import static constants.Constants.ACTOR;
import static constants.Constants.WEB_URL;
import hook.OpenBrowser;

import static tasks.Login.loginWithCredentials;
import static tasks.OrganizeAToZ.orderAToZ;

public class OrderAToZ {
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


    @When("selecciona la opción de ordenar de la A a la Z")
    public void selecciona_la_opción_de_ordenar_de_la_a_a_la_z() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                orderAToZ()
        );
    }

    @Then("el producto {string} se visualizará en la posición {string}")
    public void el_producto_se_visualizará_en_la_posición(String productName, String position) {
        int pos = Integer.parseInt(position);
        String actualProductName = OnStage.theActorInTheSpotlight().asksFor(OrderProducts.nameAtPosition(pos));
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("El producto en la posición " + position + " debería ser " + productName,
                        actual -> actualProductName.equals(productName)
                )
        );
    }

}