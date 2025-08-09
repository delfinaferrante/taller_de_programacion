/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial3;

/**
 *
 * @author Delfi
 */
public class Parcial3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Minorista min = new Minorista(1, 6, true);
        Mayorista may = new Mayorista(3, 10, 764896329);
        
        Productos p1 = new Productos(15, 535.5, "papel higienico doble hoja");
        Productos p2 = new Productos(30, 1290.6, "pasta dental colgate");
        Productos p3 = new Productos(99, 2560.2, "pan lactal multicereal");
        
        min.agregarProducto(p1);
        min.agregarProducto(p2);
        min.agregarProducto(p3);
        
        Productos p4 = new Productos(1, 3900.1, "queso crema casancrem");
        Productos p5 = new Productos(3, 2480.5, "bananas");
        Productos p6 = new Productos(64, 1300.5, "queso rallado sancor");
        Productos p7 = new Productos(80, 500, "turron arcor");
        Productos p8 = new Productos(76, 800, "jugo tang");
        
        may.agregarProducto(p4);
        may.agregarProducto(p5);
        may.agregarProducto(p6);
        may.agregarProducto(p7);
        may.agregarProducto(p8);
        
        System.out.println(min.toString());
        System.out.println(may.toString());
    }
    
}
