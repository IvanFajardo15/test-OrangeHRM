package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import org.junit.jupiter.api.Assertions;
import screenplay.setup.TestSetup;
import screenplay.tasks.ClickearBoton;
import screenplay.tasks.IniciarSesion;
import screenplay.tasks.RellenarFormulario;
import screenplay.tasks.ScheduleInterview;
import screenplay.tasks.VerificarElemento;
import screenplay.ui.PaginaAdd;
import screenplay.ui.PaginaAplicacion;
import screenplay.ui.PaginaDeLogin;
import screenplay.ui.PaginaLogeada;
import screenplay.ui.PaginaRecruitment;
import screenplay.ui.PaginaScheduleInterview;

public class ContratarCandidatoStepDefinition extends TestSetup {
    private String nombre;
    private String apellido;
    private String email;

    @Given("Ingreso a la pagina OrangeHRM")
    public void ingresoALaPaginaOrangeHRM() {
        configurarActor();
        usuario.attemptsTo(Open.url("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"),
                VerificarElemento.buscarElemento(PaginaDeLogin.CAMPO_USERNAME));
    }

    @When("Ingreso el username {string}, el password {string} y doy click en el botón login")
    public void ingresoCredenciales(String username, String password) {
        usuario.attemptsTo(
                IniciarSesion.conCredenciales(username, password),
                VerificarElemento.buscarElemento(PaginaLogeada.TITULO)
        );
    }

    @And("Ingreso a la opción de recruitment")
    public void ingresarOpcionRecruitment() {
        usuario.attemptsTo(
                ClickearBoton.darClick(PaginaLogeada.RECRUITMENT),
                VerificarElemento.buscarElemento(PaginaRecruitment.BOTON_ADD)
        );
    }

    @And("Registro candidato con nombre {string} apellido {string} y correo {string}")
    public void registrarCandidato(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;

        usuario.attemptsTo(
                ClickearBoton.darClick(PaginaRecruitment.BOTON_ADD),
                VerificarElemento.buscarElemento(PaginaAdd.CAMPO_EMAIL),
                RellenarFormulario.rellenarFormulario(nombre, apellido, email),
                VerificarElemento.buscarElemento(PaginaAplicacion.BOTON_SAVE)
        );
    }

    @And("Realizo proceso de contratacion")
    public void realizoProcesoDeContratacion() {
        usuario.attemptsTo(
                ClickearBoton.darClick(PaginaAplicacion.BOTON_SAVE),
                VerificarElemento.buscarElemento(PaginaAplicacion.BOTON_SHORTLIST),
                ClickearBoton.darClick(PaginaAplicacion.BOTON_SHORTLIST),
                ClickearBoton.darClick(PaginaAplicacion.BOTON_SAVE),
                VerificarElemento.buscarElemento(PaginaAplicacion.BOTON_SCHEDULE),
                ClickearBoton.darClick(PaginaAplicacion.BOTON_SCHEDULE),
                VerificarElemento.buscarElemento(PaginaScheduleInterview.BOTON_SAVE),
                ClickearBoton.darClick(PaginaScheduleInterview.BOTON_SAVE),
                ScheduleInterview.llenarFormulario("Prueba", "2024-25-11"),
                ClickearBoton.darClick(PaginaScheduleInterview.BOTON_SAVE),
                ClickearBoton.darClick(PaginaAplicacion.BOTON_SHORTLIST),
                ClickearBoton.darClick(PaginaScheduleInterview.BOTON_SAVE),
                ClickearBoton.darClick(PaginaAplicacion.BOTON_OFFER),
                ClickearBoton.darClick(PaginaScheduleInterview.BOTON_SAVE),
                ClickearBoton.darClick(PaginaAplicacion.BOTON_SHORTLIST),
                ClickearBoton.darClick(PaginaScheduleInterview.BOTON_SAVE),
                ClickearBoton.darClick(PaginaLogeada.RECRUITMENT),
                VerificarElemento.buscarElemento(PaginaRecruitment.REGISTRO_HIRED)
        );
    }

    @Then("El sistema verifica que se haya registrado el candidato")
    public void verificoCandidatoHired() {
        boolean registroHired = PaginaRecruitment.REGISTRO_HIRED.isVisibleFor(usuario);
        Assertions.assertTrue(registroHired, "El usuario no se muestra en la tabla");
    }
}
