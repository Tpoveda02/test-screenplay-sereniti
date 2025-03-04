package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class FinishCheckoutPage extends PageObject {
    public static final Target MESSAGE_COMPLETE = Target.the("Mensaje de error")
            .locatedBy("//h2[@class='complete-header']");
}
