package questions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

import static userinterface.CartPage.PRODUCT_NAME_IN_CART;

public class RemovedProductQuestion implements Question<Boolean> {

    private final String nameProduct;

    private RemovedProductQuestion(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public static RemovedProductQuestion verifyIfRemovedProduct(String nameProduct) {
        return new RemovedProductQuestion(nameProduct);
    }

    @Step("NO se visualizará el producto #nameProduct en el carrito")
    @Override
    public Boolean answeredBy(Actor actor) {
        return !Visibility.of(PRODUCT_NAME_IN_CART.of(nameProduct)).answeredBy(actor);
    }
}