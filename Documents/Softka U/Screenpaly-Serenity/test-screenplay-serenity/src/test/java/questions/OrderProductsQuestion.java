package questions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.Actor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static userinterface.ProductPage.PRODUCT_NAMES;

import java.util.List;
import java.util.stream.Stream;

import static userinterface.ProductPage.PRODUCT_PRICES;

public class OrderProductsQuestion implements Question<Boolean> {

    private final String sort;

    private OrderProductsQuestion(String sort) {
        this.sort = sort;
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProductsQuestion.class);

    public static OrderProductsQuestion isSortedBy(String sort) {
        return new OrderProductsQuestion(sort);
    }
    @Step("{0} visualiza los productos en el orden #sort")
    @Override
    public Boolean answeredBy(Actor actor) {

        List<String> productNames = Collections.singletonList(Text.of(PRODUCT_NAMES).answeredBy(actor));
        List<Double> prices = Stream.of(Text.of(PRODUCT_PRICES)
                        .answeredBy(actor))
                .map(price -> Double.parseDouble(price.replace("$", "")))
                .toList();
        List<String> expectedOrder = new ArrayList<>(productNames);

        LOGGER.info("Verificando orden: {}", sort);
        LOGGER.info("Productos obtenidos: {}", productNames);
        LOGGER.info("Precios obtenidos: {}", prices);

        switch (sort) {
            case "Name (A to Z)":
                expectedOrder.sort(String::compareToIgnoreCase);
                break;

            case "Name (Z to A)":
                expectedOrder.sort(Comparator.reverseOrder());
                break;

            case "Price (low to high)":
                List<Double> sortedPricesLow = new ArrayList<>(prices);
                sortedPricesLow.sort(Double::compareTo);
                return prices.equals(sortedPricesLow);

            case "Price (high to low)":
                List<Double> sortedPricesHigh = new ArrayList<>(prices);
                sortedPricesHigh.sort(Comparator.reverseOrder());
                return prices.equals(sortedPricesHigh);

            default:
                LOGGER.error("Criterio de ordenación no válido: {}", sort);
                throw new IllegalArgumentException("Criterio de ordenación no válido: " + sort);
        }
        return productNames.equals(expectedOrder);
    }
}
