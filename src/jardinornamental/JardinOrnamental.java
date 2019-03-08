/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardinornamental;

import jardinornamental.observable.ObservableVisitante;
import jardinornamental.proceso.ProcesoDemonio;
import jardinornamental.proceso.ProcesoVisitantes;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author PIXVS-CHEVY
 */
public class JardinOrnamental extends Application {

    Thread tvDer = null;
    Thread tvIzq = null;
    Thread td = null;

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        stage.setOnCloseRequest((WindowEvent e) -> {
            if (td.isAlive()) {
                td.stop();
            }
            if (tvDer.isAlive()) {
                tvDer.stop();
            }
            if (tvIzq.isAlive()) {
                tvIzq.stop();
            }
            Platform.exit();
        });
        stage.setScene(scene);
        FXMLDocumentController controladorVentana = (FXMLDocumentController) loader.getController();

        ObservableVisitante observable = new ObservableVisitante();
        observable.addObserver(controladorVentana);
        
//        observable.setContVisitantesIzq(10);
        
        ProcesoVisitantes pvDer = new ProcesoVisitantes(controladorVentana, controladorVentana.getAlColaDer(), ProcesoVisitantes.TORRETA_DER, observable);
        ProcesoVisitantes pvIzq = new ProcesoVisitantes(controladorVentana, controladorVentana.getAlColaIzq(), ProcesoVisitantes.TORRETA_IZQ, observable);
        ProcesoDemonio pd = new ProcesoDemonio(controladorVentana);

        
//        observable.addObserver(pvIzq);

        tvDer = new Thread(pvDer);
        tvDer.start();

        tvIzq = new Thread(pvIzq);
        tvIzq.start();

        td = new Thread(pd);
        td.start();

        pvDer.setEntrarEnCola(true);
        pvIzq.setEntrarEnCola(true);

        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
