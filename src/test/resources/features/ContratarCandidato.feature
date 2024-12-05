Feature: Inicio de Sesion
  
  @Regression
  Scenario: Iniciar sesion en la pagina de OrangeHRM
    Given Ingreso a la pagina OrangeHRM
    When Ingreso el username "Admin", el password "admin123" y doy click en el botón login
    And Ingreso a la opción de recruitment
    And Registro candidato con nombre "Roberto" apellido "Bolanos" y correo "rbolanos@yopmail.com"
    And Realizo proceso de contratacion
    Then El sistema verifica que se haya registrado el candidato