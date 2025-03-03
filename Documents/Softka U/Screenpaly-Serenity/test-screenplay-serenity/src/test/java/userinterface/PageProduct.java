package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class PageProduct extends PageObject {
    public static final Target SORT_DROPDOWN = Target.the("Opción de ordemiento A a la Z")
            .locatedBy("//select[@class='product_sort_container']");
    public static final Target PRODUCT_NAMES = Target.the("Lista de Productos")
            .locatedBy("//div[@class='inventory_item_name']");

    public static final Target PRODUCT_PRICES= Target.the("Lista de Precios de los Productos")
            .locatedBy("//div[@class='inventory_item_price']");

    public static final Target BTN_ADD_PRODUCT_INTO_CART = Target.the("Botón para agregar el producto '{0}' al carrito")
            .locatedBy("//div[contains(@class, 'inventory_item')][.//div[contains(@class, 'inventory_item_name') and text()='{0}']]//button[contains(@class, 'btn_inventory')]");


    public static final Target LINK_GO_CART = Target.the("Enlace hacia el carrito de compras")
            .locatedBy("//a[@href='./cart.html']");

}