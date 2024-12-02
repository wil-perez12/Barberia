/*]]
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


public class Admin extends Usuario implements Imetodos {

    public Admin(String nombre, String apellido, String correo, String telefono, String contrasena, String nivelAcceso) {
        super(nombre, apellido, correo, telefono, contrasena,nivelAcceso);
    }

    
    @Override
    public String getTipoUsuario(){
    
        return "admin";
    
    }

    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
