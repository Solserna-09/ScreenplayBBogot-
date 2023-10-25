package com.demo.guru99.userInterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class VueloUI {

    public static final Target RDO_TIPO_VUELOS = Target.the("").located(By.xpath("//input[@value='oneway']"));
    public static final Target LST_PASAJEROS = Target.the("").located(By.xpath("//select[@name='passCount']"));
    public static final Target LST_PARTIDA = Target.the("").located(By.xpath("//select[@name='fromPort']"));
    public static final Target LST_MES_IDA = Target.the("").located(By.xpath("//select[@name='fromMonth']"));
    public static final Target LST_DIA_IDA = Target.the("").located(By.xpath("//select[@name='fromDay']"));
    public static final Target LST_LLEGADA = Target.the("").located(By.xpath("//select[@name='toPort']"));
    public static final Target LST_MES_VUELTA = Target.the("").located(By.xpath("//select[@name='toMonth']"));
    public static final Target LST_DIA_VUELTA = Target.the("").located(By.xpath("//select[@name='toDay']"));
    public static final Target RDB_CLASE_VUELO = Target.the("").located(By.xpath("//input[@value='Business']"));
    public static final Target LST_AEROLINEA = Target.the("").located(By.xpath("//select[@name='airline']"));
    public static final Target BTN_CONTINUAR = Target.the("").located(By.xpath("//input[@name='findFlights']"));

}
