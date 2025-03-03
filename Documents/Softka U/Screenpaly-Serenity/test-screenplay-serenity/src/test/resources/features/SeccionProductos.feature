Feature: Ordenar productos y realizar una compra en Swag Labs

  Background:
    Given un usuario se encuentra en la página de login
    When ingresa sus credenciales válidas

  Scenario Outline: Ordenar productos, agregar al carrito y realizar la compra
    When ordena los productos por "<sort>"
    And agrega los productos "<product1>" y "<product2>" al carrito
    And elimina el producto "<product_to_remove>" del carrito
    And realiza la compra con información nombre "<first_name>", apellido "<last_name>" y código postal "<postal_code>"
    Then debería ver un mensaje de confirmación de pedido

    Examples:
      | sort                      | product1                         | product2                   | product_to_remove        | first_name | last_name | postal_code |
      | Price (low to high)       | Sauce Labs Backpack              | Sauce Labs Bike Light      | Sauce Labs Backpack      | John       | Doe       | 12345       |
      | Name (A to Z)             | Sauce Labs Onesie                | Sauce Labs Bolt T-Shirt    | Sauce Labs Bolt T-Shirt  | Maria      | Smith     | 67890       |
      | Price (high to low)       | Test.allTheThings() T-Shirt (Red)| Sauce Labs Fleece Jacket   | Sauce Labs Fleece Jacket | Carlos     | Brown     | 11223       |