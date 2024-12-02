public class Empleado extends Usuario {

    private String rango;
    private String horario;

    public Empleado(String nombre, String apellido, String correo, String telefono, String contraseña, String rango, String horario) {
        super(nombre, apellido, correo, telefono, contraseña, "Empleado");
        this.rango = rango;
        this.horario = horario;
    }

    
    public void setRango(String rango) {
        this.rango = rango;
    }
 
    public String getRango() {
        return rango ;
    }

  


    public void setHorario(String horario){

        this.horario=horario;
        
        
        }
        

public String getHorario(){

return horario;


}



}
