/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Cliente;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;

/**
 *
 * @author yo
 */
public interface InterCliente {
    //insertar
    public void insertar(Cliente c);
    //eliminar
    //consultar uno
    public Cliente consultarUno(int id);
    //consultar todos
    public ArrayList<Cliente> consultar();
    //actualizar
}
