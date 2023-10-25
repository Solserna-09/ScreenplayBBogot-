package com.demo.guru99.tasks;

import com.demo.guru99.interactions.EsperaImplicita;
import com.demo.guru99.utils.Excel;
import net.serenitybdd.screenplay.Action;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.awt.event.KeyEvent;
import java.io.IOException;

import static com.demo.guru99.userInterface.PaginaInicioUI.*;
import static com.demo.guru99.userInterface.VueloUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class Vuelo implements Task {
    Excel excel = new Excel();



    @Override
    public <T extends Actor> void performAs(T actor) {
        WaitUntil.the(BTN_VUELOS, isClickable()).forNoMoreThan(10).seconds();
        try {
            actor.attemptsTo(
                    Click.on(BTN_VUELOS),
                    WaitUntil.the(RDO_TIPO_VUELOS, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(RDO_TIPO_VUELOS),
                  //  Scroll.to(BTN_CONTINUAR),
                   // EsperaImplicita.enSegundos(5),
                    SelectFromOptions.byVisibleText(excel.leerDatosExcel("Data.xlsx", "Vuelo", 1, 0)).from(LST_PASAJEROS),
                    SelectFromOptions.byVisibleText(excel.leerDatosExcel("Data.xlsx", "Vuelo", 1, 1)).from(LST_PARTIDA),
                    SelectFromOptions.byVisibleText(excel.leerDatosExcel("Data.xlsx", "Vuelo", 1, 2)).from(LST_MES_IDA),
                    SelectFromOptions.byVisibleText(excel.leerDatosExcel("Data.xlsx", "Vuelo", 1, 3)).from(LST_DIA_IDA),
                    SelectFromOptions.byVisibleText(excel.leerDatosExcel("Data.xlsx", "Vuelo", 1, 4)).from(LST_LLEGADA),
                    SelectFromOptions.byVisibleText(excel.leerDatosExcel("Data.xlsx", "Vuelo", 1, 5)).from(LST_MES_VUELTA),
                    SelectFromOptions.byVisibleText(excel.leerDatosExcel("Data.xlsx", "Vuelo", 1, 6)).from(LST_DIA_VUELTA),
                    Click.on(RDO_TIPO_VUELOS),
                    SelectFromOptions.byVisibleText(excel.leerDatosExcel("Data.xlsx","Vuelo",1,7)).from(LST_AEROLINEA),
                    Click.on(BTN_CONTINUAR)


            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Vuelo datosVuelo() {
        return instrumented(Vuelo.class);
    }
}
