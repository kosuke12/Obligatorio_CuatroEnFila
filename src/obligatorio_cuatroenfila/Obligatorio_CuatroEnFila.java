/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio_cuatroenfila;

/**
 *
 * @author Ana
 */
public class Obligatorio_CuatroEnFila {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Personas p= new Personas();
        p.setNombre("Estefa");
        p.setPassword("123");
        

        PersistenciaPersonasSQL per=new PersistenciaPersonasSQL();
        p.setCod(per.getSiguiente());
        per.guardar(p);

        System.out.println(per.lista());
    }
}
