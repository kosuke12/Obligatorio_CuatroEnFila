/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio_cuatroenfila;

/**
 *
 * @author Ana
 */
import java.sql.*;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistenciaPersonasSQL extends PersistenciaPersona {
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
    
    @Override
    public Boolean guardar(Personas per)
    {
        Boolean result = true;
        try{
            Connection conexion = conectar();
            PreparedStatement st1 = conexion.prepareStatement("UPDATE persona SET password=? WHERE nombre = ?");
            st1.setString(1, per.getPassword());
            st1.setString(2, per.getNombre());
            int cont = st1.executeUpdate();
            if(cont == 0)
            {
                PreparedStatement st2 = conexion.prepareStatement("INSERT INTO  persona(nombre, password)VALUES (?,?)");
                st2.setString(1, per.getNombre());
                st2.setString(2, per.getPassword());
                st2.executeUpdate();
            }
           }catch (Exception ex) {
               result = false;
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public int getSiguiente()
    {
        int cont = 0;
        try 
        {
            Connection conexion = conectar();
            PreparedStatement comando = conexion.prepareStatement("select * from persona");
            ResultSet datos = comando.executeQuery();
            while (datos.next())
            {
                cont++;
            }

        } 
        catch (SQLException ex)
        {
            Logger.getLogger(PersistenciaPersonasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cont++;
    }
    
    
    public List<Personas> lista()
    {
        List<Personas> result = new ArrayList<Personas>();
        Personas aux;
        try
        {
            Connection conexion = conectar();
            PreparedStatement comando = conexion.prepareStatement("select * from persona");
            ResultSet datos = comando.executeQuery();
            while(datos.next())
            {
                aux = new Personas();
                aux.setNombre(datos.getString("nombre"));
                aux.setPassword(datos.getString("password"));
                result.add(aux);
            }

        } 
        catch (SQLException ex)
        {
            Logger.getLogger(Personas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
    
   
//recordar borrar el datos.next
    @Override
    public Boolean buscar(String nombre) {
        Personas result = null;
        try
        {
          Connection conexion = conectar();
          PreparedStatement st = conexion.prepareStatement("SELECT * FROM persona WHERE nombre = ?");
          st.setString(1, nombre);
          ResultSet datos = st.executeQuery();
          if(datos.next())
          {
              result = new Personas();
              result.setNombre(nombre);
              result.setPassword(datos.getString("password"));
          }
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if(result==null)
            return false;
        return true;
    }

    
    
}
