package model;

/**
 * @author dany
 */
public class ObservacionModel {

    private Integer observacion;
    private String hora;
    private String parada;
    private String functionando;

    public ObservacionModel(Integer observacion, String hora, String parada, String functionando) {
        this.observacion = observacion;
        this.hora = hora;
        this.parada = parada;
        this.functionando = functionando;
    }

    public Integer getObservacion() {
        return observacion;
    }

    public void setObservacion(Integer observacion) {
        this.observacion = observacion;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getParada() {
        return parada;
    }

    public void setParada(String parada) {
        this.parada = parada;
    }

    public String getFunctionando() {
        return functionando;
    }

    public void setFunctionando(String functionando) {
        this.functionando = functionando;
    }
}
