/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package obligatorio_cuatroenfila;

/**
 *
 * @author Estefania Valdomir
 */
public class Mensaje {
    private boolean colocar;
     private boolean gano;
    private String mensaje;

    public boolean isColocar() {
        return colocar;
    }

    public boolean isGano() {
        return gano;
    }

    public void setGano(boolean gano) {
        this.gano = gano;
    }

    public void setColocar(boolean colocar) {
        this.colocar = colocar;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }


}
