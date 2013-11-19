/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package obligatorio_cuatroenfila;

import java.util.Date;

/**
 *
 * @author Estefania Valdomir
 */
public class Partida {
    public  static Personas jugador1=null;
    public  static  Personas jugador2=null;
    private String id;
    private String jug1;
    private String jug2;
    private Integer segundos;
    private Boolean estadoPartida;
    private String ganador;
    private Date  fecha;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the jug1
     */
    public String getJug1() {
        return jug1;
    }

    /**
     * @param jug1 the jug1 to set
     */
    public void setJug1(String jug1) {
        this.jug1 = jug1;
    }

    /**
     * @return the jug2
     */
    public String getJug2() {
        return jug2;
    }

    /**
     * @param jug2 the jug2 to set
     */
    public void setJug2(String jug2) {
        this.jug2 = jug2;
    }

    /**
     * @return the segundos
     */
    public Integer getSegundos() {
        return segundos;
    }

    /**
     * @param segundos the segundos to set
     */
    public void setSegundos(Integer segundos) {
        this.segundos = segundos;
    }

    /**
     * @return the estadoPartida
     */
    public Boolean getEstadoPartida() {
        return estadoPartida;
    }

    /**
     * @param estadoPartida the estadoPartida to set
     */
    public void setEstadoPartida(Boolean estadoPartida) {
        this.estadoPartida = estadoPartida;
    }

    /**
     * @return the ganador
     */
    public String getGanador() {
        return ganador;
    }

    /**
     * @param ganador the ganador to set
     */
    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public static void setJugador1(String nombre)
    {
        jugador1 = new Personas();
        jugador1.setNombre(nombre);
       // jugador1.setPassword(pass);
    }

    public static void setJugador2(String nombre)
    {
        jugador2 = new Personas();
        jugador2.setNombre(nombre);
        //jugador2.s
    }

    public static Personas getJugador1()
    {
        return jugador1;
    }
    public static Personas getJugador2()
    {
        return jugador2;
    }

    @Override
    public String toString() {
        return id;
    }
    
    
}
