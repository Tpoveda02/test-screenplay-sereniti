package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class FormCheckoutPage extends PageObject {
    public static final Target FIELD_FIRSTNAME = Target.the("Caja de nombre de {0}")
            .locatedBy("//input[@data-test='firstName']");

    public static final Target FIELD_LASTNAME = Target.the("Caja de apellido de {0}")
            .locatedBy("//input[@data-test='lastName']");

    public static final Target FIELD_POSTAL_CODE = Target.the("Caja de código postal de {0}")
            .locatedBy("//input[@data-test='postalCode']");

    public static final Target SUBMIT_NEXT= Target.the("Botón de continuar y envíar el formulario")
            .locatedBy("//input[@type='submit']");
}
