/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA4;

public class Triangulo extends Figura {
    private double lado1, lado2, lado3;
    
    public Triangulo(double lado1, double lado2, double lado3, String unColorR, String unColorL){
        super(unColorR, unColorL);
        setLado1(lado1);
        setLado2(lado2);
        setLado3(lado3);
    }
    public double getLado1(){
        return lado1;
    }
    public void setLado1(double unLado){
        lado1 = unLado;
    }
    public double getLado2(){
        return lado2;
    }
    public void setLado2(double otroLado){
        lado2 = otroLado;
    }
    public double getLado3(){
        return lado3;
    }
    public void setLado3(double otroLado3){
        lado3 = otroLado3;
    }
    
    public double calcularPerimetro(){
        return (lado1+lado2+lado3);
    }
    
    public double calcularArea(){
        double s = (lado1+ lado2+ lado3)/2;
        return Math.sqrt(s*(s-lado1)*(s-lado2)*(s-lado3));
    }
    
    public String toString(){
        String aux = " ";
        aux += super.toString() + " - Lado1: " + getLado1() + " - Lado2: " + getLado2() + "  Lado3: " + getLado3();
        return aux;
    }
}
