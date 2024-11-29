package screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import screenplay.ui.PaginaLogeada;

public class ClickearRecruitment implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaLogeada.RECRUITMENT)
        );
    }

    public static ClickearRecruitment accederRecruitment() {
        return new ClickearRecruitment();
    }

}
