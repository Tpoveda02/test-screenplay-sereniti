package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static userinterface.CartPage.BTN_REMOVE_PRODUCT_FROM_CART;

public class RemoveProductTask implements Task {
    private String productName;

    public RemoveProductTask(String productName) {
        this.productName = productName;
    }

    @Step("remover del carrito el producto #productName")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_REMOVE_PRODUCT_FROM_CART.of(productName))
        );
    }

    public static RemoveProductTask removeProduct(String productName){
        return Tasks.instrumented(RemoveProductTask.class, productName);
    }
}
