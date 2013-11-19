/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package obligatorio_cuatroenfila;

import java.util.List;

/**
 *
 * @author Estefania Valdomir
 */
public abstract class PersistenciaPartida {
    public abstract Boolean guardar(Partida par);
    public abstract List<Partida> listarPartida();
}
