package screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaRecruitment {
    public static final Target BOTON_ADD = Target.the("Botón de añadir")
            .located(By.xpath("//button[text()=' Add ']"));

    public static final Target REGISTRO_HIRED = Target.the("Registro contratado en la tabla")
            .located(By.xpath("//div[@class = 'oxd-table-body']" +
                    "//div[@class='oxd-table-card' and " +
                    "contains(., 'Roberto  Bolanos') and " +
                    "contains(., 'Payroll Administrator') and " +
                    "contains(., 'Hired')]"));
}
