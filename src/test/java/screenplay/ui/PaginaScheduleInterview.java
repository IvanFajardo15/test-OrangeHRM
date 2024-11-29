package screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaScheduleInterview {

    public static final Target TITLE = Target.the("Campo de texto de titulo de la entrevista")
            .located(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]"));

    public static final Target INTERVIEWER = Target.the("Campo de texto de interviewer")
            .located(By.cssSelector("[placeholder='Type for hints...'"));

    public static final Target FECHA = Target.the("Fecha de registro")
            .located(By.cssSelector("[placeHolder='yyyy-dd-mm']"));

    public static final Target BOTON_SAVE = Target.the("Botón de guardar")
            .located(By.xpath("//button[text()=' Save ']"));

}
