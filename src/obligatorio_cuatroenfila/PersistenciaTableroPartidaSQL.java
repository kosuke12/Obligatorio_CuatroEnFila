/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package obligatorio_cuatroenfila;

import java.sql.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author Estefania Valdomir
 */
public class PersistenciaTableroPartidaSQL extends PersistenciaTableroPartida {

    private Connection conectar()
    {
        Connection conexion = null;
        try
        {
            Properties props=new Properties();
            props.load(new FileReader("conexion.properties"));
            String usuario=props.getProperty("usu");
            String pass=props.getProperty("pass");
            String url=props.getProperty("url");
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url,usuario,pass);
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return conexion;
    }
    public Boolean guardar(TableroPartida tab)
    {
        Boolean result = true;
        try{
            //java.sql.Date sqlDate ;
            Connection conexion = conectar();
            PreparedStatement st1 = conexion.prepareStatement("UPDATE tableropartida SET valor=? WHERE id = ? and fila=? and columna=?");
            st1.setInt(3, tab.getFila());
            st1.setInt(4, tab.getColumna());
            st1.setInt(1, tab.getValor());
            st1.setString(2, tab.getId());
            


            int cont = st1.executeUpdate();
            if(cont == 0)
            {
                PreparedStatement st2 = conexion.prepareStatement("INSERT INTO  tableropartida(id, fila, columna, valor)VALUES (?,?,?,?)");
                st2.setString(1, tab.getId());
                st2.setInt(2, tab.getFila());
                st2.setInt(3, tab.getColumna());
                st2.setInt(4, tab.getValor());
                
                st2.executeUpdate();
            }
           }catch (Exception ex) {
               result = false;
        }
        return result;
    }
}
