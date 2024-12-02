/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author Admin
 */
public class Finanzas {
    
   private String utileria;
   private int ingresos;
   private int egresos;

    public Finanzas(String utileria, int ingresos, int egresos) {
        this.utileria = utileria;
        this.ingresos = ingresos;
        this.egresos = egresos;
    }

    public String getUtileria() {
        return utileria;
    }

    public void setUtileria(String utileria) {
        this.utileria = utileria;
    }

    public int getIngresos() {
        return ingresos;
    }

    public void setIngresos(int ingresos) {
        this.ingresos = ingresos;
    }

    public int getEgresos() {
        return egresos;
    }

    public void setEgresos(int egresos) {
        this.egresos = egresos;
    }
   
   
    
}
