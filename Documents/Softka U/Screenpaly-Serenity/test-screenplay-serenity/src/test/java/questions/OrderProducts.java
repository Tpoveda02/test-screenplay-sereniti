package questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.Actor;

import java.util.List;

import static userinterface.PageProduct.PRODUCT_NAMES;

public class OrderProducts implements Question<String> {

    private final int position;

    private OrderProducts(int position) {
        this.position = position;
    }

    public static OrderProducts nameAtPosition(int position) {
        return new OrderProducts(position);
    }

    @Override
    public String answeredBy(Actor actor) {
        List<String> productNames = (List<String>) Text.ofEach(PRODUCT_NAMES).answeredBy(actor);

        if (position < 1 || position > productNames.size()) {
            throw new IllegalArgumentException("La posición " + position + " está fuera de rango.");
        }

        return productNames.get(position - 1);
    }
}