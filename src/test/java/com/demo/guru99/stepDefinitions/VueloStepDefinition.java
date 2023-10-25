package com.demo.guru99.stepDefinitions;

import com.demo.guru99.questions.ValidacionLogin;
import com.demo.guru99.questions.ValidacionVuelo;
import com.demo.guru99.tasks.Vuelo;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class VueloStepDefinition {


    @Before
    public void configuracion() {
        setTheStage(new OnlineCast());
    }


    @When("el usuario cambie los datos del vuelo")
    public void elUsuarioCambieLosDatosDelVuelo() {
       theActorCalled("test").wasAbleTo(Open.url("https://demo.guru99.com/test/newtours/index.php"));
       OnStage.theActorInTheSpotlight().attemptsTo(Vuelo.datosVuelo());



    }

    @Then("el visualizara un mensaaje de no hay asientos de vuelo")
    public void elVisualizaraUnMensaajeDeNoHayAsientosDeVuelo() {
        OnStage.theActorInTheSpotlight().should(seeThat("el puede ver el mensaje", ValidacionVuelo.validarVuelo(), Matchers.equalTo(true)));

    }
}
