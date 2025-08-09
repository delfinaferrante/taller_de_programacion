/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA4;


public abstract class Figura {
    private String colorRelleno;
    private String colorLinea;
   
    public Figura(String unCR, String unCL){
        setColorRelleno(unCR);
        setColorLinea(unCL);
    }
      
    public String getColorRelleno(){
        return colorRelleno;       
    }
    public void setColorRelleno(String unColor){
        colorRelleno = unColor;       
    }
    public String getColorLinea(){
        return colorLinea;       
    }
    public void setColorLinea(String unColor){
        colorLinea = unColor;       
    }
    public void despintar(){
        colorLinea = "Negro";
        colorRelleno = "Blanco";
    }
    
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
     
    public String toString(){
       String aux = "Area: " + this.calcularArea() +
                     " / Perimetro: " + this.calcularPerimetro() + 
                     " / Color Relleno: "  + getColorRelleno() + 
                     " / Color Linea: " + getColorLinea();             
       return aux;
    }
}

