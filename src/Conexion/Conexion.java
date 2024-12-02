/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class Conexion {
   private String db = "barberia" ;
   private String url ="jdbc:mysql://localhost:3306/";
   private String user = "root";
   private String password = "";
   private String driver="com.mysql.cj.jdbc.Driver";
   Connection cn = null;

    //metodo para conectar a la base de datos
    public Connection conectar(){
    
        try {
            Class .forName(driver);
            cn = DriverManager.getConnection(url+db,user,password);     
             System.out.println("Conexion establecida exitosamente.");    
        } catch (ClassNotFoundException e) {       
            System.out.println("Error con el driver");
            
        }catch (SQLException e) {       
            System.out.println("Error al conectar la base de datos");
        }
        return cn;
    }
    
    
    //metodo para desconectar la base de datos
     public Connection desconectar(){
    
        try {
          cn.close();
        }catch (SQLException e) {       
            System.out.println("Error al desconectar la base de datos");
        }
        return cn;
    }
    
    
    
    public static void main(String[] args) {
        Conexion cx = new Conexion();
        cx.conectar();
    }
    
   
}

