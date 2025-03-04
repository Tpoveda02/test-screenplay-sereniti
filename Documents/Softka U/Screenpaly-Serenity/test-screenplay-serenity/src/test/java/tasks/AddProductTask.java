package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static userinterface.ProductPage.*;

public class AddProductTask implements Task {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddProductTask.class);
    private String productName;

    public AddProductTask(String productName) {
        this.productName = productName;
    }

    @Step("{0} agrega al carrito el producto #productName")
    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} está agregando el producto '{}' al carrito de compras", actor.getName(), productName);

        actor.attemptsTo(
                Click.on(BTN_ADD_PRODUCT_INTO_CART.of(productName))
        );
    }
    public static AddProductTask addProduct(String productName){
        return Tasks.instrumented(AddProductTask.class, productName);
    }
}
