package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static userinterface.CheckoutOverviewPage.LINK_GO_FINISH_CHECKOUT;

public class GoToFinishTask implements Task {
    @Step("{0} finaliza la compra")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LINK_GO_FINISH_CHECKOUT)
        );
    }
    public static GoToFinishTask goToFinish(){
        return Tasks.instrumented(GoToFinishTask.class);
    }
}
