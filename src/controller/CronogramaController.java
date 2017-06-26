package controller;

import common.RandomTimeSeries;
import model.ObservacionModel;
import uinterface.ObservacionTable;

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
    private ObservacionTable observacionTable;

    private JLabel analista, estacion;

    public CronogramaController(){
        randomTimeSeries = new RandomTimeSeries();
    }

    public void generarCronograma(Date inicio, Date fin, List<JSpinner> listOfJSpinner, List<JSpinner> listOfJSpinner2, Integer numObservaciones){
        List<Integer> dateObservaciones = randomTimeSeries.generarObservaciones(inicio, fin, listOfJSpinner, listOfJSpinner2, numObservaciones);
        this.observacionTable.clearDataTableModel();
        Collections.sort(dateObservaciones);
        int index = 1;
        for (Integer fecha: dateObservaciones) {
            System.out.println("Fecha: "+ fecha);
            //System.out.println("La hora generada: "+fecha.getHours()+":"+fecha.getMinutes());
         /*   String hora = fecha.getHours()+":"+fecha.getMinutes();
            this.observacionTable.addRow(new ObservacionModel(index, hora, "", ""));*/
            index++;
        }
    }

    public void generarCronograma(Date inicio, Date fin, Integer numeroObservaciones){
        List<Integer> dateObservaciones = randomTimeSeries.randomTimeSeries(inicio, fin, numeroObservaciones);
        this.observacionTable.clearDataTableModel();
        Collections.sort(dateObservaciones);
        int index = 1;
        for (Integer fecha: dateObservaciones) {
            System.out.println("Fecha: "+ fecha);
            //System.out.println("La hora generada: "+fecha.getHours()+":"+fecha.getMinutes());
            /*String hora = fecha.getHours()+":"+fecha.getMinutes();
            this.observacionTable.addRow(new ObservacionModel(index, hora, "", ""));*/
            index++;
        }
    }

    public void setDatosCabecera(String nomAnalista, String nomEstacion){
        this.analista.setText(nomAnalista);
        this.estacion.setText(nomEstacion);
    }

    public void setCamposCabecera(JLabel analista, JLabel estacion){
        this.analista = analista;
        this.estacion = estacion;
    }

    public void setObservacionTabla(ObservacionTable observacionTabla){
        this.observacionTable = observacionTabla;
    }
}
