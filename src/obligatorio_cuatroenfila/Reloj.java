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

public class Reloj extends Observable {
    Timer timer = new Timer(); // El timer que se encarga de administrar los tiempo de repeticion
	private int segundos; // manejar el valor del contador

    /**
     * @return the segundos
     */
    public int getSegundos() {
        return segundos;
    }
 public Reloj() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
               setSegundos(getSegundos() + 1);
                Reloj.this.setChanged();
                Reloj.this.notifyObservers();
                Reloj.this.clearChanged();
            }
        }, new Date(), 1000);
    }
    /**
     * @param segundos the segundos to set
     */
    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

	// clase interna que representa una tarea, se puede crear varias tareas y asignarle al timer luego
	class MiTarea extends TimerTask {
		public void run() {
			setSegundos(getSegundos() + 1);
                        Reloj.this.setChanged();
                        Reloj.this.notifyObservers();
                        Reloj.this.clearChanged();
			// aqui se puede escribir el codigo de la tarea que necesitamos ejecutar
		}// end run()
	}// end SincronizacionAutomatica

	public void Start(int pSeg) throws Exception {
            this.setSegundos(0);
            timer= new Timer();
            timer.schedule(new MiTarea(),0,1000);
	}// end Start

	public void Stop() {
            timer.cancel();
            this.setSegundos(0);
	}// end Stop


        public boolean timerOut()
        {
            if(this.getSegundos()==30){
                return true;
            
            }
            return false;

        }

}
