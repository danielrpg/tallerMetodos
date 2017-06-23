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

    private Date getRandomObservation(Date inicio, Date fin){
        long ldesde=inicio.getTime();
        long lhasta=fin.getTime();
        long randlimit=lhasta-ldesde;
       // Random random = new Random(System.currentTimeMillis());
        Double newmilis=new Double(ldesde+(Math.random()*randlimit)); //A la fecha de origen le sumamos el calculo aleatorio.
       // Double newmilis=new Double(ldesde+( random.nextDouble()*randlimit));
        Date randomDate=new Date(newmilis.longValue());
        return randomDate;
    }

    public List<Date> generarObservaciones(Date inicio, Date fin, List<JSpinner> noInicios, List<JSpinner> noFin, Integer numObservaciones){
        List<Date> observaciones = new ArrayList<>();
        for (int i = 0; i < numObservaciones; i++){
            Date fechaRamdon = generarFechaAleatoria(inicio, fin, noInicios, noFin);
            observaciones.add(fechaRamdon);
        }
        return observaciones;
    }

    public List<Date> randomTimeSeries(Date inicio, Date fin, Integer numeroObservaciones){
        List<Date> observaciones = new ArrayList<>();
        for (int i = 0; i < numeroObservaciones; i++){
            Date fechaRamdon = getRandomObservation(inicio, fin);
            observaciones.add(fechaRamdon);
        }
        return observaciones;
    }

    private Date generarFechaAleatoria(Date inicio, Date fin, List<JSpinner> noInicios, List<JSpinner> noFin){
        Date ramdonFecha = getRandomObservation(inicio, fin);
        if(esValida(ramdonFecha, noInicios, noFin)){
            return ramdonFecha;
        }else{
            return generarFechaAleatoria(inicio, fin, noInicios, noFin);
        }
    }

    private Boolean esValida(Date ramdonFecha, List<JSpinner> noInicios, List<JSpinner> noFin){
        Boolean res = false;
        for (JSpinner inicio: noInicios) {
            for (JSpinner fin : noFin){
                if(ramdonFecha.before((Date)inicio.getValue()) && ramdonFecha.after((Date)fin.getValue())){
                    res = true;
                }
            }
        }
        return res;
    }

}