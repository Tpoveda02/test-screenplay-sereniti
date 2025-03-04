Feature: Ordenar productos y realizar una compra en Swag Labs

  Background:
    Given un usuario se encuentra en la página de login
    When ingresa sus credenciales válidas

  Scenario Outline: Ordenar productos, agregar al carrito y realizar la compra
    When ordena los productos por "<sort>"
    And agrega los productos "<product1>" y "<product2>" al carrito
    And elimina el producto "<product1>" del carrito
    And realiza la compra con información "<first_name>", "<last_name>", "<postal_code>" y un total $"<price_total>"
    Then debería ver el mensaje de confirmación de pedido "<message>"

    Examples:
      | sort                      | product1                         | product2                   | first_name | last_name | postal_code | price_total | message                  |
      | Price (low to high)       | Sauce Labs Backpack              | Sauce Labs Bike Light      | John       | Doe       | 12345       |32.39        | THANK YOU FOR YOUR ORDER |
      | Name (A to Z)             | Sauce Labs Onesie                | Sauce Labs Bolt T-Shirt    | Maria      | Smith     | 67890       |32.39        | THANK YOU FOR YOUR ORDER |
      | Price (high to low)       | Test.allTheThings() T-Shirt (Red)| Sauce Labs Fleece Jacket   | Carlos     | Brown     | 11223       |32.39        | THANK YOU FOR YOUR ORDER |