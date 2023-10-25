package com.demo.guru99.tasks;

import com.demo.guru99.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.Switch;

import java.io.IOException;

import static com.demo.guru99.userInterface.PaginaInicioUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {

    Excel excel = new Excel();

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Enter.theValue(excel.leerDatosExcel("Data.xlsx", "Login", 1, 0)).into(TXT_USUARIO),
                    Enter.theValue("Beta.123").into(TXT_CLAVE),
                    Click.on(BTN_INGRESAR)
            );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Login iniciar() {
        return instrumented(Login.class);
    }

}
