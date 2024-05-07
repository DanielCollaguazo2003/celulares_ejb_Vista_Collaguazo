/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.celularesjb;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import ups.edu.ec.business.GestionCelularRemoto;
import ups.edu.ec.model.Celular;

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
            Celular Celular = new Celular();
            Celular.setCodigo(2);
            Celular.setIMEI("6578923414723867354724");
            Celular.setColor("Blanco");
            Celular.setMarca("Iphone");
            Celular.setModelo("12 Pro Max");
            Celular.setPrecio(1119.2);
            gestionCelulares.guardarCelulares(Celular);
            System.out.println("Celular guardado!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
