/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author Admin
 */
public class Cliente extends Usuario {

    public Cliente(String nombre, String apellido, String correo, String telefono, String contraseña, String nivelAcceso) {
        super(nombre, apellido, correo, telefono, contraseña, nivelAcceso);
    }

    // Método para agendar cita
    public void agendarCita() {
        System.out.println("Cita agendada por el cliente " + nombre);
    }

    @Override
    public String getTipoUsuario() {
        return "cliente";
    }
}

