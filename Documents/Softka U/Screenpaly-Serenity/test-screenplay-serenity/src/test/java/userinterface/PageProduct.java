package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class PageProduct extends PageObject {
    public static final Target SORT_DROPDOWN = Target.the("Opción de ordemiento A a la Z")
            .locatedBy("//select[@class='product_sort_container']");
    public static final Target PRODUCT_NAMES = Target.the("Lista de Productos")
            .locatedBy("//div[@class='inventory_item_name']");
}