package common;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        Double newmilis=new Double(ldesde+(Math.random()*randlimit)); //A la fecha de origen le sumamos el calculo aleatorio.
        Date randomDate=new Date(newmilis.longValue());
        return randomDate;
    }

    public List<Date> generarObservaciones(Date inicio, Date fin, List<Date> noInicios, List<Date> noFin, Integer numObservaciones){
        List<Date> observaciones = new ArrayList<>();
        for (int i = 0; i < numObservaciones; i++){
            Date fechaRamdon = generarFechaAleatoria(inicio, fin, noInicios, noFin);
            observaciones.add(fechaRamdon);
        }
        return observaciones;
    }

    private Date generarFechaAleatoria(Date inicio, Date fin, List<Date> noInicios, List<Date> noFin){
        Date ramdonFecha = getRandomObservation(inicio, fin);
        if(esValida(ramdonFecha, noInicios, noFin)){
            return ramdonFecha;
        }else{
            return generarFechaAleatoria(inicio, fin, noInicios, noFin);
        }
    }

    private Boolean esValida(Date ramdonFecha, List<Date> noInicios, List<Date> noFin){
        Boolean res = false;
        for (Date inicio: noInicios) {
            for (Date fin : noFin){
                if(ramdonFecha.before(inicio) || ramdonFecha.after(fin)){
                    res = true;
                }
            }
        }
        return res;
    }

}