/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardinornamental.observable;

import java.util.Observable;

/**
 *
 * @author PIXVS-CHEVY
 */
public class ObservableVisitante extends Observable {

    private int contVisitantes = 0;
    private int contVisitantesIzq = 0;
    private int contVisitantesDer = 0;

    public ObservableVisitante(int contVisitantes) {
        this.contVisitantes = contVisitantes;
    }

    public ObservableVisitante() {
    }

    public int getContVisitantesIzq() {
        return contVisitantesIzq;
    }

    public void setContVisitantesIzq(int contVisitantesIzq) {
        this.contVisitantesIzq = contVisitantesIzq;
        setChanged();
        notifyObservers();
    }

    public int getContVisitantesDer() {
        return contVisitantesDer;
    }

    public void setContVisitantesDer(int contVisitantesDer) {
        this.contVisitantesDer = contVisitantesDer;
        setChanged();
        notifyObservers();
    }

    
    public int getContVisitantes() {
        return contVisitantes;
    }

    public void setContVisitantes(int contVisitantes) {
        this.contVisitantes = contVisitantes;
        setChanged();
        notifyObservers();
    }

}
