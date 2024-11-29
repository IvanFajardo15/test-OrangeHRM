package screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import screenplay.ui.PaginaAdd;

public class RellenarFormulario implements Task {
    private final String firstName;
    private final String lastName;
    private final String email;

    public RellenarFormulario(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        Actions actions = new Actions(driver);
        actor.attemptsTo(
                Enter.theValue(firstName).into(PaginaAdd.CAMPO_FIRSTNAME),
                Enter.theValue(lastName).into(PaginaAdd.CAMPO_LASTNAME),
                Enter.theValue(email).into(PaginaAdd.CAMPO_EMAIL),
                Click.on(PaginaAdd.SELECT_VACANTE)
        );
        actions.sendKeys("p").sendKeys(Keys.ENTER).perform();

    }

    public static RellenarFormulario rellenarFormulario(String firstName, String lastName, String email) {
        return Tasks.instrumented(RellenarFormulario.class, firstName, lastName, email);
    }
}
