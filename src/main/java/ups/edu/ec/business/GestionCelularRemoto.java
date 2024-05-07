/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ups.edu.ec.business;

import java.util.List;
import ups.edu.ec.model.Celular;

/**
 *
 * @author colla
 */
public interface GestionCelularRemoto {

    public void guardarCelulares(Celular celular);

    public void actualizarCelular(Celular celular) throws Exception;

    public Celular getCelularPorId(int codigo);

    public void borrarCelular(int codigo);

    public List<Celular> getCelulares();
}
