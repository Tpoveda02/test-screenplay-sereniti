package questions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static userinterface.CheckoutOverviewPage.PRICE_TOTAL_IN_CHECKOUT;

public class SentCheckoutQuestion implements Question<Boolean> {
    private String priceTotal;

    public SentCheckoutQuestion(String priceTotal) {
        this.priceTotal = priceTotal;
    }
    public static SentCheckoutQuestion verifyTotalPrice(String nameProduct) {
        return new SentCheckoutQuestion(nameProduct);
    }

    @Step("{0} visualizará el precio #priceTotal por la compra")
    @Override
    public Boolean answeredBy(Actor actor) {
        return PRICE_TOTAL_IN_CHECKOUT.resolveFor(actor).getText().contains("$" + priceTotal);
    }
}
