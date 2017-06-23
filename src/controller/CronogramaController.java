package controller;

import common.RandomTimeSeries;

import javax.swing.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author dany
 */
public class CronogramaController {

    private RandomTimeSeries randomTimeSeries;

    public CronogramaController(){
        randomTimeSeries = new RandomTimeSeries();
    }

    public void generarCronograma(Date inicio, Date fin, List<JSpinner> listOfJSpinner, List<JSpinner> listOfJSpinner2, Integer numObservaciones){
        List<Date> dateObservaciones = randomTimeSeries.generarObservaciones(inicio, fin, listOfJSpinner, listOfJSpinner2, numObservaciones);

        Collections.sort(dateObservaciones);
        for (Date fecha: dateObservaciones) {
            System.out.println("La hora generada: "+fecha.getHours()+":"+fecha.getMinutes());
        }
    }

    public void generarCronograma(Date inicio, Date fin, Integer numeroObservaciones){
        List<Date> dateObservaciones = randomTimeSeries.randomTimeSeries(inicio, fin, numeroObservaciones);
        Collections.sort(dateObservaciones);
        for (Date fecha: dateObservaciones) {
            System.out.println("La hora generada: "+fecha.getHours()+":"+fecha.getMinutes());
        }
    }
}
