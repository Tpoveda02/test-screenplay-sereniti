package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static userinterface.CartPage.removeButtonForProduct;

public class RemoveProduct implements Task {
    private String productName;

    public RemoveProduct(String productName) {
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(removeButtonForProduct(productName))
        );
    }

    public static RemoveProduct removeProduct(String productName){
        return Tasks.instrumented(RemoveProduct.class, productName);
    }
}
