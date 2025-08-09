/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial8;

/**
 *
 * @author fer_m
 */
public class Parcial8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SitioAmateur amateur = new SitioAmateur("Betsson", "Buenos Aires");
        amateur.registrarTorneoAmateur(50);
        System.out.println(amateur.cotizarSitio());
        System.out.println(amateur.toString());
    }
    
}
