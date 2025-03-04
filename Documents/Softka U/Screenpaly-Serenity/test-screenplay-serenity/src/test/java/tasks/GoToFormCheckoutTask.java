package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static userinterface.CartPage.LINK_GO_FORM_CHECKOUT;

public class GoToFormCheckoutTask implements Task {
    @Step("{0} se dirige al formulario para completar su información")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LINK_GO_FORM_CHECKOUT)
        );
    }
    public static GoToFormCheckoutTask goToFormCheckout(){
        return Tasks.instrumented(GoToFormCheckoutTask.class);
    }
}
