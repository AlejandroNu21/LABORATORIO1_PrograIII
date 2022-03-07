/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Persona;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author COREI5 10TH GEN
 */
public class Personas {
    
    ConexionAMYSQL con = new ConexionAMYSQL();
    Connection conexion = con.getConecction();

    public ArrayList<Persona> ListaPersonas() {
        ArrayList<Persona> listado = null;

        ConexionAMYSQL con = new ConexionAMYSQL();
        Connection conexion = con.getConecction();

        try {
            listado = new ArrayList<Persona>();
            CallableStatement cb = conexion.prepareCall("select * from contactos");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {
                Persona cc = new Persona();
                cc.setId(resultado.getInt("Id"));
                cc.setNombre(resultado.getString("Nombre"));
                cc.setEdad(resultado.getInt("Edad"));
                cc.setEmail(resultado.getString("Email"));
                cc.setNumeroDeTelefono(resultado.getString("NumeroDeTelefono"));

                listado.add(cc);
            }

        } catch (Exception e) {
        }
        return listado;
    }

    public void AddPersona(Persona es) {
        ConexionAMYSQL con = new ConexionAMYSQL();
        Connection conexion = con.getConecction();
        try {

            CallableStatement cb = conexion.prepareCall("insert into "
                    + "contactos(Nombre,Edad,Email,NumeroDeTelefono) values('" + es.getNombre() + "', '" + es.getEdad() + "','" + es.getEmail() + "', '" + es.getNumeroDeTelefono() + "')");
            cb.execute();

            JOptionPane.showMessageDialog(null, "Persona Agregada");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error" + ex);
        }
    }

    public void UpdatePersona(Persona es) {
        ConexionAMYSQL con = new ConexionAMYSQL();
        Connection conexion = con.getConecction();
        try {
            CallableStatement cb = conexion.prepareCall("update contactos set Nombre=?, Edad=?, Email=?, NumeroDeTelefono=? where Id=?");
            cb.setString(1, es.getNombre());
            cb.setInt(2, es.getEdad());
            cb.setString(3, es.getEmail());
            cb.setString(4, es.getNumeroDeTelefono());
            cb.setInt(5, es.getId());
            cb.execute();

            JOptionPane.showMessageDialog(null, "Actualizado");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error" + ex);
        }
    }

    public ArrayList<Persona> ListaPersona() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static class ConexionAMYSQL {

        public ConexionAMYSQL() {
        }

        private Connection getConecction() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
 
}
