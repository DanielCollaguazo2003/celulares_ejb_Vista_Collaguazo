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
public class ListenerBtnActualizar implements ActionListener {

    VistaGeneral v;
    Celular c;
    GestionCelularRemoto gestionCelulares;
    DefaultListCelulares listCelulares;

    public ListenerBtnActualizar(VistaGeneral v, Celular c, GestionCelularRemoto gestionCelulares, DefaultListCelulares listCelulares) {
        this.v = v;
        this.c = c;
        this.gestionCelulares = gestionCelulares;
        this.listCelulares = listCelulares;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            c.setIMEI(v.getTxtIMEIAct().getText());
            c.setColor(v.getTxtColorAct().getText());
            c.setMarca(v.getTxtMarcaAct().getText());
            c.setModelo(v.getTxtModeloAct().getText());
            c.setPrecio(Double.parseDouble(v.getTxtPrecioAct().getText()));

            String[] partes = v.getTxtCodigo().getText().split("=");

            String numeroStr = partes[1].trim(); 
            int numero = Integer.parseInt(numeroStr); 

            c.setCodigo(numero);

            gestionCelulares.actualizarCelular(c);

            listCelulares.removeaAllElements();
            List<Celular> celularesAPI = gestionCelulares.getCelulares();
            for (Celular celular : celularesAPI) {
                listCelulares.addElement(celular);
            }
            v.addList(listCelulares);
            v.addList2(listCelulares);

            JOptionPane.showMessageDialog(v, "Celular Actualizado con exito ");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(v, "Fallo el envio de parametros " + ex.getMessage());
        }

    }

}
