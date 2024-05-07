/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.edu.ec.model;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author colla
 */
public class DefaultListCelulares extends AbstractListModel<Celular> {

    private ArrayList<Celular> listaCelular;

    public DefaultListCelulares() {
        this.listaCelular = new ArrayList<>();
    }

    public boolean verificarLista() {
        return listaCelular.isEmpty();
    }

    public void fireIntervalRemoved(Celular celular, int index) {
        listaCelular.remove(celular);
        super.fireIntervalRemoved(this, index, index);
    }

    public void removeaAllElements() {
        int size = listaCelular.size();
        if (size > 0) {
            listaCelular.clear();
            fireIntervalRemoved(this, 0, size - 1);
        }
    }

    @Override
    public int getSize() {
        return listaCelular.size();
    }

    @Override
    public Celular getElementAt(int index) {
        return listaCelular.get(index);
    }

    public void addElement(Celular celular) {
        int index = listaCelular.size();
        listaCelular.add(celular);
        fireIntervalAdded(this, index, index);
    }

    public ArrayList<Celular> getListaCelulares() {
        return listaCelular;
    }

}
