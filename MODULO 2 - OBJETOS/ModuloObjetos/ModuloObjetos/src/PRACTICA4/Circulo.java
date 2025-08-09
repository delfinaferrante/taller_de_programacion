/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA4;

/**
 *
 * @author Usuario
 */
public class Circulo extends Figura{
    private double radio;
    
    public Circulo(double radio, String unColorR, String unColorL){
        super(unColorR, unColorL);
        setRadio(radio);
    }
    
    public double getRadio(){
        return radio;
    }
    public void setRadio(double unRadio){
        radio = unRadio;
    }
    
    public double calcularPerimetro(){
        return (2*(Math.PI * this.radio));
    }
    
    public double calcularArea(){
      return (Math.PI * (radio*radio));
    }
    
    public String toString(){
        String aux = " ";
        aux += super.toString() + " - Radio: " + getRadio();
        return aux;
    }
}
