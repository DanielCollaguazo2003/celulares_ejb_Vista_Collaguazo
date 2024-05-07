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
public class ListenerBtnActEnviar implements ActionListener {

    VistaGeneral v;
    Celular c;

    public ListenerBtnActEnviar(VistaGeneral v, Celular c) {
        this.v = v;
        this.c = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            c = v.getListCelualres1().getSelectedValue();
            v.getTxtColorAct().setText(c.getColor());
            v.getTxtModeloAct().setText(c.getModelo());
            v.getTxtIMEIAct().setText(c.getIMEI());
            v.getTxtMarcaAct().setText(c.getMarca());
            v.getTxtPrecioAct().setText(String.valueOf(c.getPrecio()));
            v.getTxtCodigo().setText("Codigo = " + c.getCodigo());
            
            v.getjTabbedPane1().setSelectedIndex(2);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(v, "Fallo el envio de parametros " + ex.getMessage() );
        }

        
    }

}
