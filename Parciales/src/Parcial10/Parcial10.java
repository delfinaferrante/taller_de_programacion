/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial10;

/**
 *
 * @author fer_m
 */
public class Parcial10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Supermercado s = new Supermercado("Beijing", "Lamadrid 95", 3, 4);  //3 filas, 4 columnas
        Producto p1 = new Producto(55, "galletitas", "arcor", 5, 2549);
        Producto p2 = new Producto(1, "leche", "la serenisima", 45, 1365);
        Producto p3 = new Producto(33, "yogurt", "milkaut", 30, 4763);
        Producto p4 = new Producto(67, "lavandina", "procenex", 864, 1996);
        
        s.registrarProducto(p1); //gondola 0, estante 0 
        s.registrarProducto(p2); //gondola 0, estante 1 
        s.registrarProducto(p3); //gondola 0, estante 2 
        s.registrarProducto(p4); //gondola 0, estante 3 
       
        s.registrarProducto(p1); //gondola 1, estante 0 
        s.registrarProducto(p2); //gondola 1, estante 1
        
        System.out.println(s.imprimirProductos("arcor", 1));
        System.out.println(s.toString());
    }
    
}
