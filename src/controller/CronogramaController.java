package controller;

import javax.swing.*;
import java.util.Date;
import java.util.List;

/**
 * @author dany
 */
public class CronogramaController {

    public CronogramaController(){

    }

    public void generarCronograma(Date inicio, Date fin, List<JSpinner> listOfJSpinner, List<JSpinner> listOfJSpinner2){
        for (JSpinner date :listOfJSpinner) {
            System.out.println( "Date inicio: "+ (Date) date.getValue());
        }
    }
}
