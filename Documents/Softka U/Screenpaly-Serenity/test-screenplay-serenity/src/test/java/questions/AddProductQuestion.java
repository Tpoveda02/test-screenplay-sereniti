package questions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static userinterface.CartPage.PRODUCT_NAME_IN_CART;

public class AddProductQuestion implements Question<Boolean> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddProductQuestion.class);
    private final String nameProduct;

    private AddProductQuestion(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public static AddProductQuestion verifyIfAddedProduct(String nameProduct) {
        return new AddProductQuestion(nameProduct);
    }

    @Step("Se visualizará el producto '{nameProduct}' en el carrito")
    @Override
    public Boolean answeredBy(Actor actor) {
        boolean isVisible = PRODUCT_NAME_IN_CART.of(nameProduct).isVisibleFor(actor);

        if (isVisible) {
            LOGGER.info("El producto '{}' está visible en el carrito.", nameProduct);
        } else {
            LOGGER.warn("⚠El producto '{}' NO se encontró en el carrito.", nameProduct);
        }

        return isVisible;
    }
}
