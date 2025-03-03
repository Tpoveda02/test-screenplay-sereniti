package stepsdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static org.hamcrest.CoreMatchers.equalTo;
import static questions.RemovedProduct.verifyIfRemovedProduct;
import static tasks.RemoveProduct.removeProduct;

public class RemoveProduct {
    @And("remueve el producto {string}")
    public void remueveElProductoProduct(String product) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                removeProduct(product)
        );
    }

    @Then("no se visualizará el producto {string} en el carrito")
    public void noSeVisualizaráElProductoProductEnElCarrito(String product) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("El producto NO está en la lista", verifyIfRemovedProduct(product), equalTo(true))
        );

    }
}
