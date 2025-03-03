package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static userinterface.PageProduct.*;

public class AddProductTask implements Task {
    private String productName;

    public AddProductTask(String productName) {
        this.productName = productName;
    }

    @Step("agrega al carrito el producto #productName")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_ADD_PRODUCT_INTO_CART.of(productName))
        );
    }
    public static AddProductTask addProduct(String productName){
        return Tasks.instrumented(AddProductTask.class, productName);
    }
}
