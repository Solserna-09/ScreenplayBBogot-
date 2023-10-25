package com.demo.guru99.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

public class EsperaImplicita implements Interaction {

    private int segundos;

    public EsperaImplicita(int segundos) {
        this.segundos = segundos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(segundos*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static Performable enSegundos(int segundos){
        return Instrumented.instanceOf(EsperaImplicita.class).withProperties(segundos);
    }
}
