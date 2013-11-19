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

public class Tablero extends Observable {

    public static final int FILA = 7;
    public static final int COLUMNA = 7;
    //SINGLETON
    private static Tablero instancia = null;

    public static Tablero getInstancia() {
        if (instancia == null) {
            return instancia = new Tablero();
        }

        return instancia;
    }
    private int[][] celdas = new int[FILA][COLUMNA];

    public int getValor(int fila, int colum) {
        //controles thownewexception
        return celdas[fila][colum];

    }

    public Mensaje colocar(int colum) {

        Mensaje m = new Mensaje();
        for (int i = 0; i < FILA; i++) {

            if (celdas[i][colum] == 0) {
                int jugador = cambioJugador();
                celdas[i][colum] = jugador;
                m.setGano(ganador(i, colum));
                if (m.isGano()) {
                    m.setMensaje("El jugador: " + jugador + " ha ganado!");
                    Partida p = new Partida();
                    p.setEstadoPartida(true);
                    if (jugador == 1) {
                        p.setGanador(Partida.getJugador1().toString());
                    } else {
                        p.setGanador(Partida.getJugador2().toString());
                        
                    }
                    
                }
                setChanged();
                notifyObservers();
                clearChanged();
                m.setColocar(true);
                return m;

            }
        }
        m.setColocar(false);
        return m;

    }

    public Boolean ganador(int fila, int columna) {
        Boolean ganador = false;
        int conthorizontal = contarhorizontal(fila, columna);
        int contvertical = contarvertical(fila, columna);
        int contdiag1 = contarDiagonal1(fila, columna);
        int contdiag2 = cuentoDiagonal2(fila, columna);

        if (conthorizontal >= 4 || contvertical >= 4 || contdiag1 >= 4 || contdiag2 >= 4) {
            ganador = true;
        }

        return ganador;

    }

    int contarhorizontal(int fila, int columna) {
        int cont = 1;
        int jugador = getValor(fila, columna);

        for (int j = columna - 1; j >= 0 && getValor(fila, j) == jugador; j--) {
            cont++;
        }

        for (int j = columna + 1; j < 7 && getValor(fila, j) == jugador; j++) {
            cont++;
        }

        return cont;

    }

    int contarvertical(int fila, int columna) {
        int cont = 1;
        int jugador = getValor(fila, columna);

        for (int j = fila - 1; j >= 0 && getValor(j, columna) == jugador; j--) {
            cont++;
        }

        for (int j = fila + 1; j < 7 && getValor(j, columna) == jugador; j++) {
            cont++;
        }


        return cont;
    }

    int contarDiagonal1(int fila, int columna) {
        int cont = 1;
        int jugador = getValor(fila, columna);

        for (int i = fila - 1, j = columna - 1; j >= 0 && i > 0 && getValor(i, j) == jugador; i--, j--) {
            cont++;
        }

        for (int i = fila + 1, j = columna + 1; j < FILA && i < COLUMNA && getValor(i, j) == jugador; i++, j++) {
            cont++;
        }

        return cont;
    }

    int cuentoDiagonal2(int fila, int columna) {
        int cont = 1;
        int jugador = getValor(fila, columna);

        for (int i = fila - 1, j = columna + 1; j < COLUMNA && i >= 0 && getValor(i, j) == jugador; i--, j++) {
            cont++;
        }


        for (int i = fila + 1, j = columna - 1; j > 0 && i < FILA && getValor(i, j) == jugador; i++, j--) {
            cont++;
        }

        return cont;
    }

    public Personas calcularTurno() {
        //Personas a = new Personas();
        // Partida.setJugador1("Palivoda");
        //Partida.setJugador1(a);
        //Personas b = new Personas();
        //Partida.setJugador2("Estefa");
        //Partida.setJugador2(b);
        //Partida p = new Partida();
        int cont1 = 0;
        int cont2 = 0;
        for (int i = 0; i < Tablero.FILA; i++) {
            for (int j = 0; j < Tablero.COLUMNA; j++) {
                //dibujar(j,i,Tablero.getInstancia().getValor(i,j));
                if (getValor(i, j) == 1) {
                    cont1++;
                }
                if (getValor(i, j) == 2) {
                    cont2++;
                }
            }
        }
        if (cont1 > cont2) {
            return Partida.getJugador2();//agregado partida.getJugador();
        }
        if (cont2 == cont1) {
            return Partida.getJugador1();
        }

        return Partida.getJugador1();
    }
    int jug = 2;

    public int cambioJugador() {
        if (jug == 1) {
            jug = 2;
            return 2;
        }
        if (jug == 2) {
            jug = 1;
            return 1;
        }
        jug = 1;
        return 1;
    }

    public void autoColocar() {
        for (int i = 0; i < Tablero.COLUMNA; i++) {
            if (getValor(6, i) == 0) {
                colocar(i);
                break;
            }

            //dibujar(j,i,Tablero.getInstancia().getValor(i,j));




        }

    }
}
