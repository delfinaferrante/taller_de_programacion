/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales;

/**
 *
 * @author Usuario
 */
public class Parcial5 {
    public static void main(String[]args){
        BancoTradicional bt = new BancoTradicional("Banco Provincia", 20, 4, "Hipolito Yrigoyen 450", "Buenos Aires");
        BancoDigital bd = new BancoDigital("Banco BBVA LINK", 4, 7, "www.bbva.com");
        
        Cuenta c1 = new Cuenta(1003064, "delfinaferrante.mp", "pesos");
        Cuenta c2 = new Cuenta(582644, "foco.lupa.queso", "dolares");
        Cuenta c3 = new Cuenta(9986000, "ferminmoras", "pesos");
        bt.agregarCuenta(c1);
        bt.agregarCuenta(c2);
        bt.agregarCuenta(c3);
        
        Cuenta c4 = new Cuenta(18350, "roco.mesa.silla", "dolares");
        Cuenta c5 = new Cuenta(33333, "tronco.sirena.cola", "pesos");
        Cuenta c6 = new Cuenta(5926000, "pameferrante.mp", "pesos");
        bd.agregarCuenta(c4);
        bd.agregarCuenta(c5);
        bd.agregarCuenta(c6);
        
        bt.depositarDinero(582644, 50000);
        bd.depositarDinero(5926000, 1506000);
        
        System.out.println(c2.getMonto());
        System.out.println(c6.getMonto());
        
        System.out.println(bt.puedeRecibirTarjeta(1003064));
        System.out.println(bd.puedeRecibirTarjeta(5926000));

    }
}
