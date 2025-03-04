package questions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static userinterface.CheckoutOverviewPage.PRICE_TOTAL_IN_CHECKOUT;

public class SentCheckoutQuestion implements Question<Boolean> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SentCheckoutQuestion.class);
    private final String expectedPriceTotal;

    private SentCheckoutQuestion(String expectedPriceTotal) {
        this.expectedPriceTotal = expectedPriceTotal;
    }

    public static SentCheckoutQuestion verifyTotalPrice(String expectedPriceTotal) {
        return new SentCheckoutQuestion(expectedPriceTotal);
    }

    @Step("{0} visualizará el precio esperado de #expectedPriceTotal en el resumen de compra")
    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            String actualPrice = PRICE_TOTAL_IN_CHECKOUT.resolveFor(actor).getText();
            boolean isCorrect = actualPrice.contains(expectedPriceTotal);
            LOGGER.info("Verificando precio total de compra: Esperado='${}', Actual='{}'", expectedPriceTotal, actualPrice);
            return isCorrect;
        } catch (Exception e) {
            LOGGER.warn("No se pudo obtener el precio total en el checkout. Posible error en la UI.", e);
            return false;
        }
    }
}