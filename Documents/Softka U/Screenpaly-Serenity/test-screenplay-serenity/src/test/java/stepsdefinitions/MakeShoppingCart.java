package stepsdefinitions;

import hook.OpenBrowser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import questions.AddProductQuestion;
import questions.MessageQuestion;
import questions.OrderProductsQuestion;
import questions.SentCheckoutQuestion;
import tasks.*;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.CoreMatchers.equalTo;
import static questions.RemovedProductQuestion.verifyIfRemovedProduct;

import static constants.Constants.ACTOR;
import static constants.Constants.WEB_URL;
import static userinterface.CartPage.*;
import static userinterface.CheckoutOverviewPage.LINK_GO_FINISH_CHECKOUT;
import static userinterface.FinishCheckoutPage.MESSAGE_COMPLETE;
import static userinterface.ProductPage.*;

public class MakeShoppingCart {

    @Given("un usuario se ingresó a la página de login")
    public void unUsuarioSeIngresóALaPáginaDeLogin() {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                OpenBrowser.openBrowser(WEB_URL)
        );
    }

    @When("ingresa sus credenciales válidas: usuario {string} y contraseña {string}")
    public void ingresaSusCredencialesVálidasUsuarioYContraseña(String userName, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginTask.withCredentials(userName, password)
        );
    }

    @And("ordena los productos por {string}")
    public void ordenaLosProductosPor(String sort) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SortTask.by(sort),
                WaitUntil.the(PRODUCT_NAMES, isVisible()).forNoMoreThan(5).seconds()
        );

        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen
                        .seeThat("Los productos deberían estar en orden " + sort,
                                OrderProductsQuestion.isSortedBy(sort),
                        equalTo(true))
        );

    }

    @And("agrega los productos {string} y {string} al carrito")
    public void agregaLosProductosYAlCarrito(String product1, String product2) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddProductTask.addProduct(product1),
                AddProductTask.addProduct(product2),
                GoToOtherPage.on(LINK_GO_CART, "se dirige al carrito de compras"),
                WaitUntil.the(PRODUCT_NAMES, isVisible()).forNoMoreThan(5).seconds()
        );

        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("El producto " + product1 + " está en la lista",
                        AddProductQuestion.verifyIfAddedProduct(product1), equalTo(true)
                )
        );

        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("El producto " + product2 + " está en la lista",
                        AddProductQuestion.verifyIfAddedProduct(product2), equalTo(true))
        );
    }

    @And("elimina el producto {string} del carrito")
    public void eliminaElProductoDelCarrito(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RemoveProductTask.removeProduct(productName),
                WaitUntil.the(PRODUCT_NAMES_CART, isVisible()).forNoMoreThan(5).seconds()
        );

        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("El producto NO está en la lista", verifyIfRemovedProduct(productName), equalTo(true))
        );

    }

    @And("realiza la compra con información {string}, {string}, {string} y un total {string}")
    public void realizaLaCompraConInformaciónYUnTotal$(String firstName, String lastName, String postalCode, String totalPrice) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GoToOtherPage.on(LINK_GO_FORM_CHECKOUT, "se dirige al formulario para completar su información"),
                SendFormCheckoutTask.sendFormCheckout(firstName, lastName, postalCode)
        );
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("El precio total de la compra sería " + totalPrice,
                        SentCheckoutQuestion.verifyTotalPrice(totalPrice), equalTo(true))
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                GoToOtherPage.on(LINK_GO_FINISH_CHECKOUT, "finaliza la compra")
        );

    }

    @Then("debería ver el mensaje de confirmación de pedido {string}")
    public void deberíaVerElMensajeDeConfirmaciónDePedido(String message) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("El mensaje de confirmación sería " + message,
                        MessageQuestion.verifyContentOfMessage(message, MESSAGE_COMPLETE), equalTo(true))
        );
    }


}
