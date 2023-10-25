package com.demo.guru99.stepDefinitions;

import com.demo.guru99.questions.ValidacionLogin;
import com.demo.guru99.tasks.Login;
import com.demo.guru99.userInterface.PaginaInicioUI;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class LoginStepDefinition {

    @Managed(driver = "firefox")
    private WebDriver navegador;
    private Actor sol = Actor.named("sol");

    private PaginaInicioUI paginaInicioUI= new PaginaInicioUI();

    @Before
    public void configuracion (){
        sol.can(BrowseTheWeb.with(navegador));
    }

    @Given("que el usuario se encuentre en la pagina web")
    public void queElUsuarioSeEncuentreEnLaPaginaWeb() {
        sol.wasAbleTo(Open.url("https://demo.guru99.com/test/newtours/index.php"));
    }
    @When("ingrese el usuario con la clave")
    public void ingreseElUsuarioConLaClave() {
        sol.attemptsTo(Login.iniciar());
    }
    @Then("el usuario visualizara un mensaje de login exitoso")
    public void elUsuarioVisualizaraUnMensajeDeLoginExitoso() {
        sol.should(seeThat("el actor puede ver",ValidacionLogin.validarLogin(),Matchers.equalTo(true)));


    }




}
