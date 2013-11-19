/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio_cuatroenfila;

/**
 *
 * @author Estefania Valdomir
 */
import java.util.*;

public class FachadaRegistrar {

    static PersistenciaPersona per = new PersistenciaPersonasSQL();

    public static void registrar(String nombre, String password) {
        Personas p = new Personas();
        p.setNombre(nombre);
        p.setPassword(password);
        per.guardar(p);

    }
    // Prtida
    static PersistenciaPartida perpar = new PersistenciaPartidaSQL();
    // TableroPartida
    static PersistenciaTableroPartida perTabPar = new PersistenciaTableroPartidaSQL();
    
    public static void guardar(String id, String jug1, String jug2, Integer segundos, Boolean estado, String ganador, Date fecha) {
        Partida p = new Partida();
        p.setId(id);
        p.setJug1(jug1);
        p.setJug2(jug2);
        p.setSegundos(segundos);
        p.setEstadoPartida(estado);
        p.setGanador(ganador);
        p.setFecha(fecha);

        perpar.guardar(p);

        // guardar TableroPartida
        for (int i = 0; i < Tablero.FILA; i++) {
            for (int j = 0; j < Tablero.COLUMNA; j++) {
                TableroPartida tp= new TableroPartida();
                
                tp.setId(id);
                tp.setFila(i);
                tp.setColumna(j);
                tp.setValor(Tablero.getInstancia().getValor(i, j));
                perTabPar.guardar(tp);
            }
        }


    }
}
