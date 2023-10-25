
  Feature: Login de usuario

    Scenario: Login de usuario exitoso
      Given que el usuario se encuentre en la pagina web
      When ingrese el usuario con la clave
      Then el usuario visualizara un mensaje de login exitoso