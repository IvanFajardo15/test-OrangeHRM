package screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaAplicacion {
    public static final Target BOTON_SHORTLIST = Target.the("Boton de ShortList")
            .located(By.className("oxd-button--success"));

    public static final Target BOTON_SAVE = Target.the("Boton de guardar")
            .located(By.className("orangehrm-left-space"));

    public static final Target BOTON_SCHEDULE = Target.the("Boton de schedule")
            .located(By.xpath("//button[text()=' Schedule Interview ']"));

    public static final Target BOTON_OFFER = Target.the("Boton de OFFER JOB")
            .located(By.xpath("//button[text()=' Offer Job ']"));
}
