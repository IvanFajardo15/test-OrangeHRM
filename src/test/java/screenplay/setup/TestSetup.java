package screenplay.setup;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSetup {
    @Managed
    protected WebDriver driver = new ChromeDriver();
    protected Actor usuario = Actor.named("Usuario");

    public void configurarActor() {
        usuario.can(BrowseTheWeb.with(driver));
    }

    public WebDriver getDriver() {
        return driver;
    }
}
