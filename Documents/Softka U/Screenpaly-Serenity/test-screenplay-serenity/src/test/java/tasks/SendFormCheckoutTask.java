package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static userinterface.FormCheckoutPage.*;

public class SendFormCheckoutTask implements Task {
    private String firstName;
    private String lastName;
    private String postalCode;


    public SendFormCheckoutTask(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    @Step("{0} completa y envía la información de compra con nombre #firstName, apellido #lastName y código postal #postalCode")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(FIELD_FIRSTNAME),
                Enter.theValue(firstName).into(FIELD_FIRSTNAME),
                Clear.field(FIELD_LASTNAME),
                Enter.theValue(lastName).into(FIELD_LASTNAME),
                Clear.field(FIELD_POSTAL_CODE),
                Enter.theValue(postalCode).into(FIELD_POSTAL_CODE),
                Click.on(SUBMIT_NEXT)
        );
    }
    public static SendFormCheckoutTask sendFormCheckout(String firstName, String lastName, String postalCode){
        return Tasks.instrumented(SendFormCheckoutTask.class, firstName, lastName, postalCode);
    }
}
