package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static userinterface.PageProduct.SORT_DROPDOWN;

public class OrganizeAToZ implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byVisibleText("Name (A to Z)").from(SORT_DROPDOWN)
        );
    }

    public static OrganizeAToZ orderAToZ(){
        return Tasks.instrumented(OrganizeAToZ.class);
    }
}
