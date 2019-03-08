package jardinornamental.proceso;

import jardinornamental.FXMLDocumentController;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.image.ImageView;

/**
 *
 * @author PIXVS-CHEVY
 */
public class ProcesoDemonio implements Runnable {

    private boolean torniquete1EnUso = false;
    private boolean torniquete2EnUso = false;
    private boolean corriendo = true;

    private int contTiempo = 0;


    private final int MAX = 2;
    private final int MIN = 1;
    private final int TORRETA_IZQ = 0;
    private final int TORRETA_DER = 1;
    private final int MAX_CAPACIDAD = 40;

    private ArrayList<ImageView> alIn;
    private ArrayList<ImageView> alCola;

    private FXMLDocumentController ventana;

    public ProcesoDemonio(FXMLDocumentController ventana) {
        this.ventana = ventana;
        alCola = ventana.getAlColaDer();
        alIn = ventana.getAlIn();
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

    public synchronized void aumentaTiempo() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                ventana.setContadorTiempo(++contTiempo);

            }
        });

    }

    @Override
    public void run() {
        
        while (true) {
            if (corriendo) {
                try {

                    Thread.sleep(1000);
                    aumentaTiempo();
                    
                    ventana.getPnFlores1().setLayoutX(ventana.getPnFlores1().getLayoutX()+( contTiempo % 2 == 0 ? 2: -2) );
                    ventana.getPnFlores2().setLayoutX(ventana.getPnFlores2().getLayoutX()+( contTiempo % 2 == 0 ? -2: 2) );
                    
                    ventana.getPnBushes().setScaleY(ventana.getPnBushes().getScaleY()+( contTiempo % 2 == 0 ? -0.05: 0.05) );
                    

                } catch (InterruptedException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
