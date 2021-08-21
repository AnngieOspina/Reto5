package modelo.vo;

//p.ID_Proyecto, mc.Nombre_Material, mc.Precio_Unidad 
public class Requerimiento_2Vo {
    private Integer idProyecto;
    private String material;
    private Integer precioUnidad;

    public Requerimiento_2Vo() {
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    
    public Integer getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(Integer precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    @Override
    public String toString() {
        return idProyecto + " " + material + " " + precioUnidad;
    }

}
