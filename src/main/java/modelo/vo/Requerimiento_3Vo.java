package modelo.vo;


public class Requerimiento_3Vo {
    private Integer clasificacion;
    private Double promedio;

    public Requerimiento_3Vo() {
    }

    public Integer getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Integer clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return clasificacion + " " + Math.round(promedio);
    }

}
