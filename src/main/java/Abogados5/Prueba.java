/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abogados5;

/**
 *
 * @author yo
 */
import java.util.ArrayList;
public class Prueba {
    private static final ArrayList<Integer> ids = new ArrayList<>();
    public Prueba(){
        initPersistencia();
    }
    
    public void printPersistencia(){
        // ademas de ser callback..
        // expresión lambda
        ids.forEach(id -> {
            System.out.println("El id actual es : "+id);
        });
    }
    
    private void initPersistencia(){
        // Simulación de SELECT ID FROM CLIENTES;
        int i = 0;
        for(; i < 100; i++) ids.add(i);
        System.out.println("Last ID: "+(i-1));
    }
  
//    public static void main(String[] args){
//        Prueba p = new Prueba();
//        p.printPersistencia();
//    }
}
