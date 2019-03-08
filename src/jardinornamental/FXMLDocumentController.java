/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardinornamental;

import jardinornamental.observable.ObservableVisitante;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author PIXVS-CHEVY
 */
public class FXMLDocumentController implements Initializable, Observer {

    private int contVisitantes = 0;
    private int contVisitantesIzq = 0;
    private int contVisitantesDer = 0;
    
    private ObservableVisitante obsVisitante;
    
    @FXML
    private Label label;
    @FXML
    private Pane pnTorniquete1;
    @FXML
    private Label lblTorniquete1;
    @FXML
    private Pane pnTorniquete2;
    @FXML
    private Label lblTorniquete2;

    @FXML
    private Button btnTest;
    @FXML
    private ImageView in1;
    @FXML
    private ImageView in12;

    private ArrayList<ImageView> alIn;
    private ArrayList<ImageView> alColaDer;
    private ArrayList<ImageView> alColaIzq;

    @FXML
    private ImageView c1;
    @FXML
    private ImageView c2;
    @FXML
    private ImageView c3;
    @FXML
    private ImageView c4;
    @FXML
    private ImageView c5;
    @FXML
    private ImageView c6;
    @FXML
    private ImageView c7;
    @FXML
    private ImageView c8;
    @FXML
    private ImageView c9;
    @FXML
    private ImageView c10;
    @FXML
    private ImageView c11;
    @FXML
    private ImageView c12;
    @FXML
    private ImageView c13;
    @FXML
    private Label lblContadorVisitantes;
    @FXML
    private ImageView in40;
    @FXML
    private ImageView in39;
    @FXML
    private ImageView in38;
    @FXML
    private ImageView in37;
    @FXML
    private ImageView in36;
    @FXML
    private ImageView in35;
    @FXML
    private ImageView in34;
    @FXML
    private ImageView in33;
    @FXML
    private ImageView in32;
    @FXML
    private ImageView in31;
    @FXML
    private ImageView in30;
    @FXML
    private ImageView in29;
    @FXML
    private ImageView in28;
    @FXML
    private ImageView in27;
    @FXML
    private ImageView in26;
    @FXML
    private ImageView in25;
    @FXML
    private ImageView in24;
    @FXML
    private ImageView in23;
    @FXML
    private ImageView in22;
    @FXML
    private ImageView in21;
    @FXML
    private ImageView in20;
    @FXML
    private ImageView in19;
    @FXML
    private ImageView in18;
    @FXML
    private ImageView in17;
    @FXML
    private ImageView in16;
    @FXML
    private ImageView in15;
    @FXML
    private ImageView in14;
    @FXML
    private ImageView in13;
    @FXML
    private ImageView in11;
    @FXML
    private ImageView in10;
    @FXML
    private ImageView in9;
    @FXML
    private ImageView in8;
    @FXML
    private ImageView in7;
    @FXML
    private ImageView in6;
    @FXML
    private ImageView in5;
    @FXML
    private ImageView in4;
    @FXML
    private ImageView in3;
    @FXML
    private ImageView in2;
    @FXML
    private Label lblContadorVisitantesDer;
    @FXML
    private Label lblContadorVisitantesIzq;
    @FXML
    private Label lblContadorTiempo;
    @FXML
    private ImageView ci1;
    @FXML
    private ImageView ci2;
    @FXML
    private ImageView ci3;
    @FXML
    private ImageView ci4;
    @FXML
    private ImageView ci5;
    @FXML
    private ImageView ci6;
    @FXML
    private ImageView ci7;
    @FXML
    private ImageView ci8;
    @FXML
    private ImageView ci9;
    @FXML
    private ImageView ci10;
    @FXML
    private ImageView ci11;
    @FXML
    private ImageView ci0;
    @FXML
    private ImageView c0;
    @FXML
    private Pane pnFlores1;
    @FXML
    private Pane pnFlores2;
    @FXML
    private Pane pnBushes;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        alIn = new ArrayList<>();
        alIn.add(in1);
        alIn.add(in2);
        alIn.add(in3);
        alIn.add(in4);
        alIn.add(in5);
        alIn.add(in6);
        alIn.add(in7);
        alIn.add(in8);
        alIn.add(in9);
        alIn.add(in10);
        alIn.add(in11);
        alIn.add(in12);
        alIn.add(in13);
        alIn.add(in14);
        alIn.add(in15);
        alIn.add(in16);
        alIn.add(in17);
        alIn.add(in18);
        alIn.add(in19);
        alIn.add(in20);
        alIn.add(in21);
        alIn.add(in22);
        alIn.add(in23);
        alIn.add(in24);
        alIn.add(in25);
        alIn.add(in26);
        alIn.add(in27);
        alIn.add(in28);
        alIn.add(in29);
        alIn.add(in30);
        alIn.add(in31);
        alIn.add(in32);
        alIn.add(in33);
        alIn.add(in34);
        alIn.add(in35);
        alIn.add(in36);
        alIn.add(in37);
        alIn.add(in38);
        alIn.add(in39);
        alIn.add(in40);

//        in1.setOpacity(1);
        alColaDer = new ArrayList<>();
        alColaDer.add(c0);
        alColaDer.add(c1);
        alColaDer.add(c2);
        alColaDer.add(c3);
        alColaDer.add(c4);
        alColaDer.add(c5);
        alColaDer.add(c6);
        alColaDer.add(c7);
        alColaDer.add(c8);
        alColaDer.add(c9);
        alColaDer.add(c10);
        alColaDer.add(c11);
        alColaDer.add(c12);
        alColaDer.add(c13);

        alColaIzq = new ArrayList<>();
        alColaIzq.add(ci0);
        alColaIzq.add(ci1);
        alColaIzq.add(ci2);
        alColaIzq.add(ci3);
        alColaIzq.add(ci4);
        alColaIzq.add(ci5);
        alColaIzq.add(ci6);
        alColaIzq.add(ci7);
        alColaIzq.add(ci8);
        alColaIzq.add(ci9);
        alColaIzq.add(ci10);
        alColaIzq.add(ci11);

//                 setContadorVisitantes(5);
    }

    public Label getLblContadorVisitantes() {
        return lblContadorVisitantes;
    }

    public void setContadorVisitantes(int contVisitas) {
        this.lblContadorVisitantes.setText("" + contVisitas);
    }

    public void setContadorVisitantesIzq(int contVisitas) {
        this.lblContadorVisitantesIzq.setText("" + contVisitas);
        this.contVisitantesIzq = contVisitas;
    }

    public void setContadorVisitantesDer(int contVisitas) {
        this.lblContadorVisitantesDer.setText("" + contVisitas);
        this.contVisitantesDer = contVisitas;
    }

    public void setContadorTiempo(int contTiempo) {
        this.lblContadorTiempo.setText("" + contTiempo);
    }

    public ArrayList<ImageView> getAlIn() {
        return alIn;
    }

    public void setAlIn(ArrayList<ImageView> alIn) {
        this.alIn = alIn;
    }

    public ArrayList<ImageView> getAlColaDer() {
        return alColaDer;
    }
    
        public ArrayList<ImageView> getAlColaIzq() {
        return alColaIzq;
    }

    public void setAlCola(ArrayList<ImageView> alCola) {
        this.alColaDer = alCola;
    }

    public Label getLblTorniquete1() {
        return lblTorniquete1;
    }

    public Label getLblTorniquete2() {
        return lblTorniquete2;
    }

    public Pane getPnFlores1() {
        return pnFlores1;
    }

    public Pane getPnFlores2() {
        return pnFlores2;
    }

    public Pane getPnBushes() {
        return pnBushes;
    }
    
    

    @FXML
    private void onTest(ActionEvent event) {
        System.out.println("Test");
    }

    @Override
    public void update(Observable o, Object arg) {
        obsVisitante = (ObservableVisitante) o;
//        System.out.println("IZQUIERDA " + obsVisitante.getContVisitantesIzq());
//        System.out.println("DERECHA " + obsVisitante.getContVisitantesDer());
        setContadorVisitantes(obsVisitante.getContVisitantesIzq()+obsVisitante.getContVisitantesDer());
    }

}
