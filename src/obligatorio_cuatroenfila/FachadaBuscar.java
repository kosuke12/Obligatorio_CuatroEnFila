/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio_cuatroenfila;

/**
 *
 * @author Sebastian Palivoda
 */
public class FachadaBuscar{
    static PersistenciaPersona perPer= new PersistenciaPersonasSQL();
    
    public static Boolean VerificarJugador(String nombre)
    {
        return perPer.buscar(nombre);
    }
}
