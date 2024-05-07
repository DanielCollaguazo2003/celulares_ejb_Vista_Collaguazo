/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.celularesjb;

import controlador.ListenerBtnActEnviar;
import controlador.ListenerBtnActualizar;
import controlador.ListenerBtnEliminar;
import controlador.ListenerBtnInsertar;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import ups.edu.ec.business.GestionCelularRemoto;
import ups.edu.ec.model.Celular;
import ups.edu.ec.model.DefaultListCelulares;
import vista.VistaGeneral;

/**
 *
 * @author colla
 */
public class Celularesjb {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {
            final Hashtable<String, String> jndiProperties = new Hashtable<>();
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "daniel"); // Reemplaza 'username' con tu nombre de usuario
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "Collaguazo123"); // Reemplaza 'password' con tu contraseña
            jndiProperties.put("jboss.naming.client.ejb.context", "true");
            final Context context = new InitialContext(jndiProperties);
            GestionCelularRemoto gestionCelulares = (GestionCelularRemoto) context.lookup("ejb:/celulares/GestionCelular!ups.edu.ec.business.GestionCelularRemoto");
            // Uso del EJB
            VistaGeneral v = new VistaGeneral();
            Celular c = new Celular();
            DefaultListCelulares listCelulares = new DefaultListCelulares();
            
            List<Celular> celularesAPI = gestionCelulares.getCelulares();
            for (Celular celular : celularesAPI) {
                listCelulares.addElement(celular);
            }
            
            v.addList(listCelulares);
            v.addList2(listCelulares);
            
            ListenerBtnInsertar btnInsertar = new ListenerBtnInsertar(v, c, gestionCelulares, listCelulares);
            ListenerBtnEliminar btnEliminar = new ListenerBtnEliminar(v, c, gestionCelulares, listCelulares);
            ListenerBtnActEnviar btnActEnviar = new ListenerBtnActEnviar(v, c);
            ListenerBtnActualizar btnActualizar = new ListenerBtnActualizar(v, c, gestionCelulares, listCelulares);
            
            v.listenerActuaizarCelular(btnActualizar);
            v.listenerActulizarEnviarCelular(btnActEnviar);
            v.listenerEliminarCelular(btnEliminar);
            v.listenerInsertarCelular(btnInsertar);
            
            v.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
