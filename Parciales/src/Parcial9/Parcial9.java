/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial9;

/**
 *
 * @author fer_m
 */
public class Parcial9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pan pan1 = new Pan("de molde", 2500, "premium");
        Sandwich s = new Sandwich("CAPRESSE", pan1, 3);
        
        Ingrediente ing1 = new Ingrediente("Tomate", 550, "A");
        Ingrediente ing2 = new Ingrediente("Queso", 3405, "B");
        Ingrediente ing3 = new Ingrediente("Albahaca", 150, "A");
        Ingrediente ing4 = new Ingrediente("Pesto", 1352, "B");
        s.agregarIngrediente(ing1);
        s.agregarIngrediente(ing2);
        s.agregarIngrediente(ing3);
        s.agregarIngrediente(ing4);
        
        System.out.println(s.toString());
    }
    
}
