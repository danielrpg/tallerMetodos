package common;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author dany
 */

public class RandomTimeSeries {

    public RandomTimeSeries(){
    }

    private Integer getRandomObservation(Date inicio, Date fin){
        Integer fechaInicio = UIUtility.getInstance().getTimeToDate(inicio);
        Integer fechaFin = UIUtility.getInstance().getTimeToDate(fin);
        Integer newmilis= 0;
        /*try {

            //newmilis=new Double(ldesde+(Math.random()*randlimit)); //A la fecha de origen le sumamos el calculo aleatorio.
            newmilis = (int) (Math.random()*(limite) + fechaInicio);

        }catch (StackOverflowError stackOverflowError){
            System.out.println("Error: "+stackOverflowError);
        }*/
        newmilis = Integer.parseInt(generarNumHoraRandom(0, 24)+""+generarNumHoraRandom(0,60));
        if(newmilis > fechaInicio && newmilis < fechaFin){
            return newmilis;
        }else{
            return getRandomObservation(inicio, fin);
        }

    }

    private int generarNumHoraRandom(int init, int fin){
        int number = (int) (Math.random()*(fin) + init);
        return number;
    }

    public List<Integer> generarObservaciones(Date inicio, Date fin, List<JSpinner> noInicios, List<JSpinner> noFin, Integer numObservaciones){
        List<Integer> observaciones = new ArrayList<>();
        for (int i = 0; i < numObservaciones; i++){
            Integer fechaRamdon = generarFechaAleatoria(inicio, fin, noInicios, noFin);
            observaciones.add(fechaRamdon);
        }
        return observaciones;
    }

    public List<Integer> randomTimeSeries(Date inicio, Date fin, Integer numeroObservaciones){
        List<Integer> observaciones = new ArrayList<>();
        for (int i = 0; i < numeroObservaciones; i++){
            Integer fechaRamdon = getRandomObservation(inicio, fin);
            observaciones.add(fechaRamdon);
        }
        return observaciones;
    }

    private Integer generarFechaAleatoria(Date inicio, Date fin, List<JSpinner> noInicios, List<JSpinner> noFin){
        Integer ramdonFecha = getRandomObservation(inicio, fin);
        if(esValida(ramdonFecha, noInicios, noFin)){
            return ramdonFecha;
        }else{
            return generarFechaAleatoria(inicio, fin, noInicios, noFin);
        }
    }

    private Boolean esValida(Integer ramdonFecha, List<JSpinner> noInicios, List<JSpinner> noFin){
        Boolean res = false;
        if(noInicios.size() != 0 && noFin.size() != 0){
            for (JSpinner inicio: noInicios) {
                for (JSpinner fin : noFin){
                    String incioString = inicio.getValue().toString();
                    String finString = fin.getValue().toString();
                    Integer init = UIUtility.getInstance().getTimeToDate((Date)inicio.getValue());
                    Integer end = UIUtility.getInstance().getTimeToDate(((Date)fin.getValue()));
                    if(ramdonFecha < init && ramdonFecha > end){
                        res = true;
                    }
                }
            }
        }else{
            res = true;
        }

        return res;
    }

}