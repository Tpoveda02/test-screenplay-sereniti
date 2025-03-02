Feature: Login de Usuario
  Yo como comprador de la tienda
  Quiero poder loguearme a la plataforma
  Para realizar comprar a través de internet.

  Scenario: Abrir inicio de sesión
    Given un usuario se encuentra en la página de login
    When ingresa sus credenciales válidas
    Then debería ser redirigido a la página de productos
