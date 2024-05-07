/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import ups.edu.ec.business.GestionCelularRemoto;
import ups.edu.ec.model.Celular;
import ups.edu.ec.model.DefaultListCelulares;
import vista.VistaGeneral;

/**
 *
 * @author colla
 */
public class ListenerBtnEliminar implements ActionListener {

    VistaGeneral v;
    Celular c;
    GestionCelularRemoto gestionCelulares;
    DefaultListCelulares listCelulares;

    public ListenerBtnEliminar(VistaGeneral v, Celular c, GestionCelularRemoto gestionCelulares, DefaultListCelulares listCelulares) {
        this.v = v;
        this.c = c;
        this.gestionCelulares = gestionCelulares;
        this.listCelulares = listCelulares;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int codigoCelular = v.getListCelualres1().getSelectedValue().getCodigo();
            System.out.println("el cooddiidididi"+codigoCelular);
            gestionCelulares.borrarCelular(codigoCelular);
            listCelulares.removeaAllElements();
            List<Celular> celularesAPI = gestionCelulares.getCelulares();
            for (Celular celular : celularesAPI) {
                listCelulares.addElement(celular);
            }
            v.addList(listCelulares);
            v.addList2(listCelulares);
            JOptionPane.showMessageDialog(v, "Celular eliminado con exito Id----" + codigoCelular);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(v, "Fallo la Eliminacion " + ex.getMessage() );
        }

        
    }

}
