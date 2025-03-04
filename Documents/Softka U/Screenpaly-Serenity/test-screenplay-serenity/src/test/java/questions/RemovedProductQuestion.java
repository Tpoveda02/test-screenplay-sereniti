package questions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static userinterface.CartPage.PRODUCT_NAME_IN_CART;

public class RemovedProductQuestion implements Question<Boolean> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RemovedProductQuestion.class);
    private final String nameProduct;

    private RemovedProductQuestion(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public static RemovedProductQuestion verifyIfRemovedProduct(String nameProduct) {
        return new RemovedProductQuestion(nameProduct);
    }

    @Step("{0} verifica que el producto #nameProduct NO esté visible en el carrito")
    @Override
    public Boolean answeredBy(Actor actor) {
        boolean isVisible;
        try {
            isVisible = Visibility.of(PRODUCT_NAME_IN_CART.of(nameProduct)).answeredBy(actor);
        } catch (Exception e) {
            LOGGER.warn("⚠Producto '{}' no encontrado en el carrito. Se asume que fue eliminado.", nameProduct);
            return true;
        }

        LOGGER.info("Verificando eliminación del producto '{}': {}", nameProduct, !isVisible ? "Eliminado" : "Aún visible");
        return !isVisible;
    }
}
