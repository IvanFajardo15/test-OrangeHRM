package screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaDeLogin {
    public static final Target CAMPO_USERNAME = Target.the("Campo de usuario")
            .located(By.name("username"));

    public static final Target CAMPO_PASSWORD = Target.the("Campo de password")
            .located(By.name("password"));

    public static final Target BOTON_LOGIN = Target.the("Botón de inicio de sesión")
            .located(By.className("oxd-button"));
}
