package jardinornamental.proceso;

import jardinornamental.FXMLDocumentController;
import jardinornamental.observable.ObservableVisitante;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.image.ImageView;

/**
 *
 * @author PIXVS-CHEVY
 */
public class ProcesoVisitantes implements Runnable {

    private boolean torniquete1EnUso = false;
    private boolean torniquete2EnUso = false;
    private boolean entrarEnCola = false;
    private boolean corriendo = true;

    private int contVisitantes = 0;

    private int contVisitantesIzq = 0;
    private int contVisitantesDer = 0;
    private final double OPACITY_INVISIBLE = 0.04;
    private final double OPACITY_VISIBLE = 1.0;

    private long velocidadVisitante = 200;

    private final int MAX = 2;
    private final int MIN = 1;

    private final int MAX_VELOCIDAD = 500;
    private final int MIN_VELOCIDAD = 100;

    private final int MAX_ESPERA = 700;
    private final int MIN_ESPERA = 100;

    public static final int TORRETA_IZQ = 0;
    public static final int TORRETA_DER = 1;
    private final int MAX_CAPACIDAD = 20;

    private final ArrayList<ImageView> alIn;
    private final ArrayList<ImageView> alCola;

    private final FXMLDocumentController ventana;
    private int torreta = -1;
    private final ObservableVisitante observable;

    public ProcesoVisitantes(FXMLDocumentController ventana, ArrayList<ImageView> alCola, int torreta, ObservableVisitante observable) {
        this.ventana = ventana;
        this.alCola = alCola;
        alIn = ventana.getAlIn();
        this.torreta = torreta;
        this.observable = observable;
    }

    public boolean isEntrarEnCola() {
        return entrarEnCola;
    }

    public void setEntrarEnCola(boolean entrarEnCola) {
        this.entrarEnCola = entrarEnCola;
    }

    public boolean isTorniquete1EnUso() {
        return torniquete1EnUso;
    }

    public void setTorniquete1EnUso(boolean torniquete1EnUso) {
        this.torniquete1EnUso = torniquete1EnUso;
    }

    public boolean isTorniquete2EnUso() {
        return torniquete2EnUso;
    }

    public void setTorniquete2EnUso(boolean torniquete2EnUso) {
        this.torniquete2EnUso = torniquete2EnUso;
    }

    public synchronized void entraVisitante(int torreta) {

        contVisitantes++;
        switch (torreta) {
            case TORRETA_IZQ:
                alIn.get(contVisitantesIzq).setOpacity(1.0);
                contVisitantesIzq++;
                break;
            case TORRETA_DER:
                alIn.get(contVisitantesDer + MAX_CAPACIDAD).setOpacity(1.0);
                contVisitantesDer++;
                break;
        }
        if (contVisitantes >= MAX_CAPACIDAD) {
            corriendo = false;
//            Thread.currentThread().suspend();
        }

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                switch (torreta) {
                    case TORRETA_IZQ:
                        ventana.setContadorVisitantesIzq(contVisitantesIzq);
                        observable.setContVisitantesIzq(contVisitantesIzq);
                        break;
                    case TORRETA_DER:
                        ventana.setContadorVisitantesDer(contVisitantesDer);
                        observable.setContVisitantesDer(contVisitantesDer);
                        break;
                }

            }
        });

    }

    public synchronized void posicionVisitante(int pos, double opacity) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                alCola.get(pos).setOpacity(opacity);

            }
        });

    }

    @Override
    public void run() {
        while (true) {
            if (corriendo) {
                try {

                    if (torniquete1EnUso) {
                        Thread.sleep(200);
                        ventana.getLblTorniquete1().setRotate(-45);
                        Thread.sleep(200);
                        ventana.getLblTorniquete1().setRotate(-90);
                        torniquete1EnUso = false;
                    }

                    if (torniquete2EnUso) {
                        Thread.sleep(200);
                        ventana.getLblTorniquete2().setRotate(-45);
                        Thread.sleep(200);
                        ventana.getLblTorniquete2().setRotate(-90);
                        torniquete2EnUso = false;
                    }

                    if (entrarEnCola) {

                        Thread.sleep(new Random().nextInt(MAX_ESPERA - MIN_ESPERA + 1) + MIN_ESPERA);

                        for (int i = alCola.size() - 1; i >= 0; i--) {

                            //Si llega a la entrada
                            if (i == 0) {
                                alCola.get(i).setOpacity(1);
                                Thread.sleep(velocidadVisitante);

                                velocidadVisitante = new Random().nextInt(MAX_VELOCIDAD - MIN_VELOCIDAD + 1) + MIN_VELOCIDAD;

                                switch (torreta) {

                                    case TORRETA_IZQ:

                                        ventana.getLblTorniquete1().setRotate(-45);
                                        Thread.sleep(200);
                                        ventana.getLblTorniquete1().setRotate(-90);
                                        Thread.sleep(100);
                                        ventana.getLblTorniquete1().setRotate(-45);
                                        Thread.sleep(100);
                                        ventana.getLblTorniquete1().setRotate(-90);
                                        torniquete1EnUso = false;
                                        break;

                                    case TORRETA_DER:

                                        ventana.getLblTorniquete2().setRotate(-45);
                                        Thread.sleep(200);
                                        ventana.getLblTorniquete2().setRotate(-90);
                                        Thread.sleep(100);
                                        ventana.getLblTorniquete2().setRotate(-45);
                                        Thread.sleep(100);
                                        ventana.getLblTorniquete2().setRotate(-90);
                                        torniquete2EnUso = false;
                                        break;
                                }

                                alCola.get(i).setOpacity(OPACITY_INVISIBLE);
                                entraVisitante(torreta);
                            } else {
                                posicionVisitante(i, OPACITY_VISIBLE);
                                Thread.sleep(velocidadVisitante);
                                posicionVisitante(i, OPACITY_INVISIBLE);
                            }
                        }
                    }

                } catch (InterruptedException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProcesoVisitantes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
