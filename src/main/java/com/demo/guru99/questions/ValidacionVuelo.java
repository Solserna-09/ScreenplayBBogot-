package com.demo.guru99.questions;

import com.demo.guru99.userInterface.ConfirmacionReservacionUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidacionVuelo implements Question {

    @Override
    public Boolean answeredBy(Actor actor) {
        return ConfirmacionReservacionUI.MSJ_CONFIRMACION_VUELO.resolveFor(actor).isVisible();
    }

    public static Question validarVuelo(){
        return new ValidacionVuelo();
    }
}
