package screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.annotations.Subject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import screenplay.ui.PaginaScheduleInterview;

public class ScheduleInterview implements Task {
    private final String title;
    private final String fecha;

    public ScheduleInterview(String title, String fecha) {
        this.title = title;
        this.fecha = fecha;
    }

    @Override
    @Subject("Llenar el formulario de schedule interview")
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        Actions actions = new Actions(driver);
        actor.attemptsTo(
                Enter.theValue(title).into(PaginaScheduleInterview.TITLE)
        );
        actions.pause(1000);
        actor.attemptsTo(
                Enter.theValue(fecha).into(PaginaScheduleInterview.FECHA),
                Click.on(PaginaScheduleInterview.INTERVIEWER)
        );
        actions.sendKeys("a").pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    public static ScheduleInterview llenarFormulario(String title, String fecha) {
        return Tasks.instrumented(ScheduleInterview.class, title, fecha);
    }
}
