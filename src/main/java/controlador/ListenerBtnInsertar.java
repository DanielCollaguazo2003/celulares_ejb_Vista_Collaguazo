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
public class ListenerBtnInsertar implements ActionListener {

    VistaGeneral v;
    Celular c;
    GestionCelularRemoto gestionCelulares;
    DefaultListCelulares listCelulares;

    public ListenerBtnInsertar(VistaGeneral v, Celular c, GestionCelularRemoto gestionCelulares, DefaultListCelulares listCelulares) {
        this.v = v;
        this.c = c;
        this.gestionCelulares = gestionCelulares;
        this.listCelulares = listCelulares;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            c.setIMEI(v.getTxtIMEI().getText());
            c.setColor(v.getTxtColor().getText());
            c.setMarca(v.getTxtMarca().getText());
            c.setModelo(v.getTxtModelo().getText());
            c.setPrecio(Double.parseDouble(v.getTxtPrecio().getText()));
            gestionCelulares.guardarCelulares(c);
            listCelulares.removeaAllElements();
            List<Celular> celularesAPI = gestionCelulares.getCelulares();
            for (Celular celular : celularesAPI) {
                listCelulares.addElement(celular);
            }
            v.addList(listCelulares);
            v.addList2(listCelulares);
            JOptionPane.showMessageDialog(v, "cliente agregado con Exito");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(v, "Fallo la insercion " + ex.getMessage());
        }

    }

}
