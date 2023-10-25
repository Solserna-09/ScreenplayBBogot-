package com.demo.guru99.questions;

import com.demo.guru99.userInterface.PaginaUsuarioUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidacionLogin implements Question {

    @Override
    public Boolean answeredBy(Actor actor) {
        return PaginaUsuarioUI.MSJ_LOGIN.resolveFor(actor).isVisible();
    }

    public static Question validarLogin(){
        return new ValidacionLogin();
    }
}
