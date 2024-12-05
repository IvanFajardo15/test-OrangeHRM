package screenplay.ui;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaAdd {
    public static final Target CAMPO_FIRSTNAME = Target.the("Campo de primer nombre")
            .located(By.name("firstName"));

    public static final Target CAMPO_LASTNAME = Target.the("Campo de apellido")
            .located(By.name("lastName"));

    public static final Target CAMPO_EMAIL = Target.the("Campo de correo electrónico")
            .located(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));

    public static final Target SELECT_VACANTE = Target.the("Desplegable de vacantes")
            .located(By.className("oxd-select-text-input"));

    public static Target OPCION_DESPLEGABLE(String opcion) {
        return Target.the("Opción en el desplegable")
                .located(By.xpath("//div[contains(@class, 'oxd-select-option') and text()='" + opcion + "']"));
    }

    public static final Target BOTON_SAVE = Target.the("Boton de guardar formulario")
            .located(By.className("oxd-button--secondary"));
}
