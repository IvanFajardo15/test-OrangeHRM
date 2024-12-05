package screenplay.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class ClickearBoton {
    public static Task darClick(Target elemento) {
        return Task.where("Da click al elemento cuando este habilitado",
                Click.on(elemento).afterWaitingUntilEnabled());
    }
}
