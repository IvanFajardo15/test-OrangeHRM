package screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.annotations.Subject;
import screenplay.ui.PaginaDeLogin;

public class IniciarSesion implements Task {
    private final String username;
    private final String password;

    public IniciarSesion(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    @Subject("Iniciar sesión con el usuario #usuario")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(PaginaDeLogin.CAMPO_USERNAME),
                Enter.theValue(password).into(PaginaDeLogin.CAMPO_PASSWORD),
                Click.on(PaginaDeLogin.BOTON_LOGIN)
        );
    }

    public static IniciarSesion conCredenciales(String username, String password) {
        return Tasks.instrumented(IniciarSesion.class, username, password);
    }
}
