package common;
import java.util.Date;
import java.util.List;

/**
 * @author dany
 */

public class RandomTimeSeries {

    public RandomTimeSeries(){
    }

    private Date getRandomObservation(Date inicio, Date fin, Date periodoInicio, Date PeriodoFin){
        long ldesde=inicio.getTime();
        long lhasta=fin.getTime();
        long randlimit=lhasta-ldesde;
        Double newmilis=new Double(ldesde+(Math.random()*randlimit)); //A la fecha de origen le sumamos el calculo aleatorio.
        Date randomDate=new Date(newmilis.longValue());
        return randomDate;
    }
}