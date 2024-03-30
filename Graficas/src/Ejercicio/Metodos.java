/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio;

/**
 *
 * @author brand
 */
public class Metodos {
    
    Nodo cabeza;
    
    public Metodos(){
        
        cabeza = null;
        
    }
    
    public void agregar(Nodo n) {
        if (cabeza == null) {
            cabeza = n;
        } else {
            Nodo apuntador = cabeza;
            while (apuntador.siguiente != null) {

                apuntador = apuntador.siguiente;
            }
            apuntador.siguiente = n;
        }
        n.siguiente = null;
    }
    
}
