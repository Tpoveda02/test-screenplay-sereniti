Feature: Ordenar productos y realizar una compra en Swag Labs

  Background:
    Given un usuario se ingresó a la página de login


  Scenario Outline: Ordenar productos, agregar al carrito y realizar la compra
    When ingresa sus credenciales válidas: usuario "standard_user" y contraseña "secret_sauce"
    And ordena los productos por "<sort>"
    And agrega los productos "<product1>" y "<product2>" al carrito
    And elimina el producto "<product1>" del carrito
    And realiza la compra con información "<first_name>", "<last_name>", "<postal_code>" y un total $"<price_total>"
    Then debería ver el mensaje de confirmación de pedido "THANK YOU FOR YOUR ORDER "

    Examples:
      | sort                      | product1                         | product2                   | first_name | last_name | postal_code | price_total |
      | Price (low to high)       | Sauce Labs Backpack              | Sauce Labs Bike Light      | John       | Doe       | 12345       | 10.79       |
      | Name (A to Z)             | Sauce Labs Onesie                | Sauce Labs Bolt T-Shirt    | Maria      | Smith     | 67890       | 17.27       |
      | Price (high to low)       | Test.allTheThings() T-Shirt (Red)| Sauce Labs Fleece Jacket   | Carlos     | Brown     | 11223       | 53.99       |

  Scenario: Usuario bloqueado
    When ingresa credenciales bloqueadas: usuario "locked_out_user" y contraseña "secret_sauce"
    Then debería mostrarse el mensaje de error "Epic sadface: Sorry, this user has been locked out."
