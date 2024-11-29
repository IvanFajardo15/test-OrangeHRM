package tests;

import net.serenitybdd.screenplay.actions.Open;
import org.junit.Before;
import org.junit.Test;
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

public class RegistrarPersona extends TestSetup {
    @Before
    public void configurarEscenario() {
        configurarActor();
        usuario.attemptsTo(Open.url("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"),
                VerificarElemento.buscarElemento(PaginaDeLogin.CAMPO_USERNAME));
    }

    @Test
    public void RegistrarUsuario() {
        usuario.attemptsTo(
                IniciarSesion.conCredenciales("Admin", "admin123"),
                VerificarElemento.buscarElemento(PaginaLogeada.TITULO),
                ClickearBoton.darClick(PaginaLogeada.RECRUITMENT),
                VerificarElemento.buscarElemento(PaginaRecruitment.BOTON_ADD),
                ClickearBoton.darClick(PaginaRecruitment.BOTON_ADD),
                VerificarElemento.buscarElemento(PaginaAdd.CAMPO_EMAIL),
                RellenarFormulario.rellenarFormulario("Ivan", "Prueba", "iafajardo@gmail.com"),
                VerificarElemento.buscarElemento(PaginaAplicacion.BOTON_SAVE),
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

        boolean registroHired = PaginaRecruitment.REGISTRO_HIRED.isVisibleFor(usuario);
        Assertions.assertTrue(registroHired, "El usuario no se muestra en la tabla");
    }
}

