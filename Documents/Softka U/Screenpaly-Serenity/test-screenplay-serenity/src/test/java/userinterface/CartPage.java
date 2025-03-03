package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class CartPage extends PageObject {

    public static final Target PRODUCT_NAMES_CART = Target.the("Lista de Productos")
            .locatedBy("//div[@class='inventory_item_name']");

    public static final Target PRODUCT_NAME_IN_CART = Target.the("El producto '{0}' esta en el carrito")
            .locatedBy("//div[@class='cart_item']//div[text()='{0}']");

    public static final Target BTN_REMOVE_PRODUCT_FROM_CART = Target.the("Botón para agregar el producto '{0}' al carrito")
            .locatedBy("//div[contains(@class, 'cart_item')][.//div[contains(@class, 'inventory_item_name') and text()='{0}']]//button[contains(@class, 'cart_button')]");


}
