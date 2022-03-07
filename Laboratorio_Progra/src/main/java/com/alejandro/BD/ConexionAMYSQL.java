/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejandro.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author COREI5 10TH GEN
 */
public class ConexionAMYSQL {
     private static Connection ConnectionDB = null;
    public Connection getConection() {

        try {
            String url = "jdbc:mysql://localhost:3306/lab";
            String user = "Nuñez";
            String password = "Alexxkr2120sv";

            ConnectionDB = DriverManager.getConnection(url, user, password);
            
            System.out.println("Conexion Establecida");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());
        }
        
        
        
        return ConnectionDB;

    }
}
