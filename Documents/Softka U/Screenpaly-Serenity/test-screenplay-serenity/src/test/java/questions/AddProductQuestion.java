package questions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.Collections;
import java.util.List;

import static userinterface.CartPage.PRODUCT_NAMES;
import static userinterface.CartPage.PRODUCT_NAME_IN_CART;

public class AddProductQuestion implements Question<Boolean> {

    private final String nameProduct;

    private AddProductQuestion(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public static AddProductQuestion verifyIfAddedProduct(String nameProduct) {
        return new AddProductQuestion(nameProduct);
    }

    @Step("se visualizará el producto {0} en el carrito")
    @Override
    public Boolean answeredBy(Actor actor) {
        return PRODUCT_NAME_IN_CART.of(nameProduct).isVisibleFor(actor);
    }
}