package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class CheckoutOverviewPage extends PageObject {

    public static final Target PRICE_TOTAL_IN_CHECKOUT = Target.the("El precio total de la compra")
            .locatedBy("//div[@class='summary_total_label']");



    public static final Target LINK_GO_FINISH_CHECKOUT = Target.the("Enlace para finalizar la compra")
            .locatedBy("//a[href='./checkout-complete.html']");
}
