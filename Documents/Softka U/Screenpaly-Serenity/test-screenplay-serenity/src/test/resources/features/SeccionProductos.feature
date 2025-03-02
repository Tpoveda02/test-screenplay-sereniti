Feature: Sección de Productos
  Yo como comprador de la tienda
  Quiero poder realizar la visualización de productos que venden en internet
  Para no tener que ir a la tienda física

  Scenario Outline: Ordenar productos de la A a la Z
    Given un usuario se encuentra en la página de inicio de sesión
    And se autentica con credenciales válidas
    When selecciona la opción de ordenar de la A a la Z
    Then el producto '<name>' se visualizará en la posición '<position>'
    Examples:
      | position  | name                    |
      | 1         | Sauce Labs Backpack     |
      | 2         | Sauce Labs Bike Light   |
      | 3         | Sauce Labs Bolt T-Shirt |

  Scenario Outline: Agregar producto al carrito
    Given un usuario se encuentra en la página de inicio de sesión
    And se autentica con credenciales válidas
    When agrega al carrito el producto '<product>'
    And se dirige al carriro de compras
    Then se visualizará el '<product>' en el carrito
    Examples:
      | product                 |
      | Sauce Labs Backpack     |
      | Sauce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |

  Scenario Outline: Remover un producto del carrito
    Given un usuario se encuentra en la página de inicio de sesión
    And se autentica con credenciales válidas
    When se dirige al carrito de compras
    And remueve el producto '<product>'
    Then no se visualizará el '<product>' en el carrito
    Examples:
      | product                 |
      | Sauce Labs Backpack     |
      | Sauce Labs Bolt T-Shirt |

  Scenario: Realizar la compra del carrito
    Given un usuario se encuentra en la página de inicio de sesión
    And se autentica con credenciales válidas
    When realiza el proceso de compra completando el formulario de envío
    Then se dirigirá a una página de confirmación
    And se visualizará un mensaje de compra exitosa