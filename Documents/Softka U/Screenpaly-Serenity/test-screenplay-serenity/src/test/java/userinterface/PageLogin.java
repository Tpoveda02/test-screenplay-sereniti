package userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class PageLogin {
    public static final Target FIELD_USERNAME = Target.the("Caja de nombre de usuario")
            .locatedBy("//input[@data-test='username']");

    public static final Target FIELD_PASSWORD = Target.the("Caja de contraseña")
            .locatedBy("//input[@data-test='password']");

    public static final Target SUBMIT_LOGIN = Target.the("Botón de login")
            .locatedBy("//input[@type='submit']");

}