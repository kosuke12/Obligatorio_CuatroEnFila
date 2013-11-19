/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio_cuatroenfila;

/**
 *
 * @author Sebastian
 */
import java.util.*;
public class FachadaCargar {
    PersistenciaPartida per = new PersistenciaPartidaSQL();
    public List<Partida> listarPartida()
    {
        List<Partida> list = new ArrayList<Partida>();
        List<Partida> listarPartida = per.listarPartida();
        for(Partida p : listarPartida)
        {
            if(p.getEstadoPartida()== false)
            {
                list.add(p);
            }
        }
        
        return list;
    }
    
}
