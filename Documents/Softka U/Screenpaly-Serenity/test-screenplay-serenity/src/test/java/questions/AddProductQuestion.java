package questions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static userinterface.CartPage.PRODUCT_NAME_IN_CART;

public class AddProductQuestion implements Question<Boolean> {

    private final String nameProduct;

    private AddProductQuestion(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public static AddProductQuestion verifyIfAddedProduct(String nameProduct) {
        return new AddProductQuestion(nameProduct);
    }

    @Step("se visualizará el producto #nameProduct en el carrito")
    @Override
    public Boolean answeredBy(Actor actor) {
        return PRODUCT_NAME_IN_CART.of(nameProduct).isVisibleFor(actor);
    }
}