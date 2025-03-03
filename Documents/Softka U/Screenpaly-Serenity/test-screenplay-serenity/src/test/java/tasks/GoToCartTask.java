package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import net.serenitybdd.screenplay.actions.Click;


import static userinterface.PageProduct.LINK_GO_CART;


public class GoToCartTask implements Task {
    @Step("se dirige al carriro de compras")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LINK_GO_CART)
        );

    }

    public static GoToCartTask goToCart(){
        return Tasks.instrumented(GoToCartTask.class);
    }
}
