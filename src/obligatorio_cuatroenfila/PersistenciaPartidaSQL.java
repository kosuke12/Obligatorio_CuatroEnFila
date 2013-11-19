/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package obligatorio_cuatroenfila;

import java.sql.*;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Estefania Valdomir
 */
public class PersistenciaPartidaSQL extends PersistenciaPartida {
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

    public Boolean guardar(Partida par)
    {
        Boolean result = true;
        try{
            java.sql.Date sqlDate ;
            Connection conexion = conectar();
            PreparedStatement st1 = conexion.prepareStatement("UPDATE partida SET jug1=?, jug2=?, segundos=?, estadoPartida=?, ganador=?, fecha=? WHERE id = ?");
            st1.setString(1, par.getJug1());
            st1.setString(2, par.getJug2());
            st1.setInt(3, par.getSegundos());
            st1.setBoolean(4, par.getEstadoPartida());
            st1.setString(5, par.getGanador());
            sqlDate= (java.sql.Date) par.getFecha();
            st1.setDate(6, sqlDate);
            st1.setString(7, par.getId());


            int cont = st1.executeUpdate();
            if(cont == 0)
            {
                PreparedStatement st2 = conexion.prepareStatement("INSERT INTO  partida(id, jug1, jug2, segundos, estadoPartida, ganador, fecha)VALUES (?,?,?,?,?,?,?)");
                st2.setString(1, par.getId());
                st2.setString(2, par.getJug1());
                st2.setString(3, par.getJug2());
                st2.setInt(4, par.getSegundos());
                st2.setBoolean(5, par.getEstadoPartida());
                st2.setString(6, par.getGanador());
              //  java.sql.Date sqlDate ;
                sqlDate= (java.sql.Date) par.getFecha();
                st2.setDate(7, sqlDate);
                
                st2.executeUpdate();
            }
           }catch (Exception ex) {
               result = false;
        }
        return result;
    }
    
    public List<Partida> listarPartida()
    {
        List<Partida> result = new ArrayList<Partida>();
        Partida aux;
        try
        {
            Connection conexion = conectar();
            PreparedStatement comando = conexion.prepareStatement("select * from partida");
            ResultSet datos = comando.executeQuery();
            while(datos.next())
            {
                aux = new Partida();
                aux.setId(datos.getString("id"));
                result.add(aux);
            }

        } 
        catch (SQLException ex)
        {
            Logger.getLogger(Personas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
    
    
    
}
