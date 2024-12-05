package screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaLogeada {
    public static final Target TITULO = Target.the("Titulo de la pantalla principal")
            .located(By.className("oxd-text--h6"));

    public static final Target RECRUITMENT = Target.the("Opción de recruitment")
            .located(By.cssSelector("[href = '/web/index.php/recruitment/viewRecruitmentModule']"));
}
