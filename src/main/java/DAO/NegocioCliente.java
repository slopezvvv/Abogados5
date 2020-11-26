/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Cliente;
import com.mongodb.client.FindIterable;
import java.util.List;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author yo
 */
public class NegocioCliente extends Connection{
    
    
    public NegocioCliente(){
        super("Clientes");
    }
    
    // TAREA
    @Override
    public void insertar(Cliente c) {
        List<Object> lista = new ArrayList();
        getCollection().aggregate(lista);
    }

    @Override
    public Cliente consultarUno(int id) {
        // consultar todos los datos
        // org.bson.Document
        Document filtro = new Document();
        filtro.append("id", id);
        FindIterable<Document> cursor = getCollection().find(filtro);
        
        //cursor.forEach(c -> r = c);
        for(Document c : cursor){
            String nombre = c.get("nombre").toString();
            Cliente cliente = new Cliente(nombre);
            return cliente;
        }
        return null;
    }

    @Override
    public ArrayList<Cliente> consultar() {
        // consultar todos los datos
        ArrayList<Cliente> r = new ArrayList<>();
        // Cursor de datos - consulta a base de datos
        FindIterable<Document> cursor = getCollection().find(); // consultar todos los datos
        cursor.forEach(c -> {
            String nombreUsuario = c.get("nombre").toString();
            //int id = Integer.parseInt(c.get("ID").toString());
            // el que sea...
            Cliente cliente = new Cliente(nombreUsuario);
            r.add(cliente);
        });
        return r;
    }
    
}
