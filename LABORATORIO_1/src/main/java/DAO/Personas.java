/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Persona;
import com.alejandro.BD.ConexionAMYSQL;
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
       
    public ArrayList <Persona> ListadoPersonas (){
         ArrayList<Persona> listado = null;
       
        
        try {
           listado  = new ArrayList<Persona>();

           
           CallableStatement cb = conexion.prepareCall("select * from Contactos");
           ResultSet resultado = cb.executeQuery();
           
           
           while (resultado.next()){
               //Llamar a el objeto de Entidad
               Persona es = new Persona ();
             
               es.setNombre(resultado.getString("Nombre"));
               es.setEdad(resultado.getString("Edad"));
               es.setEmail(resultado.getString("Email"));
               es.setNumeroDeTelefono(resultado.getString("NumeroDeTelefono"));
               listado.add(es);
               
           }
           
           
   
        }catch (Exception e){
            System.out.println(e.toString());
        }
        
         return listado; 
    }
    
     public void AddPersonas(Persona es){
          try {
              CallableStatement cb = conexion.prepareCall("insert into "
                      + "contactos (Nombre,Edad,Email,NumeroDeTelefono) values('"+es.getNombre()+"','"+es.getEdad()+"','"+es.getEmail()+"','"+es.getNumeroDeTelefono()+"')");
              cb.execute();
              
              JOptionPane.showMessageDialog(null, "Persona Agregada","Mensaje sistems",1);
              
          } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error"+ex.toString(),"Mensaje sistems",1);
          }
        
     }
}
