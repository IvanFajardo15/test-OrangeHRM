package screenplay.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class VerificarElemento {
    public static Task buscarElemento(Target elemento) {
        return Task.where("Espera a que el elemento este visible",
                WaitUntil.the(elemento, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds());
    }
}
