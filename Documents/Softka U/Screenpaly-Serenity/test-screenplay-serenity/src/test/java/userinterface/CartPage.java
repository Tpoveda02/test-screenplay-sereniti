package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class CartPage extends PageObject {

    public static final Target PRODUCT_NAMES = Target.the("Lista de Productos")
            .locatedBy("//div[@class='inventory_item_name']");

    public static Target removeButtonForProduct(String productName) {
        return Target.the("Botón de remover del carrito para " + productName)
                .locatedBy("//div[text()='{0}']/ancestor::div[@class='cart_item']//button[contains(@class, 'cart_button')]")
                .of(productName);
    }
    public static final Target PRODUCT_NAME_IN_CART = Target.the("El producto '{0}' esta en el carrito")
            .locatedBy("//div[@class='cart_item']//div[text()='{0}']");


    public static Target productInCart(String productName) {
        return Target.the("Producto en el carrito: " + productName)
                .locatedBy("//div[@class='cart_item']//div[text()='{0}']")
                .of(productName);
    }

}
