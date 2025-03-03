package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.questions.page.TheWebPage;

import java.util.Collections;
import java.util.List;

import static userinterface.CartPage.PRODUCT_NAMES;
import static userinterface.CartPage.productInCart;

public class RemovedProduct implements Question<Boolean> {

    private final String nameProduct;

    private RemovedProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public static RemovedProduct verifyIfRemovedProduct(String nameProduct) {
        return new RemovedProduct(nameProduct);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return !Visibility.of(productInCart(nameProduct)).answeredBy(actor);
    }
}