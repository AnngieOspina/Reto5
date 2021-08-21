package modelo.vo;

// l.ID_Lider, l.Salario, l.Ciudad_Residencia 

public class Requerimiento_1Vo {
    private Integer idLider;
    private Integer salario;
    private String ciudad;

    public Requerimiento_1Vo() {
    }

    public Integer getIdLider() {
        return idLider;
    }

    public void setIdLider(Integer idLider) {
        this.idLider = idLider;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return idLider + " " + salario + " " + ciudad;
    }

}
